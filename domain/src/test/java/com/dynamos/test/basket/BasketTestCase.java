package com.dynamos.test.basket;

import com.dynamos.domain.entity.Basket;
import com.dynamos.domain.entity.ItemBasket;
import com.dynamos.domain.service.BasketService;
import com.dynamos.test.DomainApplicationTests;
import com.dynamos.test.util.GenerateData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * Created by adelm_000 on 14/01/2016.
 */
public class BasketTestCase extends DomainApplicationTests {

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