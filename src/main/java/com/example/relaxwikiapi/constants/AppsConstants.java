package com.example.relaxwikiapi.constants;

import org.apache.commons.lang3.StringUtils;

public class AppsConstants {

    public enum ResponseStatus {
        SUCCESS, FAILED;

        public static ResponseStatus resolveStatus(String statusStr) {
            ResponseStatus matchingStatus = null;
            if (!StringUtils.isEmpty(statusStr)) {
                matchingStatus = ResponseStatus.valueOf(statusStr.trim());
            }
            return matchingStatus;
        }
    }

    public enum HotelCondition {
        BAD("Bad"),
        GOOD("Good"),
        VERY_GOOD("Very Good"),
        EXCELLENT("Excellent");

        private final String description;

        HotelCondition(String description) {
            this.description = description;
        }

        public static HotelCondition resolveHotelCondition(String val) {
            HotelCondition matchingVal = null;
            if (val != null) {
                matchingVal = HotelCondition.valueOf(val);
            }
            return matchingVal;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum StarCategory {
        ONE("One"),
        TWO("Two"),
        THREE("Three"),
        FOUR("Four"),
        FIVE("Five"),
        NOT_RATED("Not rated");

        private final String description;

        StarCategory(String description) {
            this.description = description;
        }

        public static StarCategory resolveStarCategory(String val) {
            StarCategory matchingVal = null;
            if (val != null) {
                matchingVal = StarCategory.valueOf(val);
            }
            return matchingVal;
        }

        public String getDescription() {
            return description;
        }
    }

    //Yes --> True
    //No --> False
    public enum YesNo {
        Y("Yes"),
        N("No");

        private String strVal;

        YesNo(String strVal) {
            this.strVal = strVal;
        }

        public static YesNo resolver(String val) {
            YesNo matchingVal = null;
            if (val != null) {
                matchingVal = YesNo.valueOf(val);
            }
            return matchingVal;
        }

        public String getStrVal() {
            return strVal;
        }
    }

    public enum EntertainmentActivity {
        ADVENTURE("Adventure"),
        SPORTS("Sports"),
        ATTRACTION("Attraction");

        private final String description;

        EntertainmentActivity(String description) {
            this.description = description;
        }

        public static EntertainmentActivity resolveEntertainmentActivity(String val) {
            EntertainmentActivity matchingVal = null;
            if (val != null) {
                matchingVal = EntertainmentActivity.valueOf(val);
            }
            return matchingVal;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum FilterByBudget {
        ONE("$0-$50"),
        TWO("$50-$100"),
        THREE("$100-$150"),
        FOUR("$150-$200"),
        FIVE("$200-$250"),
        SIX("$250+");

        private final String description;

        FilterByBudget(String description) {
            this.description = description;
        }

        public static FilterByBudget resolveFilterByBudget(String val) {
            FilterByBudget matchingVal = null;
            if (val != null) {
                matchingVal = FilterByBudget.valueOf(val);
            }
            return matchingVal;
        }

        public String getDescription() {
            return description;
        }
    }
}
