package com.dynamos.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by adelmo on 2/14/16.
 */
@Service
public class LoadMessage implements LoadMessageResource {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String loadMessage(String id) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, null, locale);
    }

    @Override
    public String loadMessage(String id, Object[] params) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, params, locale);
    }
}
