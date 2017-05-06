package io.dynamos.services;

import io.dynamos.entities.Product;
import io.dynamos.repositories.ProductRepositoy;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@Service
public class ProductService implements BusinessService<Product, String> {

    @Autowired
    private ProductRepositoy productRepositoy;

    public Product save(Product product) throws BusinessRuleException {
        beforeSave(product);
        return productRepositoy.save(product);
    }

    @Override
    public void delete(String identifier) throws BusinessRuleException {
    }

    @Override
    public Product findOne(String identifier) {
        return productRepositoy.findOne(identifier);
    }

    @Override
    public Page<Product> findAllByName(Pageable pageable, String name) {
        return StringUtils.isEmpty(name) ?
                productRepositoy.findAll(pageable)
                : productRepositoy.findAllByNameContainingIgnoreCase(pageable, name);
    }

    private void beforeSave(Product product) throws BusinessRuleException {
        Product tmp = productRepositoy.findByName(product.getName());

        if (Objects.nonNull(tmp) && !tmp.getId().equals(product.getId())) {
            throw new BusinessRuleException("A product with this name already exists");
        }

        tmp = productRepositoy.findByModel(product.getModel());

        if (Objects.nonNull(tmp) && (!tmp.getId().equals(product.getId()))) {
            throw new BusinessRuleException("A product with this model already exists");
        }
    }
}