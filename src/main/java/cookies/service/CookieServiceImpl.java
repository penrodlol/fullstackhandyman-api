package cookies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cookies.models.Cookie;
import cookies.models.CookieMap;
import cookies.models.CookieMapWrapper;
import cookies.models.CookieMapsContainer;
import utils.Utils;

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
    public List<CookieMapWrapper> getCookies(Integer containerNum) {
        List<CookieMapWrapper> cookieMapWrappers = new ArrayList<CookieMapWrapper>();
        List<CookieMap> cookieMaps = this.cookiePersistor.getCookieMaps(containerNum);

        if (Utils.isEmptyCollection(cookieMaps)) {
            return null;
        }

        cookieMaps.forEach(cookieMap -> {
            CookieMapWrapper cookieMapWrapper = new CookieMapWrapper();
            cookieMapWrapper.setCookieMap(cookieMap);

            List<Cookie> cookies = this.cookiePersistor.getCookies(cookieMap.getMapNum());
            if (!Utils.isEmptyCollection(cookies)) {
                cookieMapWrapper.setCookies(cookies);
            }

            cookieMapWrappers.add(cookieMapWrapper);
        });

        return cookieMapWrappers;
    }

    @Override
    public CookieMapsContainer createCookieMapContainer(String name) {
        return this.cookiePersistor.insertCookieMapContainer(name);
    }

    @Override
    public void createCookies(Integer containerNum, String mapName, List<Cookie> cookies) {
        Integer mapNum = this.cookiePersistor.insertCookieMap(containerNum, mapName);
        if (!Utils.isNullOrZeroInteger(mapNum)) {
            this.cookiePersistor.insertCookies(mapNum, cookies);
        }
    }
}