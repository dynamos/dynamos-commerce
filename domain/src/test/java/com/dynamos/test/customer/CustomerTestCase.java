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

package com.dynamos.test.customer;

import com.dynamos.DomainApplication;
import com.dynamos.domain.entity.Customer;
import com.dynamos.domain.service.CustomerService;
import com.dynamos.test.util.GenerateData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by adelmo.pereira on 23/12/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DomainApplication.class)
public class CustomerTestCase {

    @Autowired
    private GenerateData generateData;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerService customerService;

    private  Customer customer;

    @Test
    public void testDelete() throws Exception {
        customer = generateCustomer();

        customerService.save(customer);

        customerService.delete(customer.getId());

        customer = customerService.findOne(customer.getId());
        Assert.assertNull(customer);
    }

    private Customer generateCustomer(){
        Customer customer = new Customer();
        customer.setLogin("batman");
        customer.setPassword(passwordEncoder.encode("imbatman"));
        customer.setActivated(true);
        customer.setActivationKey("2000125889978");
        customer.setCpf("01125102811");
        customer.setFirstName("bruce");
        customer.setLastName("wayne");
        customer.setEmail("batman@waynecorp.com");
        customer.setReceiveNewsletter(false);
        customer.setGender("m");

        return customer;
    }

    public Pageable pageRequest(){
        return new PageRequest(0 ,1);
    }
}
