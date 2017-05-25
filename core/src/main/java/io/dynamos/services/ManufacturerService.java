package io.dynamos.services;

import io.dynamos.entities.Manufacturer;
import io.dynamos.repositories.ManufacturerRepository;
import io.dynamos.repositories.ProductRepositoy;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@Service
public class ManufacturerService implements BusinessService<Manufacturer, String> {

    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepositoy productRepositoy;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository, ProductRepositoy productRepositoy) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRepositoy = productRepositoy;
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer findOne(String identifier) {
        return manufacturerRepository.findOne(identifier);
    }

    @Override
    public Page<Manufacturer> findAllByName(Pageable pageable, String name) {
        return StringUtils.isEmpty(name) ?
                manufacturerRepository.findAll(pageable)
                : manufacturerRepository.findAllByNameContainingIgnoreCase(pageable, name);
    }

    @Override
    public void delete(String id) throws BusinessRuleException {
        beforeDelete(manufacturerRepository.findOne(id));
        manufacturerRepository.delete(id);
    }

    private void beforeDelete(Manufacturer manufacturer) throws BusinessRuleException {
        Integer products = productRepositoy.countByManufacturer(manufacturer.getId());
        if (products > 0)
            throw new BusinessRuleException("There are " + products + " products registered with this manufacturer. Cannot delete this");
    }

}