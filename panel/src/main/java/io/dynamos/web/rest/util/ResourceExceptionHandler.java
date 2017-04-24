package io.dynamos.web.rest.util;

import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(BusinessRuleException.class)
    private ResponseEntity businessRuleException(BusinessRuleException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(HeadersUtil.createAlert(e.getMessage())).build();
    }
}
