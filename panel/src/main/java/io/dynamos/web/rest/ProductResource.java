package io.dynamos.web.rest;

import io.dynamos.entities.Product;
import io.dynamos.services.ProductService;
import io.dynamos.web.rest.util.RestConstants;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/product")
public class ProductResource extends RestResource<Product, String> {

    private ProductService businessService;

    public ProductResource(ProductService productService, ProductService businessService) {
        super(productService);
        this.businessService = businessService;
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(sort = {"name"}, value = RestConstants.MAX_PAGE_ITENS) Pageable pageable
            , @RequestParam(required = false) String name) {
        return ResponseEntity.ok(businessService.findAllByName(pageable, name));
    }
}