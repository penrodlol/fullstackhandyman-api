package cookies.service.cookiemapscontainer;

import common.CommonSQL;
import common.SQLTables;

public class CookieMapsContainerQueryBuilder {
    private static final String SET_VALUE = "SET %s = %s";
    
    // Gets all cookie maps containers.
    public static final String SELECT_COOKIE_MAPS_CONTAINERS = CommonSQL.SELECT_ALL.getSqlStatement() 
    + SQLTables.COOKIE_MAPS_CONTAINER.getTable();

    // Inserts single record into cookie maps containers table.
    public static final String INSERT_COOKIE_MAPS_CONTAINER =
    String.format(CommonSQL.INSERT_INTO_TABLE.getSqlStatement(), SQLTables.COOKIE_MAPS_CONTAINER.getTable()) + "(name, tag) "
    + "SELECT :name, :tag "
    + String.format(CommonSQL.WHERE_NOT_EXISTS.getSqlStatement(), SQLTables.COOKIE_MAPS_CONTAINER.getTable(), "name = :name");

    // Updates a single record from cookie maps container table.
    public static final String UPDATE_COOKIE_MAPS_CONTAINER =
    String.format(CommonSQL.UPDATE_TABLE.getSqlStatement(), SQLTables.COOKIE_MAPS_CONTAINER.getTable())
    + String.format(SET_VALUE, "name", ":containerName") + ",tag = :containerTag"
    + " WHERE container_num = :containerNum";

    // Deletes a single record from cookie maps container table.
    public static final String DELETE_COOKIE_MAPS_CONTAINER =
    String.format(CommonSQL.DELETE_FROM_TABLE.getSqlStatement(), SQLTables.COOKIE_MAPS_CONTAINER.getTable())
    + " WHERE container_num = :containerNum";
}