package com.example.relaxwikiapi.repository.hotel;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.dto.hotel.TKHotelDTO;
import com.example.relaxwikiapi.dto.hotel.TKHotelSearchRQ;
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
public class TKHotelJDBCRepository {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<TKHotelDTO> searchHotels(TKHotelSearchRQ searchRQ) {
        final List<TKHotelDTO> results = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();

        SQL.append("SELECT hotel_id, \n");
        SQL.append("       hotel_name, \n");
        SQL.append("       address, \n");
        SQL.append("       has_free_cancellation, \n");
        SQL.append("       hotel_condition, \n");
        SQL.append("       main_description, \n");
        SQL.append("       number_of_rooms, \n");
        SQL.append("       price, \n");
        SQL.append("       star_category, \n");
        SQL.append("       sub_description_one, \n");
        SQL.append("       sub_description_two, \n");
        SQL.append("       has_air_conditioning, \n");
        SQL.append("       has_bathtub, \n");
        SQL.append("       has_city_view, \n");
        SQL.append("       has_free_wifi, \n");
        SQL.append("       has_parking_on_site, \n");
        SQL.append("       has_safety_deposit_box, \n");
        SQL.append("       has_swimming_pool \n");
        SQL.append("FROM tk_hotel tk \n");
        SQL.append("WHERE hotel_id IS NOT NULL \n");

        if (StringUtils.isNotEmpty(searchRQ.getHotelLocation())) {
            SQL.append("AND UPPER(tk.address) LIKE '%" + searchRQ.getHotelLocation().toUpperCase() + "%' \n");
        }

        if (searchRQ.getHotelRooms() != null) {
            SQL.append(" AND tk.number_of_rooms > :numOfRooms ");
            params.put("numOfRooms", searchRQ.getHotelRooms().toString());
        }

        if (!searchRQ.getFilterByRatingsArr().isEmpty()) {
            SQL.append("      AND tk.star_category IN (" + QueryInBuilder.buildSQLINQuery(searchRQ.getFilterByRatingsArr()) + ") \n");
        }

        for (AppsConstants.FilterByBudget filterByBudget : searchRQ.getFilterByBudgetArr()) {
            switch (filterByBudget) {
                case ONE -> SQL.append(" AND tk.price BETWEEN 0 AND 50 ");
                case TWO -> SQL.append(" AND tk.price BETWEEN 50 AND 100 ");
                case THREE -> SQL.append(" AND tk.price BETWEEN 100 AND 150 ");
                case FOUR -> SQL.append(" AND tk.price BETWEEN 150 AND 200 ");
                case FIVE -> SQL.append(" AND tk.price BETWEEN 200 AND 250 ");
                case SIX -> SQL.append(" AND tk.price > 250 ");
            }
        }

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<>() {

            @Nullable
            @Override
            public List<TKHotelDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    TKHotelDTO hotelDTO = new TKHotelDTO();

                    hotelDTO.setHotelID(rs.getLong("hotel_id"));
                    hotelDTO.setHotelName(rs.getString("hotel_name"));
                    hotelDTO.setAddress(rs.getString("address"));
                    hotelDTO.setMainDescription(rs.getString("main_description"));
                    hotelDTO.setSubDescriptionOne(rs.getString("sub_description_one"));
                    hotelDTO.setSubDescriptionTwo(rs.getString("sub_description_two"));
                    hotelDTO.setNumberOfRooms(rs.getInt("number_of_rooms"));
                    hotelDTO.setPrice(rs.getDouble("price"));
                    hotelDTO.setStarCategory(AppsConstants.StarCategory.resolveStarCategory(rs.getString("star_category")));
                    hotelDTO.setHotelCondition(AppsConstants.HotelCondition.resolveHotelCondition(rs.getString("hotel_condition")));
                    hotelDTO.setHasFreeCancellation(AppsConstants.YesNo.resolver(rs.getString("has_free_cancellation")));
                    hotelDTO.setHasAirConditioning(AppsConstants.YesNo.resolver(rs.getString("has_air_conditioning")));
                    hotelDTO.setHasBathtub(AppsConstants.YesNo.resolver(rs.getString("has_bathtub")));
                    hotelDTO.setHasCityView(AppsConstants.YesNo.resolver(rs.getString("has_city_view")));
                    hotelDTO.setHasFreeWifi(AppsConstants.YesNo.resolver(rs.getString("has_free_wifi")));
                    hotelDTO.setHasParkingOnSite(AppsConstants.YesNo.resolver(rs.getString("has_parking_on_site")));
                    hotelDTO.setHasSafetyDepositBox(AppsConstants.YesNo.resolver(rs.getString("has_safety_deposit_box")));
                    hotelDTO.setHasSwimmingPool(AppsConstants.YesNo.resolver(rs.getString("has_swimming_pool")));

                    results.add(hotelDTO);
                }
                return results;
            }
        });
    }
}
