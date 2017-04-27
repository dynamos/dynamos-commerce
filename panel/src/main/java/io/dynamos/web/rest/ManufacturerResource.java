package io.dynamos.web.rest;

import io.dynamos.entities.Manufacturer;
import io.dynamos.repositories.ManufacturerRepository;
import io.dynamos.services.ManufacturerService;
import io.dynamos.web.rest.util.HeadersUtil;
import io.dynamos.web.rest.util.RestConstants;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@RestController
@RequestMapping(value = "api/manufacturer")
public class ManufacturerResource {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Manufacturer manufacturer) throws BusinessRuleException {
        return ResponseEntity.ok().headers(HeadersUtil.successAlert()).body(manufacturerService.save(manufacturer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable String id) throws BusinessRuleException {
        manufacturerService.delete(id);
        return ResponseEntity.ok().headers(HeadersUtil.successAlert()).build();
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(sort = {"name"}, value = RestConstants.MAX_PAGE_ITENS) Pageable pageable) {
        Page page = manufacturerRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity find(@PathVariable("id") String identifier) {
        return Optional.ofNullable(manufacturerRepository.findOne(identifier)).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}