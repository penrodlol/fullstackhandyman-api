package cookies.models;

import lombok.Getter;

public enum CookieTablesEnum {
    COOKIE_MAPS_CONTAINER("cookie_maps_container"),
    COOKIE_MAPS("cookie_maps"),
    COOKIES("cookies"),
    COOKIE_TEMPLATES("cookie_templates");

    @Getter private String table;

    CookieTablesEnum(String table) {
        this.table = table;
    }
}