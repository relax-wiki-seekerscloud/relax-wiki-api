package com.example.relaxwikiapi.dto.restaurant;

import com.example.relaxwikiapi.constants.AppsConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKRestaurantSearchRQ {

    private String location;

    private String dateStr;

    private String timeStr;

    private Integer numOfPeople;

    private List<AppsConstants.FilterByBudget> filterByBudgetArr;

    private List<AppsConstants.StarCategory> filterByRatingsArr;

    public List<AppsConstants.FilterByBudget> getFilterByBudgetArr() {
        if (filterByBudgetArr == null) {
            filterByBudgetArr = new ArrayList<>();
        }
        return filterByBudgetArr;
    }

    public void setFilterByBudgetArr(List<AppsConstants.FilterByBudget> filterByBudgetArr) {
        this.filterByBudgetArr = filterByBudgetArr;
    }

    public List<AppsConstants.StarCategory> getFilterByRatingsArr() {
        if (filterByRatingsArr == null) {
            filterByRatingsArr = new ArrayList<>();
        }
        return filterByRatingsArr;
    }

    public void setFilterByRatingsArr(List<AppsConstants.StarCategory> filterByRatingsArr) {
        this.filterByRatingsArr = filterByRatingsArr;
    }
}
