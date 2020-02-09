package cookies.service.cookiemaps;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cookies.models.CookieMap;

@Repository
public class CookieMapsPersistorImpl implements CookieMapsPersistor {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CookieMapsPersistorImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<CookieMap> getCookieMaps(Long containerNum) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("containerNum", containerNum);
        return this.namedParameterJdbcTemplate.query(CookieMapsQueryBuilder.SELECT_COOKIE_MAPS, parameters,
            (ResultSet rs, int rowNum) -> {
                CookieMap cookieMap = new CookieMap();
                cookieMap.setMapNum(rs.getLong("map_num"));
                cookieMap.setContainerNum(rs.getLong("container_num"));
                cookieMap.setName(rs.getString("name"));
                return cookieMap;
            });
    }
    
}