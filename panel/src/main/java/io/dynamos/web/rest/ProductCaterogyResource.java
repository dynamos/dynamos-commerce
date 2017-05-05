package io.dynamos.web.rest;

import io.dynamos.entities.ProductCategory;
import io.dynamos.repositories.ProductCategoryRepository;
import io.dynamos.services.ProductCategoryBusinessService;
import io.dynamos.web.rest.util.RestConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
@RestController
@RequestMapping(value = "api/product-category")
public class ProductCaterogyResource extends RestResource<ProductCategory> {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCaterogyResource(ProductCategoryBusinessService businessService, ProductCategoryRepository productCategoryRepository) {
        super(businessService);
        this.productCategoryRepository = productCategoryRepository;
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(sort = {"name"}, value = RestConstants.MAX_PAGE_ITENS) Pageable pageable) {
        Page page = productCategoryRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}