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

package com.dynamos.test.wishlist;

import com.dynamos.DomainApplication;
import com.dynamos.domain.entity.Wishlist;
import com.dynamos.domain.service.WishlistService;
import com.dynamos.test.util.GenerateData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by adelmo.pereira on 23/12/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DomainApplication.class)
public class WishlistServiceTest {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private GenerateData generateData;

    private Wishlist newWishlist;

    @Test
    public void testDelete() throws Exception {
        newWishlist = generateWishlist();

        wishlistService.save(newWishlist);

        Wishlist bdWishlist = wishlistService.findOne(newWishlist.getId());

        assertNotNull(bdWishlist);

        wishlistService.delete(newWishlist.getId());

        Wishlist bean = wishlistService.findOne(newWishlist.getId());

        assertNull(bean);
    }

    private Wishlist generateWishlist(){
        Wishlist weddingWishlist = new Wishlist();
        weddingWishlist.setCustomer(generateData.getCustomer());
        weddingWishlist.setIsPublic(false);
        weddingWishlist.setName("wedding wish list");

        return weddingWishlist;
    }
}