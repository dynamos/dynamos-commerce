package io.dynamos.test;

import io.dynamos.repositories.ManufacturerRepository;
import io.dynamos.repositories.ProductRepositoy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void create(){}
}
