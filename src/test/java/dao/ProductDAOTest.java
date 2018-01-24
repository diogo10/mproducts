package dao;

import junit.framework.TestCase;
import model.Product;

import java.rmi.server.UID;
import java.util.List;

/**
 * Created by Diogo on 03/07/2017 15:42.
 */
public class ProductDAOTest extends TestCase {

    private ProductDAO productDAO;

    public void setUp() throws Exception {
        super.setUp();
        productDAO = new ProductDAO();
    }

    public void tearDown() throws Exception {
        productDAO = null;
    }

    public void testGetAll() throws Exception {
        System.out.println("product: testGetAll" );
        List<Product> list = productDAO.getAll();
        assertNotNull(list);
        assertTrue(!list.isEmpty());
        System.out.println("pro size " + list.size());
    }

    public void testUpdate() throws Exception {
        System.out.println("product: testUpdate" );

        //Product a = new Product();
        //a.setUid("3343gffgfgf");
        //a.setName("AAA");
        //a.setPrice(12.90);
        //a.setCategory("Start");
        //a.setEnable(false);
        //a.setCurrentStock(1);

        //boolean result = productDAO.update(a);
        //assertTrue(result);

    }

    public void testAdd() throws Exception {
        System.out.println("product: testAdd" );

        //Product a = new Product();
        //a.setName("Fish burger");
        //a.setPrice(9.90);
        //a.setCategory("Lunch");
        //a.setEnable(true);
        //a.setCurrentStock(10);

        //boolean result = productDAO.add(a);
        //assertTrue(result);

    }

    public void testGet() throws Exception {
        System.out.println("product: testGet" );
        Product result = productDAO.get("vdfsfdsfdf2323");
        assertNotNull(result);
        System.out.println("product: result: " + result.getName());

    }

}