package cookies.service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cookies.models.Cookie;
import cookies.models.CookieMap;
import cookies.models.CookieMapsContainer;

@Repository
public class CookiePersistorImpl implements CookiePersistor {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CookiePersistorImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<CookieMapsContainer> getCookieMapsContainers() {
        return this.jdbcTemplate.query(CookieQueryBuilder.SELECT_COOKIE_MAPS_CONTAINERS, (ResultSet rs, int rowNum) -> {
            CookieMapsContainer cookieMapsContainer = new CookieMapsContainer();
            cookieMapsContainer.setContainerNum(rs.getInt("container_num"));
            cookieMapsContainer.setName(rs.getString("name"));
            return cookieMapsContainer;
        });
    }

    @Override
    public List<CookieMap> getCookieMaps(Integer containerNum) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("containerNum", containerNum);

        return this.namedParameterJdbcTemplate.query(CookieQueryBuilder.SELECT_COOKIE_MAPS_WITH_CONTAINER_NUMS_SQL, parameters,
            (ResultSet rs, int rowNum) -> {
                CookieMap cookieMap = new CookieMap();
                cookieMap.setContainerNum(rs.getInt("container_num"));
                cookieMap.setName(rs.getString("name"));
                return cookieMap;
            });
    }

    @Override
    public List<Cookie> getCookies(Integer mapNum) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("mapNum", mapNum);

        return this.namedParameterJdbcTemplate.query(CookieQueryBuilder.SELECT_COOKIES_WITH_MAP_NUM_SQL, parameters,
            (ResultSet rs, int rowNum) -> {
                Cookie cookie = new Cookie();
                cookie.setMapNum(rs.getInt("map_num"));
                cookie.setName(rs.getString("name"));
                cookie.setValue(rs.getString("value"));
                return cookie;
            });
    }

    @Override
    public void createCookieMapContainer(String name) {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", name);
        this.namedParameterJdbcTemplate.update(CookieQueryBuilder.INSERT_COOKIE_MAPS_CONTAINER, parameters);
    }
}