package common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SQLTables {
    // COOKIES
    COOKIE_MAPS_CONTAINER("cookie_maps_container"),
    COOKIE_MAPS("cookie_maps"),
    COOKIES("cookies");
    // -------------------

    @Getter private String table;
}