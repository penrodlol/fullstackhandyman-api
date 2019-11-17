package cookies.service;

import java.util.List;

import cookies.models.CookieTemplate;

public interface CookiePersistor {
    public List<CookieTemplate> getCookieTemplates();
    public CookieTemplate createCookie(CookieTemplate cookieTemplate);
}