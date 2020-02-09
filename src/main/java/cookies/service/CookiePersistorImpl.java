package cookies.service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import cookies.models.CookieMapsContainer;
import exception.model.ExceptionMessages;
import exception.model.custom.CookieException;
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
            cookieMapsContainer.setTag(rs.getString("tag"));
            return cookieMapsContainer;
        });
    }

    @Override
    public CookieMapsContainer insertCookieMapContainer(String name, String tag) throws Exception {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        KeyHolder newContainerNum = new GeneratedKeyHolder();
        parameters.addValue("name", name);
        parameters.addValue("tag", tag);
        int rows = this.namedParameterJdbcTemplate.update(CookieQueryBuilder.INSERT_COOKIE_MAPS_CONTAINER, parameters,
                newContainerNum);

        if (rows <= 0) throw new CookieException(name + ExceptionMessages.ALREADY_EXISTS.getExMsg());

        CookieMapsContainer cookieMapsContainer = new CookieMapsContainer();
        Long containerNum = newContainerNum.getKey().longValue();
        cookieMapsContainer.setContainerNum(containerNum);
        cookieMapsContainer.setName(name);
        cookieMapsContainer.setTag(tag);
        return cookieMapsContainer;
    }

    @Override
    public CookieMapsContainer editCookieMapContainer(CookieMapsContainer cookieMapsContainer) throws Exception {
        if (Utils.isEmptyString(cookieMapsContainer.getName()) || Utils.isEmptyString(cookieMapsContainer.getTag())) {
            throw new CookieException(buildUpdateExceptionMsg("container. Both container name and tag cannot be empty."));
        }

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("containerNum", cookieMapsContainer.getContainerNum());
        parameters.addValue("containerName", cookieMapsContainer.getName());
        parameters.addValue("containerTag", cookieMapsContainer.getTag());

        int rows = this.namedParameterJdbcTemplate.update(CookieQueryBuilder.UPDATE_COOKIE_MAPS_CONTAINER, parameters);
        if (rows <= 0) throw new CookieException(buildUpdateExceptionMsg("container. Your container name is likely already in use or doesn't exist."));

        return cookieMapsContainer;
    }

    @Override
    public Long deleteCookieMapContainer(Long containerNum) throws Exception {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("containerNum", containerNum);
        int rows = this.namedParameterJdbcTemplate.update(CookieQueryBuilder.DELETE_COOKIE_MAPS_CONTAINER, parameters);

        if (rows <= 0) throw new CookieException(ExceptionMessages.UNABLE_TO_DELETE.getExMsg() + containerNum.toString());

        return containerNum;
    }

    private String buildUpdateExceptionMsg(String cutomMsg) {
        StringBuilder errorUpdatingCookieMapsContainerMsg = new StringBuilder();
        errorUpdatingCookieMapsContainerMsg.append(ExceptionMessages.UNABLE_TO_UPDATE.getExMsg());
        errorUpdatingCookieMapsContainerMsg.append(cutomMsg);
        return errorUpdatingCookieMapsContainerMsg.toString();
    }
}