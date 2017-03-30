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

package com.dynamos.domain.service;

import com.dynamos.domain.entity.Wishlist;
import com.dynamos.domain.repository.WishlistRepository;
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
public class WishlistService{

    private final Logger log = LoggerFactory.getLogger(WishlistService.class);

    @Autowired
    private WishlistRepository wishlistRepository;

    /**
     * Save a wishlist.
     * @return the persisted entity
     */
    public Wishlist save(Wishlist wishlist) {
        log.debug("Request to save Wishlist : {}", wishlist);
        Wishlist result = wishlistRepository.save(wishlist);
        return result;
    }

    /**
     *  get all the wishlists.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Wishlist> findAll(Pageable pageable) {
        log.debug("Request to get all Wishlists");
        Page<Wishlist> result = wishlistRepository.findAll(pageable);
        return result;
    }

    /**
     *  get one wishlist by id.
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Wishlist findOne(Long id) {
        log.debug("Request to get Wishlist : {}", id);
        Wishlist wishlist = wishlistRepository.findOne(id);
        return wishlist;
    }

    /**
     *  delete the  wishlist by id.
     */
    public void delete(Long id) {
        log.debug("Request to delete Wishlist : {}", id);
        wishlistRepository.delete(id);
    }
}
