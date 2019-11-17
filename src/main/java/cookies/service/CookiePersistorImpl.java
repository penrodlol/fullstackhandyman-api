package cookies.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cookies.models.Cookie;
import cookies.models.CookieMap;
import cookies.models.CookieTemplate;
import utils.Utils;

@Repository
public class CookiePersistorImpl implements CookiePersistor {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String DELIMETER = "~~~";

    public CookiePersistorImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<CookieTemplate> getCookieTemplates() {
        return this.namedParameterJdbcTemplate.query(CookieQueryBuilder.SELECT_COOKIE_TEMPLATES,
                new MapSqlParameterSource(), (ResultSet rs, int rowNum) -> {
                    CookieTemplate cookieTemplate = new CookieTemplate();

                    CookieMap cookieMap = new CookieMap();
                    cookieMap.setCookieNum(rs.getInt("cookie_num"));
                    cookieMap.setName(rs.getString("name"));
                    cookieTemplate.setCookieMap(cookieMap);

                    List<Cookie> cookies = new ArrayList<Cookie>();
                    ListIterator<String> cookieNamesIterator = Arrays.asList(rs.getString("cookie_names").split(DELIMETER)).listIterator();
                    ListIterator<String> cookieValuesIterator = Arrays.asList(rs.getString("cookie_values").split(DELIMETER)).listIterator();
                    while (cookieNamesIterator.hasNext() && cookieValuesIterator.hasNext()) {
                        Cookie cookie = new Cookie();
                        cookie.setCookieNum(rs.getInt("cookie_num"));
                        cookie.setName(cookieNamesIterator.next());
                        cookie.setValue(cookieValuesIterator.next());
                        cookies.add(cookie);
                    }
                    cookieTemplate.setCookies(cookies);

                    return cookieTemplate;
            });
    }

    @Transactional
    @Override
    public CookieTemplate createCookie(CookieTemplate cookieTemplate) {
        CookieMap cookieMap = cookieTemplate.getCookieMap();
        List<Cookie> cookies = cookieTemplate.getCookies();
        if (Utils.isEmptyString(cookieMap.getName()) || Utils.isEmptyCollection(cookies)) { return null; }

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String cookieMapName = cookieMap.getName();
        String cookieMapNameCountSQL = CookieQueryBuilder.cookieMapNameCount(parameters, cookieMapName);
        Integer cookieMapNameCount = this.namedParameterJdbcTemplate.queryForObject(cookieMapNameCountSQL, parameters, Integer.class);

        if (cookieMapNameCount > 0) { 
            return null;
        } else {
            this.insertCookieMap(cookieMapName);
            this.insertCookies(cookieMapName, cookies);
        }

        return cookieTemplate;
    }

    private void insertCookieMap(String cookieMapName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("cookieMapName", cookieMapName);
        this.namedParameterJdbcTemplate.update(CookieQueryBuilder.INSERT_COOKIE_MAP_SQL, paramMap);
    }

    private void insertCookies(String cookieMapName, List<Cookie> cookies) {
        this.jdbcTemplate.batchUpdate(CookieQueryBuilder.INSERT_COOKIE_SQL,
            new BatchPreparedStatementSetter(){
            
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, cookieMapName);
                    ps.setString(2, cookies.get(i).getName());
                    ps.setString(3, cookies.get(i).getValue());                    
                }
            
                @Override
                public int getBatchSize() {
                    return cookies.size();
                }
            });
    }
}