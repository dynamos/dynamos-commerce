package io.dynamos.web.rest;

import io.dynamos.entities.Product;
import io.dynamos.repositories.ProductRepositoy;
import io.dynamos.services.ProductService;
import io.dynamos.web.rest.util.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/product")
public class ProductResource extends RestResource<Product> {

    @Autowired
    private ProductRepositoy productRepositoy;

    public ProductResource(ProductService productService) {
        super(productService);
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(sort = {"title"}, value = RestConstants.MAX_PAGE_ITENS) Pageable pageable) {
        Page page = productRepositoy.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}