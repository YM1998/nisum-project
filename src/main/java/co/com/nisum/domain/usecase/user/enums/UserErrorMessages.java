package co.com.nisum.domain.usecase.user.enums;

public enum UserErrorMessages {

    INVALID_PASSWORD("La contraseña Debe tener un numero, " +
            "Debe tener una letra minuscula, " +
            "Debe contener una letra mayuscula, " +
            "No se permiten espacios en blanco en toda la cadena, " +
            "Debe tener al menos 8 caracteres, "),
    INVALID_EMAIL("El formato de correo no es valido"),
    ACCOUNT_EXIST("Esta cuenta ya se encuentra registrada"),
    USER_NOT_FOUND("Credenciales Invalidas");

    private String value;

    private UserErrorMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
