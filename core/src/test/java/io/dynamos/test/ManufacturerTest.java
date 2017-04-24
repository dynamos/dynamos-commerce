package io.dynamos.test;

import io.dynamos.entities.Manufacturer;
import io.dynamos.repositories.ManufacturerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by adelmo on 22/04/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ManufacturerTest {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    public void insert() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setAddress("Av. Industrial Belgraf, 400, Bairro Medianeira, Eldorado do Sul");
        manufacturer.setName("Dell Computadores do Brasil");
        manufacturer.setTelephone(" 0800 970 3384");
        manufacturer.setId(UUID.randomUUID().toString());

        manufacturerRepository.save(manufacturer);

        Manufacturer tmp = manufacturerRepository.findOne(manufacturer.getId());

        assertThat(tmp).isNotNull();

        assertThat(tmp.getName()).isEqualTo(manufacturer.getName());

        delete(manufacturer.getId());
    }

    private void delete(String id) {
        manufacturerRepository.delete(id);

        Manufacturer tmp = manufacturerRepository.findOne(id);
        assertThat(tmp).isNull();
    }

}