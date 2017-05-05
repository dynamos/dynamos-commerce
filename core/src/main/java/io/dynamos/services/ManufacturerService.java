package io.dynamos.services;

import io.dynamos.entities.Manufacturer;
import io.dynamos.repositories.ManufacturerRepository;
import io.dynamos.repositories.ProductRepositoy;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@Service
public class ManufacturerService implements BusinessService<Manufacturer> {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepositoy productRepositoy;

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer findOne(String identifier) {
        return manufacturerRepository.findOne(identifier);
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