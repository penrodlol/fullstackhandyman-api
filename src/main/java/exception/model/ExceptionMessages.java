package exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExceptionMessages {
    DEFAULT("There was an issue performing this action."),
    ALREADY_EXISTS(" already exists.");

    @Getter private final String exMsg;
}