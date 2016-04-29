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

package com.dynamos.test.product;

import com.dynamos.domain.entity.Product;
import com.dynamos.domain.entity.ProductAttribute;
import com.dynamos.domain.entity.Sku;
import com.dynamos.domain.service.ProductService;
import com.dynamos.test.DomainApplicationTests;
import com.dynamos.test.util.GenerateData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

/**
 * Created by adelmo.pereira on 23/12/2015.
 */
public class ProductTestCase extends DomainApplicationTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private GenerateData generateData;

    private Product product;

    @Test
    public void testDelete() throws Exception {
        product = generateProduct();

        productService.save(product);

        Product bean = productService.findOne(product.getId());

        assertNotNull(bean);

        productService.delete(product.getId());

        bean = productService.findOne(product.getId());

        Assert.assertNull(bean);
    }

    private Product generateProduct(){
        Product product = new Product();
        product.setName("Black Jeans");
        product.setCategory(generateData.getProductCategory());
        product.setSku(generateSku());

        return product;
    }

    private Sku generateSku(){
        Sku sku = new Sku();
        sku.setIdentifier(UUID.randomUUID().toString());
        sku.setWeight(10.0);
        sku.setLength(100.0);
        sku.setHeight(10.0);
        sku.setDiameter(20.0);
        sku.setActive(true);
        sku.setPrice(new BigDecimal(200L));
        sku.setInstructionsForUse("For body");
        sku.setManafacturerTheWarrantyTime(1);
        sku.setStoreWarrantyTime(3);
        sku.setAmount(1200L);
        sku.setAmountReserved(0L);
        sku.setManafacturer(generateData.getManafacturer());
        sku.setTransportFormat(generateData.getTransportFormat());
        sku.setAttributes(generateAttributes());

        return sku;
    }

    private Set<ProductAttribute> generateAttributes(){
        Set<ProductAttribute> attributes = new HashSet<>();

        ProductAttribute  referenceAttribute = new ProductAttribute();
        referenceAttribute.setKey("Reference");
        referenceAttribute.setValue("537213815");

        attributes.add(referenceAttribute);

        return attributes;
    }

}