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
        Product product;

        product = new Product();
        product.setIdentifier(UUID.randomUUID().toString());
        product.setTitle("Inspiron 11");
        product.setDescription("2 em 1 de 11 polegadas repleto de tecnologia. Moderno, leve e incrivelmente versátil com quatro modos de uso para atender as soluções mais diversas.");
        product.setManufacturer(manufacturer);
        product.setModel("Inspiron 11 3000");
        product.setPrice(new BigDecimal(2098));
        product.setQuantityOnStock(100L);
        product.setStatus(ProductStatus.ACTIVE);

        productRepositoy.save(product);

        product = new Product();
        product.setIdentifier(UUID.randomUUID().toString());
        product.setTitle("Inspiron 14");
        product.setDescription("Um notebook de 14” com um design incrível e Tela Infinita proporcionam um ultrafino extremamente compacto, leve e sofisticado. Contorno lapidado cuidadosamente como diamante destaca seu estilo. Processadores e placas de vídeo poderosos garantem o melhor desempenho.");
        product.setManufacturer(manufacturer);
        product.setModel("Inspiron 14 7000 Ultrafino");
        product.setPrice(new BigDecimal(4400));
        product.setQuantityOnStock(100L);
        product.setStatus(ProductStatus.ACTIVE);

        productRepositoy.save(product);


        product = new Product();
        product.setIdentifier(UUID.randomUUID().toString());
        product.setTitle("Gtx 980");
        product.setDescription("Equipado Com Três Poderosas Gtx 980 Com Velocidade De Clock 20 Maior Do Que O Gpu De Referência, Dando-Lhe Desempenho Adicional Durante Os Jogos.\n" +
                "Waterforce É Projetado Com Um Painel De Display Led, Onde Os Jogadores Podem Facilmente Monitorar E Ajustar Todas As Definições Sobre As Placas Que Estão Em Sli No Seu Computador.\n" +
                "Comparado Com 3-Way Sli Com Refrigerador De Referência, Waterforce Apresenta Temperatura Mais Baixa, De 42,6, O Que Significa Que Os Jogadores Vão Experimentar Um Desempenho Significativamente Melhor No Jogo.");
        product.setManufacturer(manufacturer);
        product.setModel("Gv-N980x3wa-4gd");
        product.setPrice(new BigDecimal(9900));
        product.setQuantityOnStock(100L);
        product.setStatus(ProductStatus.ACTIVE);

        productRepositoy.save(product);
    }

}
