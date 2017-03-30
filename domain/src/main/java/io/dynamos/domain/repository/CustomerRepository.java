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
package io.dynamos.domain.repository;

import io.dynamos.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adelmo.pereira on 23/12/2015.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}