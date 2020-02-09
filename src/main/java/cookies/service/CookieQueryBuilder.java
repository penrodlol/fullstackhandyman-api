package cookies.service;

import cookies.models.CookieTablesEnum;

public class CookieQueryBuilder {

    // UNIVERSAL QUERIES.
    private static final String WHERE_EXISTS = "WHERE EXISTS(SELECT 1 FROM %s WHERE %s)";
    private static final String WHERE_NOT_EXISTS = "WHERE NOT EXISTS(SELECT 1 FROM %s WHERE %s)";
    // --------------------

    // BASIC SELECTS FOR TABLES.
    private static final String SELECT_ALL_FROM = "SELECT * FROM ";
    
    public static final String SELECT_COOKIE_MAPS_CONTAINERS = SELECT_ALL_FROM + CookieTablesEnum.COOKIE_MAPS_CONTAINER.getTable();
    // --------------------

    // INSERTIONS INTO TABLES
    private static final String INSERT_INTO = "INSERT INTO ";

    public static final String INSERT_COOKIE_MAPS_CONTAINER =
    INSERT_INTO + CookieTablesEnum.COOKIE_MAPS_CONTAINER.getTable() + "(name, tag) "
    + "SELECT :name, :tag "
    + String.format(WHERE_NOT_EXISTS, CookieTablesEnum.COOKIE_MAPS_CONTAINER.getTable(), "name = :name");
    // --------------------

    // UPDATE TABLES
    private static final String UPDATE_TABLE = "UPDATE %s ";
    private static final String SET_VALUE = "SET %s = %s";

    public static final String UPDATE_COOKIE_MAPS_CONTAINER =
    String.format(UPDATE_TABLE, CookieTablesEnum.COOKIE_MAPS_CONTAINER.getTable())
    + String.format(SET_VALUE, "name", ":containerName") + ",tag = :containerTag"
    + " WHERE container_num = :containerNum";
    // --------------------
}