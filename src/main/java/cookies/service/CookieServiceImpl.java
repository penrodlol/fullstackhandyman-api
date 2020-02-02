package cookies.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
    public CookieMapsContainer createCookieMapContainer(String name, String tag) throws Exception {
        return this.cookiePersistor.insertCookieMapContainer(name, tag);
    }
}