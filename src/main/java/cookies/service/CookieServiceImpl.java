package cookies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cookies.models.Cookie;
import cookies.models.CookieMap;
import cookies.models.CookieMapsContainer;

@Service
public class CookieServiceImpl implements CookieService {
    private CookiePersistor cookiePersistor;

    public CookieServiceImpl(CookiePersistor cookiePersistor) {
        this.cookiePersistor = cookiePersistor;
    }

    @Override
    public List<CookieMapsContainer> getCookieMapsContainers() {
        return this.cookiePersistor.getCookieMapsContainers();
    }

    @Override
    public List<CookieMap> getCookieMaps(Integer containerNum) {
        return this.cookiePersistor.getCookieMaps(containerNum);
    }

    @Override
    public List<Cookie> getCookies(Integer mapNum) {
        return this.cookiePersistor.getCookies(mapNum);
    }

    @Override
    public void createCookieMapContainer(String name) {
        this.cookiePersistor.createCookieMapContainer(name);
    }
}