package cookies.service;

import java.util.List;

import cookies.models.CookieTemplate;

public interface CookieService {
    public List<CookieTemplate> getCookieTemplates();
    public CookieTemplate createCookie(CookieTemplate cookieTemplate);
}