package cookies.service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cookies.Cookie;

@Repository
public class CookiePersistorImpl implements CookiePersistor {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CookiePersistorImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Cookie> getCookies() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String cookieStringQuery = CookieQueryBuilder.cookieQueryBuilder(parameters);
        return this.namedParameterJdbcTemplate.query(cookieStringQuery, parameters,
            (ResultSet rs, int rowNum) -> {
                Cookie cookie = new Cookie();
                cookie.setName(rs.getString("name"));
                cookie.setValue(rs.getString("value"));
                return cookie;
            });
    }

}