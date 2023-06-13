package com.example.relaxwikiapi.repository.entertainment;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentDTO;
import com.example.relaxwikiapi.dto.entertainment.TKEntertainmentSearchRQ;
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
public class TKEntertainmentJDBCRepository {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<TKEntertainmentDTO> searchEntertainments(TKEntertainmentSearchRQ searchRQ) {
        final List<TKEntertainmentDTO> results = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();

        SQL.append("SELECT entertainment_id, \n");
        SQL.append("       address, \n");
        SQL.append("       activity, \n");
        SQL.append("       has_free_cancellation, \n");
        SQL.append("       main_description, \n");
        SQL.append("       number_of_people, \n");
        SQL.append("       owner, \n");
        SQL.append("       price, \n");
        SQL.append("       star_category, \n");
        SQL.append("       sub_description, \n");
        SQL.append("       title \n");
        SQL.append("FROM tk_entertainment e \n");
        SQL.append("WHERE e.entertainment_id IS NOT NULL \n");

        if (StringUtils.isNotEmpty(searchRQ.getLocation())) {
            SQL.append("AND UPPER(e.address) LIKE '%" + searchRQ.getLocation().toUpperCase() + "%' \n");
        }
        if (StringUtils.isNotEmpty(searchRQ.getNumberOfPeople())) {
            SQL.append(" AND e.number_of_people >= :numberOfPeople ");
            params.put("numberOfPeople", searchRQ.getNumberOfPeople());
        }

        if (!searchRQ.getFilterByRatingsArr().isEmpty()) {
            SQL.append("      AND e.star_category IN (" + QueryInBuilder.buildSQLINQuery(searchRQ.getFilterByRatingsArr()) + ") \n");
        }

        if (!searchRQ.getFilterByActivityArr().isEmpty()) {
            SQL.append("      AND e.activity IN (" + QueryInBuilder.buildSQLINQuery(searchRQ.getFilterByActivityArr()) + ") \n");
        }

        for (AppsConstants.FilterByBudget filterByBudget : searchRQ.getFilterByBudgetArr()) {
            switch (filterByBudget) {
                case ONE -> SQL.append(" AND e.price BETWEEN 0 AND 50 ");
                case TWO -> SQL.append(" AND e.price BETWEEN 50 AND 100 ");
                case THREE -> SQL.append(" AND e.price BETWEEN 100 AND 150 ");
                case FOUR -> SQL.append(" AND e.price BETWEEN 150 AND 200 ");
                case FIVE -> SQL.append(" AND e.price BETWEEN 200 AND 250 ");
                case SIX -> SQL.append(" AND e.price > 250 ");
            }
        }

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<>() {

            @Nullable
            @Override
            public List<TKEntertainmentDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    TKEntertainmentDTO entertainmentDTO = new TKEntertainmentDTO();

                    entertainmentDTO.setEntertainmentID(rs.getLong("entertainment_id"));
                    entertainmentDTO.setAddress(rs.getString("address"));
                    entertainmentDTO.setOwner(rs.getString("owner"));
                    entertainmentDTO.setTitle(rs.getString("title"));
                    entertainmentDTO.setMainDescription(rs.getString("main_description"));
                    entertainmentDTO.setSubDescription(rs.getString("sub_description"));
                    entertainmentDTO.setNumberOfPeople(rs.getInt("number_of_people"));
                    entertainmentDTO.setPrice(rs.getDouble("price"));
                    entertainmentDTO.setHasFreeCancellation(AppsConstants.YesNo.resolver(rs.getString("has_free_cancellation")));
                    entertainmentDTO.setEntertainmentActivity(AppsConstants.EntertainmentActivity.resolveEntertainmentActivity(rs.getString("activity")));
                    entertainmentDTO.setStarCategory(AppsConstants.StarCategory.resolveStarCategory(rs.getString("star_category")));

                    results.add(entertainmentDTO);
                }
                return results;
            }
        });
    }
}
