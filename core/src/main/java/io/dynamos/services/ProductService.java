package io.dynamos.services;

import io.dynamos.entities.Product;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import io.dynamos.repositories.ProductRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepositoy productRepositoy;

    public Product save(Product product) throws BusinessRuleException {
        beforeSave(product);
        return productRepositoy.save(product);
    }

    private void beforeSave(Product product) throws BusinessRuleException {
        Product tmp = productRepositoy.findByTitle(product.getTitle());

        if (Objects.nonNull(tmp) && (product.getTitle().equals(tmp.getTitle())) && !tmp.getIdentifier().equals(product.getIdentifier())) {
            throw new BusinessRuleException("A product with this name already exists");
        }

        product.setIdentifier(UUID.randomUUID().toString());
    }
}