package io.dynamos.web.rest;

import io.dynamos.entities.Product;
import io.dynamos.repositories.ProductRepositoy;
import io.dynamos.services.ProductService;
import io.dynamos.web.rest.util.RestConstants;
import io.dynamos.web.rest.util.exceptions.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping(value = "api/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepositoy productRepositoy;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Product product) throws BusinessRuleException {
        product = productService.save(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(sort = { "title"}, value = RestConstants.MAX_PAGE_ITENS) Pageable pageable) {
        Page page = productRepositoy.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity find(@PathVariable("id") String identifier) {
        return Optional.ofNullable(productRepositoy.findOne(identifier)).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}