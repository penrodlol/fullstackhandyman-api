package cookies.models;

public enum CookieTemplateTypesEnum {
    STANDARD("STANDARD"),
    BOOLEAN("BOOLEAN"),
    INSERTION("INSERTION");

    private String cookieTemplateType;

    CookieTemplateTypesEnum(String cookieTemplateType) {
        this.cookieTemplateType = cookieTemplateType;
    }

    public String getCookieTemplateType() {
        return this.cookieTemplateType;
    }
}