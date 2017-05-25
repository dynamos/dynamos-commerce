package io.dynamos.services;

import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
public interface BusinessService<E, ID extends Serializable> {

    E save(E t) throws BusinessRuleException;

    E findOne(ID identifier);

    Page<E> findAllByName(Pageable pageable, String name);

    void delete(ID identifier) throws BusinessRuleException;
}