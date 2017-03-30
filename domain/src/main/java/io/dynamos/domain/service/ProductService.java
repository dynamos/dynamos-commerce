/*
 * Copyright (C)  2015  Rhino Web Store
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.dynamos.domain.service;

import io.dynamos.domain.entity.Product;
import io.dynamos.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by adelmo.pereira on 23/12/2015.
 */
@Service
@Transactional
public class ProductService{

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    /**
     * Save a product.
     * @return the persisted entity
     */
    public Product save(Product product) {
        log.debug("Request to save product : {}", product);
        Product result = productRepository.save(product);
        return result;
    }

    /**
     *  get all the products.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        log.debug("Request to get all Products");
        Page<Product> result = productRepository.findAll(pageable);
        return result;
    }

    /**
     *  get one product by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Product findOne(Long id) {
        log.debug("Request to get product : {}", id);
        Product product = productRepository.findOne(id);
        return product;
    }

    /**
     *  delete the  product by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete product : {}", id);
        productRepository.delete(id);
    }
}