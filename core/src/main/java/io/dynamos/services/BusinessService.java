package io.dynamos.services;

import io.dynamos.web.rest.util.exceptions.BusinessRuleException;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
public interface BusinessService<T> {

    T save(T t) throws BusinessRuleException;

    void delete(String identifier) throws BusinessRuleException;

    T findOne(String identifier);
}
