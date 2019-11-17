package cookies.service;

import cookies.models.CookieTemplate;

public interface CookiePersistor {
    public CookieTemplate createCookie(CookieTemplate cookieTemplate);
}