package cookies.models;

import java.util.List;

public class CookieMapWrapper {
    private CookieMap cookieMap;
    private List<Cookie> cookies;

    public CookieMap getCookieMap() { return this.cookieMap; }
    public void setCookieMap(CookieMap cookieMap) { this.cookieMap = cookieMap; }

    public List<Cookie> getCookies() { return this.cookies; }
    public void setCookies(List<Cookie> cookies) { this.cookies = cookies; }
}