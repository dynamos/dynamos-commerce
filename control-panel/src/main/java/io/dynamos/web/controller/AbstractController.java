package io.dynamos.web.controller;

import io.dynamos.domain.service.LoadMessageResource;
import io.dynamos.dto.ValidationErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adelmo on 07/02/16.
 */
public class AbstractController {

    @Autowired
    private LoadMessageResource loadMessageResource;


    protected List<ValidationErrorMessage> addValidationErrorMessage(Errors errors){
        List<ValidationErrorMessage> errorMessageList = new ArrayList<>();

        errors.getFieldErrors().forEach(e -> {
            errorMessageList.add(new ValidationErrorMessage(e.getField(), e.getDefaultMessage()));
        });

        return errorMessageList;
    }

    protected String getMessage(String id){
      return  loadMessageResource.loadMessage(id);
    }

    protected String getMessage(String id, Object[] params){
        return  loadMessageResource.loadMessage(id, params);
    }
}
