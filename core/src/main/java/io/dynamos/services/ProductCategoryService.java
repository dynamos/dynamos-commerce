package io.dynamos.services;

import io.dynamos.entities.ProductCategory;
import io.dynamos.repositories.ProductCategoryRepository;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
@Service
public class ProductCategoryService implements BusinessService<ProductCategory, String> {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(String identifier) {
        return productCategoryRepository.findOne(identifier);
    }

    @Override
    public Page<ProductCategory> findAllByName(Pageable pageable, String name) {
        return StringUtils.isEmpty(name) ?
                productCategoryRepository.findAll(pageable)
                : productCategoryRepository.findAllByNameContainingIgnoreCase(pageable, name);
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
    }

    private void beforeDelete(ProductCategory productCategory) throws BusinessRuleException {
    }

}
