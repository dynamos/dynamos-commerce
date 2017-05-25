package io.dynamos.web.rest;

import io.dynamos.services.BusinessService;
import io.dynamos.web.rest.util.HeadersUtil;
import io.dynamos.web.rest.util.RestConstants;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Optional;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
public abstract class RestResource<T, ID extends Serializable> {

    private BusinessService businessService;

    public RestResource(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid T t) throws BusinessRuleException {
        return ResponseEntity.ok().headers(HeadersUtil.successAlert()).body(businessService.save(t));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody @Valid T t) throws BusinessRuleException {
        return ResponseEntity.ok().headers(HeadersUtil.successAlert()).body(businessService.save(t));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable ID id) throws BusinessRuleException {
        businessService.delete(id);
        return ResponseEntity.ok().headers(HeadersUtil.successAlert()).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> find(@PathVariable("id") ID identifier) {
        return Optional.ofNullable(businessService.findOne(identifier)).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
