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
package com.dynamos.test.util;

import com.dynamos.domain.entity.*;
import com.dynamos.domain.repository.*;
import com.dynamos.domain.service.ProductService;
import com.dynamos.domain.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by adelmo.pereira on 20/11/2015.
 */
@Component
public class GenerateData {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ManafacturerRepository manafacturerRepository;

    @Autowired
    private TransportFormatRepository transportFormatRepository;

    @Autowired
    private ProductService productService;

    private User admin;

    private Customer customer;

    private ProductCategory productCategory;

    private Manafacturer manafacturer;

    private TransportFormat transportFormat;

    private Product product;

    @PostConstruct
    public void postConstruct(){
        insertAuthority();
        insertAdminUser();
        insertCustomer();
        insertProductCategory();
        insertManafacturer();
        insertTransportFormat();
        insertProduct();
    }

    private void insertAuthority(){
        authorityRepository.save(new Authority("ROLE_ADMIN"));
        authorityRepository.save(new Authority("ROLE_USER"));
    }

    private void insertAdminUser(){
        admin = new User();
        admin.setLogin("admin");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setFirstName("admin");
        admin.setLastName("localhost");
        admin.setEmail("admin@localhost");
        admin.setActivated(true);
        admin.setActivationKey(RandomUtil.generateActivationKey());
        admin.setAuthorities(new HashSet<>());
        admin.getAuthorities().add(new Authority("ROLE_ADMIN"));

        userRepository.save(admin);
    }

    private void insertCustomer(){
        customer = new Customer();
        customer.setLogin("superman");
        customer.setPassword(passwordEncoder.encode("imsuperman"));
        customer.setActivated(true);
        customer.setActivationKey("207822");
        customer.setCpf("03175302798");
        customer.setFirstName("bruce");
        customer.setLastName("wayne");
        customer.setEmail("clark@daily.com");
        customer.setReceiveNewsletter(false);
        customer.setGender("m");

        customerRepository.save(customer);
    }

    private void insertProductCategory() {
        productCategory = new ProductCategory();
        productCategory.setName("Male");

        productCategoryRepository.save(productCategory);
    }

    private void insertManafacturer() {
        manafacturer = new Manafacturer();
        manafacturer.setName("Jhon Jeans");
        manafacturer.setCnpj("28037287000198");
        manafacturer.setSite("http://www.jj.com.br");

        manafacturerRepository.save(manafacturer);
    }

    private void insertTransportFormat() {
        transportFormat = new TransportFormat();
        transportFormat.setFormat("box");
        transportFormat.setCode("1");

        transportFormatRepository.save(transportFormat);
    }

    private void insertProduct(){
        product = new Product();
        product.setName("Black Jeans");
        product.setCategory(getProductCategory());
        product.setSku(generateSku());

        productService.save(product);
    }

    private Sku generateSku(){
        Sku sku = new Sku();
        sku.setIdentifier(UUID.randomUUID().toString());
        sku.setWeight(11.0);
        sku.setLength(101.0);
        sku.setHeight(101.0);
        sku.setDiameter(25.0);
        sku.setActive(true);
        sku.setPrice(new BigDecimal(125L));
        sku.setInstructionsForUse("For body Girl");
        sku.setManafacturerTheWarrantyTime(12);
        sku.setStoreWarrantyTime(3);
        sku.setAmount(100L);
        sku.setAmountReserved(10L);
        sku.setManafacturer(getManafacturer());
        sku.setTransportFormat(getTransportFormat());
        sku.setAttributes(generateProductAttributes());

        return sku;
    }

    private Set<ProductAttribute> generateProductAttributes(){
        Set<ProductAttribute> attributes = new HashSet<>();

        ProductAttribute  referenceAttribute = new ProductAttribute();
        referenceAttribute.setKey("Reference");
        referenceAttribute.setValue("53721");

        attributes.add(referenceAttribute);

        return attributes;
    }


    public User getAdmin() {
        return admin;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public Manafacturer getManafacturer() {
        return manafacturer;
    }

    public TransportFormat getTransportFormat() {
        return transportFormat;
    }

    public Product getProduct() {
        return product;
    }
}