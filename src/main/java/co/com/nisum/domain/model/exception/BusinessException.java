package co.com.nisum.domain.model.exception;

public class BusinessException extends  Exception{

    private String message;

    public BusinessException(String message) {
        super(message);
    }
}
