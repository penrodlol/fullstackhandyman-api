package cookies.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CookieTablesEnum {
    COOKIE_MAPS_CONTAINER("cookie_maps_container"),
    COOKIE_MAPS("cookie_maps"),
    COOKIES("cookies");

    @Getter private String table;
}