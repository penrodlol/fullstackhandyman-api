package cookies.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "cookieTemplate")
public class CookieTemplate {
    private CookieMap cookieMap;
    private List<Cookie> cookies;

    @JsonProperty(value = "cookieMap")
    public CookieMap getCookieMap() { return this.cookieMap; }
    public void setCookieMap(CookieMap cookieMap) { this.cookieMap = cookieMap; }

    @JsonProperty(value = "cookies")
    public List<Cookie> getCookies() { return this.cookies; }
    public void setCookies(List<Cookie> cookies) { this.cookies = cookies; }
}