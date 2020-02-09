package cookies.service.cookiemaps;

import common.CommonSQL;
import common.SQLTables;

public class CookieMapsQueryBuilder {

    // Gets all cookie maps from specified container.
    public static final String SELECT_COOKIE_MAPS = CommonSQL.SELECT_ALL.getSqlStatement()
    + SQLTables.COOKIE_MAPS.getTable()
    + " WHERE container_num = :containerNum";
}