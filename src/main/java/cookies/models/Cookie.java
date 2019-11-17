package cookies.models;

public class Cookie {
    private Integer cookieNum;
    private String name;
    private String value;

    public Integer getCookieNum() { return this.cookieNum; }
    public void setCookieNum(Integer cookieNum) { this.cookieNum = cookieNum; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getValue() { return this.value; }
    public void setValue(String value) { this.value = value; }    
}