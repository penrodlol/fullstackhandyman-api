package cookies.service;

public class CookieQueryBuilder {

    private static final String COOKIE_MAPS_CONTAINER_TABLE = "fullstackhandyman.cookie_maps_container";
    private static final String COOKIE_MAP_TABLE = "fullstackhandyman.cookie_maps";
    private static final String COOKIES_TABLE = "fullstackhandyman.cookies";

    public static final String SELECT_COOKIE_MAPS_CONTAINERS = "SELECT * FROM " + COOKIE_MAPS_CONTAINER_TABLE;

    private static final String SELECT_COOKIE_MAPS = "SELECT * FROM " + COOKIE_MAP_TABLE;
    private static final String WHERE_COOKIE_MAP_CONTAINER_NUM_EQL = " WHERE container_num = :containerNum";
    public static final String SELECT_COOKIE_MAPS_WITH_CONTAINER_NUMS_SQL = SELECT_COOKIE_MAPS + WHERE_COOKIE_MAP_CONTAINER_NUM_EQL;

    private static final String SELECT_COOKIES = "SELECT * FROM " + COOKIES_TABLE;
    private static final String WHERE_MAP_NUM_EQL = " WHERE map_num = :mapNum";
    public static final String SELECT_COOKIES_WITH_MAP_NUM_SQL = SELECT_COOKIES + WHERE_MAP_NUM_EQL;

    public static final String INSERT_COOKIE_MAPS_CONTAINER =
    "INSERT INTO " + COOKIE_MAPS_CONTAINER_TABLE + "(name)\n"
    + "VALUES(:name)";
}