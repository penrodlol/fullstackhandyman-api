package common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CommonSQL {
    SELECT_ALL("SELECT * FROM "),
    WHERE_EXISTS("WHERE EXISTS(SELECT 1 FROM %s WHERE %s)"),
    WHERE_NOT_EXISTS("WHERE NOT EXISTS(SELECT 1 FROM %s WHERE %s)"),
    INSERT_INTO_TABLE("INSERT INTO %s"),
    UPDATE_TABLE("UPDATE %s "),
    DELETE_FROM_TABLE("DELETE FROM %s ");

    @Getter private String sqlStatement;
}