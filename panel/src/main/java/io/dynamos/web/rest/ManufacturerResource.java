package io.dynamos.web.rest;

import io.dynamos.entities.Manufacturer;
import io.dynamos.services.ManufacturerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@RestController
@RequestMapping(value = "api/manufacturer")
public class ManufacturerResource extends RestResource<Manufacturer> {

    public ManufacturerResource(ManufacturerService businessService) {
        super(businessService);
    }
}