package cookies.service;

import org.springframework.stereotype.Service;

import cookies.models.CookieTemplate;

@Service
public class CookieServiceImpl implements CookieService {
    private CookiePersistorImpl cookiePersistorImpl;

    public CookieServiceImpl(CookiePersistorImpl cookiePersistorImpl) {
        this.cookiePersistorImpl = cookiePersistorImpl;
    }

    @Override
    public CookieTemplate createCookie(CookieTemplate cookieTemplate) {
       return this.cookiePersistorImpl.createCookie(cookieTemplate);
    }

}