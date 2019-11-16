package cookies.service;

import java.util.List;

import cookies.Cookie;

public interface CookiePersistor {
    public List<Cookie> getCookies();
}