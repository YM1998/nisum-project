package co.com.nisum.domain.model.enums;

public enum Patterns {

    VALID_PASSWORD("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}"),
    VALID_EMAIL("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

    private String value;

    private Patterns(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
