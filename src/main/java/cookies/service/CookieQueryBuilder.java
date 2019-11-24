package cookies.service;

public class CookieQueryBuilder {

    private static final String COOKIE_MAPS_CONTAINER_TABLE = "fullstackhandyman.cookie_maps_container";
    private static final String COOKIE_MAPS_TABLE = "fullstackhandyman.cookie_maps";
    private static final String COOKIES_TABLE = "fullstackhandyman.cookies";

    public static final String SELECT_COOKIE_MAPS_CONTAINERS = "SELECT * FROM " + COOKIE_MAPS_CONTAINER_TABLE;

    private static final String SELECT_COOKIE_MAPS = "SELECT * FROM " + COOKIE_MAPS_TABLE;
    private static final String WHERE_COOKIE_MAP_CONTAINER_NUM_EQL = " WHERE container_num = :containerNum";
    private static final String AND_COOKIE_MAPS_NAME_EQL = " AND name = :mapName";
    public static final String SELECT_COOKIE_MAPS_WITH_CONTAINER_NUMS_SQL = SELECT_COOKIE_MAPS + WHERE_COOKIE_MAP_CONTAINER_NUM_EQL;
    public static final String SELECT_COOKIE_MAP_WITH_CONTAINER_AND_NAME = "SELECT map_num FROM " + COOKIE_MAPS_TABLE
    + WHERE_COOKIE_MAP_CONTAINER_NUM_EQL + AND_COOKIE_MAPS_NAME_EQL;

    private static final String SELECT_COOKIES = "SELECT * FROM " + COOKIES_TABLE;
    private static final String WHERE_MAP_NUM_EQL = " WHERE map_num = :mapNum";
    public static final String SELECT_COOKIES_WITH_MAP_NUM_SQL = SELECT_COOKIES + WHERE_MAP_NUM_EQL;

    public static final String INSERT_COOKIE_MAPS_CONTAINER =
    "INSERT INTO " + COOKIE_MAPS_CONTAINER_TABLE + "(name)\n"
    + "SELECT :name\n"
    + "WHERE NOT EXISTS(SELECT 1 FROM " + COOKIE_MAPS_CONTAINER_TABLE + " WHERE name = :name)\n";

    public static final String INSERT_COOKIE_MAPS =
    "INSERT INTO " + COOKIE_MAPS_TABLE + "(container_num, name)\n"
    + "SELECT :containerNum, :mapName\n"
    + "WHERE EXISTS(SELECT 1 FROM " + COOKIE_MAPS_CONTAINER_TABLE + " WHERE container_num = :containerNum)\n"
    + "AND NOT EXISTS(SELECT 1 FROM " + COOKIE_MAPS_TABLE + " WHERE container_num = :containerNum and name = :mapName)";

    public static final String INSERT_COOKIES =
    "INSERT INTO " + COOKIES_TABLE + " (map_num, name, value)\n"
    + "SELECT :mapNum, :name, :value\n"
    + "WHERE EXISTS(SELECT 1 FROM " + COOKIE_MAPS_TABLE + " WHERE map_num = :mapNum)";
}