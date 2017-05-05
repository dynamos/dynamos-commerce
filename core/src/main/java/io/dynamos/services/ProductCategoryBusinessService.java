package io.dynamos.services;

import io.dynamos.entities.ProductCategory;
import io.dynamos.repositories.ProductCategoryRepository;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
@Service
public class ProductCategoryBusinessService implements BusinessService<ProductCategory> {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(String identifier) {
        return productCategoryRepository.findOne(identifier);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) throws BusinessRuleException {
        beforeSave(productCategory);
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public void delete(String identifier) throws BusinessRuleException {
        ProductCategory productCategory = productCategoryRepository.findOne(identifier);
        beforeDelete(productCategory);
        productCategoryRepository.delete(identifier);
    }

    private void beforeSave(ProductCategory productCategory) throws BusinessRuleException {
        //TODO
    }

    private void beforeDelete(ProductCategory productCategory) throws BusinessRuleException {
        //TODO
    }

}
