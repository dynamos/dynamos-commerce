package io.dynamos.test;

import io.dynamos.entities.Manufacturer;
import io.dynamos.entities.Product;
import io.dynamos.entities.enums.ProductStatus;
import io.dynamos.repositories.ManufacturerRepository;
import io.dynamos.repositories.ProductRepositoy;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by adelmo on 23/04/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {

    @Autowired
    private ProductRepositoy productRepositoy;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    private Manufacturer manufacturer;

    @PostConstruct
    private void postConstruct() {
        manufacturer = new  Manufacturer();

        manufacturer.setName("FOXCONN");
        manufacturer.setAddress("Avenida Marginal, Rod. dos Bandeirantes - Engordadouro, Jundiaí - SP  CEP: 13213-008");
        manufacturer.setTelephone("66625252");
        manufacturer.setId(manufacturer.getName() + "-" + RandomStringUtils.randomNumeric(2));

        manufacturerRepository.save(manufacturer);
    }


    @Test
    public void create() {
        Product product = new Product();
        product.setIdentifier(UUID.randomUUID().toString());
        product.setTitle("Inspiron 11");
        product.setDescription("2 em 1 de 11 polegadas repleto de tecnologia. Moderno, leve e incrivelmente versátil com quatro modos de uso para atender as soluções mais diversas.");
        product.setManufacturer(manufacturer);
        product.setModel("Inspiron 11 3000");
        product.setPrice(new BigDecimal(2098));
        product.setQuantityOnStock(100L);
        product.setStatus(ProductStatus.ACTIVE);

        productRepositoy.save(product);
    }

}
