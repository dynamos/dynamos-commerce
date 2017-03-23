package br.com.dynamos.infra.handler.exception;

import br.com.dynamos.infra.utils.HttpHeadersUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by adelmo.pereira on 04/01/2017.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity authenticationException(AuthenticationException authex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(createAlert(authex.getMessage())).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exception(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(HttpHeadersUtil.createErrorAlert(ex.getMessage())).build();
    }


    public static HttpHeaders createAlert(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-ErrorMessage", message);
        return headers;
    }
}
