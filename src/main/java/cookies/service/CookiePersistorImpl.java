package cookies.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import cookies.models.CookieMapsContainer;
import utils.Utils;

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
            cookieMapsContainer.setContainerNum(rs.getLong("container_num"));
            cookieMapsContainer.setName(rs.getString("name"));
            return cookieMapsContainer;
        });
    }

    @Override
    public CookieMapsContainer insertCookieMapContainer(String name) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        KeyHolder newContainerNum = new GeneratedKeyHolder();
        parameters.addValue("name", name);
        int rows = this.namedParameterJdbcTemplate.update(CookieQueryBuilder.INSERT_COOKIE_MAPS_CONTAINER, parameters,
                newContainerNum);

        if (rows <= 0)
            return null;

        CookieMapsContainer cookieMapsContainer = new CookieMapsContainer();
        Long containerNum = newContainerNum.getKey().longValue();
        cookieMapsContainer.setContainerNum(containerNum);
        cookieMapsContainer.setName(name);
        return cookieMapsContainer;
    }
}