package io.dynamos.domain.service;

import io.dynamos.domain.entity.Basket;
import io.dynamos.domain.repository.BasketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by adelmo alves on 14/01/2016.
 */
@Service(value = "basketService")
@Transactional
public class BasketService{

    private final Logger log = LoggerFactory.getLogger(BasketService.class);

    @Autowired
    private BasketRepository basketRepository;


    /**
     * Save a basket.
     * @return the persisted entity
     */
    public Basket save(Basket basket) {
        log.debug("Request to save basket : {}", basket);

        basket.getItems().forEach(it -> it.setTotalPrice());
        basket.setAmount();

        Basket result = basketRepository.save(basket);
        return result;
    }

    /**
     *  get all the Baskets.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Basket> findAll(Pageable pageable) {
        log.debug("Request to get all Baskets");
        Page<Basket> result = basketRepository.findAll(pageable);
        return result;
    }

    /**
     *  get one basket by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Basket findOne(Long id) {
        log.debug("Request to get basket : {}", id);
        Basket Basket = basketRepository.findOne(id);
        return Basket;
    }

    /**
     *  delete the  basket by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete basket : {}", id);
        basketRepository.delete(id);
    }
}
