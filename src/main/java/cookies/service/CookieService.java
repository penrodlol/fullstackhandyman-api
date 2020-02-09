package cookies.service;

import java.util.List;

import cookies.models.CookieMapsContainer;

public interface CookieService {
    List<CookieMapsContainer> getCookieMapsContainers();
    CookieMapsContainer createCookieMapContainer(String name, String tag) throws Exception;
    CookieMapsContainer editCookieMapContainer(CookieMapsContainer cookieMapsContainer) throws Exception;
    Long deleteCookieMapContainer(Long containerNum) throws Exception;
}