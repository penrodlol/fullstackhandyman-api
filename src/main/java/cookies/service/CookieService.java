package cookies.service;

import java.util.List;

import cookies.models.CookieMapsContainer;

public interface CookieService {
    public List<CookieMapsContainer> getCookieMapsContainers();
    public CookieMapsContainer createCookieMapContainer(String name);
}