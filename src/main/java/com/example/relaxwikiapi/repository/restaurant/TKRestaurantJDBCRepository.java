package com.example.relaxwikiapi.repository.restaurant;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.dto.hotel.TKHotelDTO;
import com.example.relaxwikiapi.dto.restaurant.TKRestaurantDTO;
import com.example.relaxwikiapi.dto.restaurant.TKRestaurantSearchRQ;
import com.example.relaxwikiapi.util.QueryInBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TKRestaurantJDBCRepository {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<TKRestaurantDTO> searchRestaurants(TKRestaurantSearchRQ searchRQ) {
        final List<TKRestaurantDTO> results = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();

        SQL.append("SELECT r.restaurant_id, \n");
        SQL.append("       r.address, \n");
        SQL.append("       r.has_free_cancellation, \n");
        SQL.append("       r.restaurant_condition, \n");
        SQL.append("       r.restaurant_name, \n");
        SQL.append("       r.star_category \n");
        SQL.append("FROM tk_restaurant r \n");
        SQL.append("WHERE r.restaurant_id IS NOT NULL \n");

        if (StringUtils.isNotEmpty(searchRQ.getLocation())) {
            SQL.append("AND UPPER(r.address) LIKE '%" + searchRQ.getLocation().toUpperCase() + "%' \n");
        }

        if (!searchRQ.getFilterByRatingsArr().isEmpty()) {
            SQL.append("      AND r.star_category IN (" + QueryInBuilder.buildSQLINQuery(searchRQ.getFilterByRatingsArr()) + ") \n");
        }

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<>() {

            @Nullable
            @Override
            public List<TKRestaurantDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    TKRestaurantDTO restaurantDTO = new TKRestaurantDTO();

                    restaurantDTO.setRestaurantID(rs.getLong("restaurant_id"));
                    restaurantDTO.setRestaurantName(rs.getString("restaurant_name"));
                    restaurantDTO.setAddress(rs.getString("address"));
                    restaurantDTO.setHasFreeCancellation(AppsConstants.YesNo.resolver(rs.getString("has_free_cancellation")));
                    restaurantDTO.setRestaurantCondition(AppsConstants.HotelCondition.resolveHotelCondition(rs.getString("restaurant_condition")));
                    restaurantDTO.setStarCategory(AppsConstants.StarCategory.resolveStarCategory(rs.getString("star_category")));

                    results.add(restaurantDTO);
                }
                return results;
            }
        });
    }
}
