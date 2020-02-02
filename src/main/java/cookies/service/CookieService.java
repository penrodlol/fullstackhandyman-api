package cookies.service;

import java.util.List;

import cookies.models.CookieMapsContainer;

public interface CookieService {
    List<CookieMapsContainer> getCookieMapsContainers();
    CookieMapsContainer createCookieMapContainer(String name, String tag) throws Exception;
}