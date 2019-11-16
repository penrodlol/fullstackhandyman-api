package cookies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cookies.Cookie;

@Service
public class CookieServiceImpl implements CookieService {
    private CookiePersistorImpl cookiePersistorImpl;

    public CookieServiceImpl(CookiePersistorImpl cookiePersistorImpl) {
        this.cookiePersistorImpl = cookiePersistorImpl;
    }

    @Override
    public List<Cookie> getCookies() {
        return this.cookiePersistorImpl.getCookies();
    }

}