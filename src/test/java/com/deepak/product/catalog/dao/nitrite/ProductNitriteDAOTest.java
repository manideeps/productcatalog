package com.deepak.product.catalog.dao.nitrite;

import com.deepak.product.catalog.builder.ProductBuilder;
import com.deepak.product.catalog.dao.ProductDAO;
import com.deepak.product.catalog.entity.Product;
import com.deepak.product.catalog.exception.ProductUpdateException;
import org.dizitart.no2.objects.ObjectRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = NitritePersistenceConfig.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductNitriteDAOTest {

    @Autowired
    ProductDAO productDAO;


    @Autowired
    ObjectRepository<Product> prods;

    static Product product;

    final String code = "OP3";

    @BeforeClass
    public static void setUp() throws Exception {

        product = new ProductBuilder("OP3", "Oneplus3")
                .description("OnePlus 3 ")
                .brand("Oneplus").type("Mobile")
                .category("Electronics")
                .tags(new HashSet<String>() {{

                    add("smartphone");
                    add("flagship");
                    add("2016");
                    add("china");

                }})
                .build();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void asave() throws Exception {
        productDAO.save(product);
    }

    @Test
    public void bupdate() throws Exception {
        product.setDescription("OnePlus 3 Smartphone");
        productDAO.update(product);
        Product updated = productDAO.getById(product.getCode());
        Assert.assertEquals(product.getDescription(), updated.getDescription());

    }


    @Test(expected = ProductUpdateException.class)
    /**
     * Testing updating of record not inserted
     */
    public void baWrongupdate() throws Exception {

        Product copy = (Product) product.clone();
        copy.setCode("OP2");
        productDAO.update(copy);

    }

    @Test()
    public void csaveOrUpdate() throws Exception {


        productDAO.saveOrUpdate(product);

    }

    @Test
    public void dgetById() throws Exception {
        Assert.assertNotNull(productDAO.getById(code));
    }

}