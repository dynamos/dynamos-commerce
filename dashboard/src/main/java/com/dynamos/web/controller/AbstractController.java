package com.dynamos.web.controller;

import com.dynamos.domain.service.LoadMessageResource;
import com.dynamos.dto.Message;
import com.dynamos.dto.ValidationErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adelmo on 07/02/16.
 */
public class AbstractController {

    @Autowired
    private LoadMessageResource loadMessageResource;

    protected void addMessage(RedirectAttributes redirectAttributes, Message ...messages){
        redirectAttributes.addFlashAttribute("messages", messages);
    }

    protected void addMessage(ModelAndView modelAndView, Message ...messages){
        modelAndView.addObject("messages", messages);
    }

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
