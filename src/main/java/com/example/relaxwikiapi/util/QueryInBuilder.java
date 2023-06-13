package com.example.relaxwikiapi.util;

import java.util.Collection;

public abstract class QueryInBuilder {

    public static <T> String buildSQLINQuery(Collection<T> values) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (T val : values) {
            sb.append("'");
            sb.append(val);
            sb.append("'");
            if (i != values.size() - 1)
                sb.append(",");

            i++;
        }
        return sb.toString();
    }
}
