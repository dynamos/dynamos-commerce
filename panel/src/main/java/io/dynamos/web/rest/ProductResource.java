package io.dynamos.web.rest;

import io.dynamos.entities.Product;
import io.dynamos.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/product")
public class ProductResource extends RestResource<Product> {

    public ProductResource(ProductService productService) {
        super(productService);
    }
}