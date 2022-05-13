package co.com.nisum.api.common;

import co.com.nisum.domain.model.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    private static String GENERAL_ERROR = "Sucedio un error procesando la peticion, contacte con el administrador";

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response> businessErrorHandler(BusinessException exception) {
        Response response = new Response();
        response.setState(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> generalErrorHandler(BusinessException exception) {
        Response response = new Response();
        response.setState(HttpStatus.BAD_REQUEST.value());
        response.setMessage(GENERAL_ERROR);
        return ResponseEntity.badRequest().body(response);
    }

}
