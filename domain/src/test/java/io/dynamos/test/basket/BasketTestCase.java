package io.dynamos.test.basket;

import io.dynamos.DomainApplication;
import io.dynamos.domain.entity.Basket;
import io.dynamos.domain.entity.ItemBasket;
import io.dynamos.domain.service.BasketService;
import io.dynamos.test.util.GenerateData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * Created by adelm_000 on 14/01/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DomainApplication.class)
public class BasketTestCase {

    @Autowired
    private GenerateData generateData;

    private Basket basket;

    @Autowired
    private BasketService basketService;

    @Test
    public void testSave(){
        basket = generateBasket();

        basketService.save(basket);

        Basket bean = basketService.findOne(basket.getId());

        Assert.assertNotNull(bean);
    }

    private Basket generateBasket(){
        basket = new Basket();
        basket.setItems(new HashSet<>());
        basket.getItems().add(generateItemBasket());
        basket.setCreationDate(LocalDateTime.now());

        return basket;
    }

    private ItemBasket generateItemBasket(){
        ItemBasket itemBasket = new ItemBasket();
        itemBasket.setAmount(20L);
        itemBasket.setInclusionDate(LocalDateTime.now());
        itemBasket.setProduct(generateData.getProduct());

        return itemBasket;
    }
}