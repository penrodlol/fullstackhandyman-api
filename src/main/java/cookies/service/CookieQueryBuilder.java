package cookies.service;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class CookieQueryBuilder {

    private static final String COOKIES_SQL = "SELECT * FROM fullstackhandyman.cookies";

    public static String cookieQueryBuilder(MapSqlParameterSource parameters) {
        return COOKIES_SQL;
    }
}