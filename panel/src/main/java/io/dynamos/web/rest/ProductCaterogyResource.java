package io.dynamos.web.rest;

import io.dynamos.entities.ProductCategory;
import io.dynamos.services.ProductCategoryService;
import io.dynamos.web.rest.util.RestConstants;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
@RestController
@RequestMapping(value = "api/product-category")
public class ProductCaterogyResource extends RestResource<ProductCategory, String> {

    private ProductCategoryService businessService;

    public ProductCaterogyResource(ProductCategoryService businessService, ProductCategoryService businessService1) {
        super(businessService);
        this.businessService = businessService1;
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(sort = {"name"}, value = RestConstants.MAX_PAGE_ITENS) Pageable pageable
            , @RequestParam(required = false) String name) {
        return ResponseEntity.ok(businessService.findAllByName(pageable, name));
    }
}