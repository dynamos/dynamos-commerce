package io.dynamos.services;

import io.dynamos.entities.Product;
import io.dynamos.repositories.ProductRepositoy;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@Service
public class ProductService implements BusinessService<Product> {

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

    private void beforeSave(Product product) throws BusinessRuleException {
        Product tmp = productRepositoy.findByTitle(product.getTitle());

        if (Objects.nonNull(tmp) && !tmp.getIdentifier().equals(product.getIdentifier())) {
            throw new BusinessRuleException("A product with this name already exists");
        }

        productRepositoy.findByModel(product.getModel());

        if (Objects.nonNull(tmp) && (!tmp.getIdentifier().equals(product.getIdentifier()))) {
            throw new BusinessRuleException("A product with this model already exists");
        }

        if (StringUtils.isEmpty(product.getIdentifier())) {
            product.setIdentifier(UUID.randomUUID().toString());
        }
    }
}