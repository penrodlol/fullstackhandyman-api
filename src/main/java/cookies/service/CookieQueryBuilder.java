package cookies.service;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class CookieQueryBuilder {

    private static final String COOKIES_TABLE = "fullstackhandyman.cookies";
    private static final String COOKIE_MAP_TABLE = "fullstackhandyman.cookie_map";

    private static final String SELECT_COOKIE_MAP_NAME_COUNT_SQL = 
    "SELECT COUNT(CASE\n"
    + "  WHEN name = :name THEN name\n"
    + "  END) AS name_count\n"
    + " FROM " + COOKIE_MAP_TABLE;

    public static final String INSERT_COOKIE_MAP_SQL =
    "INSERT INTO " + COOKIE_MAP_TABLE + " (name)\n"
    + " VALUES(:cookieMapName);\n";

    public static final String INSERT_COOKIE_SQL =
    "INSERT INTO " + COOKIES_TABLE + " (cookie_num, name, value)\n"
    + " VALUES(\n"
    + " (SELECT cookie_num from " + COOKIE_MAP_TABLE + " WHERE name = ?),\n"
    + " ?, ?\n"
    + " );\n";

    public static String cookieMapNameCount(MapSqlParameterSource parameters, String name) {
        parameters.addValue("name", name);
        return SELECT_COOKIE_MAP_NAME_COUNT_SQL;
    }
}