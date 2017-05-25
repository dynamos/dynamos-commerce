package io.dynamos.web.rest;

import io.dynamos.entities.ProductCategory;
import io.dynamos.services.ProductCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
@RestController
@RequestMapping(value = "api/product-category")
public class ProductCaterogyResource extends RestResource<ProductCategory> {

    public ProductCaterogyResource(ProductCategoryService businessService) {
        super(businessService);
    }
}