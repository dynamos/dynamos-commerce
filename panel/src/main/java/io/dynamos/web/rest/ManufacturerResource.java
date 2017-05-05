package io.dynamos.web.rest;

import io.dynamos.entities.Manufacturer;
import io.dynamos.repositories.ManufacturerRepository;
import io.dynamos.services.ManufacturerService;
import io.dynamos.web.rest.util.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@RestController
@RequestMapping(value = "api/manufacturer")
public class ManufacturerResource extends RestResource<Manufacturer>{

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public ManufacturerResource(ManufacturerService businessService) {
        super(businessService);
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(sort = {"name"}, value = RestConstants.MAX_PAGE_ITENS) Pageable pageable) {
        Page page = manufacturerRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}