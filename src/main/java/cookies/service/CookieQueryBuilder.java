package cookies.service;

public class CookieQueryBuilder {

    // BASIC SELECTS FOR TABLES.
    public static final String SELECT_COOKIE_MAPS_CONTAINERS = "SELECT * FROM " + CookieTablesEnum.COOKIE_MAPS_CONTAINER.getTable();

    // INSERTIONS INTO TABLES
    public static final String INSERT_COOKIE_MAPS_CONTAINER =
    "INSERT INTO " + CookieTablesEnum.COOKIE_MAPS_CONTAINER.getTable() + "(name)\n"
    + "SELECT :name\n"
    + "WHERE NOT EXISTS(SELECT 1 FROM " + CookieTablesEnum.COOKIE_MAPS_CONTAINER.getTable() + " WHERE name = :name)\n";
}