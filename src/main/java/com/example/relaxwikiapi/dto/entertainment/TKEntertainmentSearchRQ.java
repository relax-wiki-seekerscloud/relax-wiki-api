package com.example.relaxwikiapi.dto.entertainment;

import com.example.relaxwikiapi.constants.AppsConstants;

import java.util.ArrayList;
import java.util.List;

public class TKEntertainmentSearchRQ {

    private String location;

    private String dateStr;

    private String numberOfPeople;

    private List<AppsConstants.FilterByBudget> filterByBudgetArr;

    private List<AppsConstants.StarCategory> filterByRatingsArr;

    private List<AppsConstants.EntertainmentActivity> filterByActivityArr;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

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

    public List<AppsConstants.EntertainmentActivity> getFilterByActivityArr() {
        if (filterByActivityArr == null) {
            filterByActivityArr = new ArrayList<>();
        }
        return filterByActivityArr;
    }

    public void setFilterByActivityArr(List<AppsConstants.EntertainmentActivity> filterByActivityArr) {
        this.filterByActivityArr = filterByActivityArr;
    }
}
