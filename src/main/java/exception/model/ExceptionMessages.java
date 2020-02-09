package exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExceptionMessages {
    DEFAULT("There was an issue performing this action."),
    ALREADY_EXISTS(" already exists."),
    UNABLE_TO_UPDATE("Unable to update "),
    UNABLE_TO_DELETE("Unable to delete ");

    @Getter private final String exMsg;
}