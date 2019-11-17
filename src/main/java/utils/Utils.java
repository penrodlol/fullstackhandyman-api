package utils;

import java.util.Collection;

public class Utils {
    public static Boolean isEmptyString(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static Boolean isEmptyCollection(Collection<?> col) {
        return col.size() == 0 || col.isEmpty();
    }
}