package in.starthree.dao;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductDAO {
	private ProductDAO productDAO;

	@BeforeEach
	public void setup() {
		productDAO = new ProductDAOImpl();
		cleanup();
	}

	@Test
	public void testfindAll() {

		assertEquals(productDAO.findAll().size(), 0);
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(1, "Marker", 300));
		products.add(new Product(2, "Pen", 200));
		productDAO.save(products.get(0));
		productDAO.save(products.get(1));
		assertEquals(productDAO.findAll().size(), 2);
		assertIterableEquals(products, productDAO.findAll());

	}

	@Test
	public void testfindbyId() {
		productDAO.save(new Product(1, "Marker", 300));
		assertAll(() -> {
			assertNotNull(productDAO.findById(1));
		}, () -> {
			Product p = productDAO.findById(1);
			assertEquals(1, p.getId());
			assertEquals("Marker", p.getName());
			assertEquals(300, p.getPrice());

		});

	}

	@Test
	public void testsave() {
		productDAO.save(new Product(2, "Marker", 300));
		assertEquals(2, productDAO.findById(2).getId());
	}

	public void cleanup() {
		Connection con = JDBCUtil.getConnection();
		String sql = "delete from products";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testmisingproduct() {
		assertThrows(ProductNotFoundException.class, ()-> productDAO.findById(10000));
		
	}
	
	@Test
	public void saveTimeOut() {
		assertTimeout(Duration.ofMillis(500), ()->{
			productDAO.save(new Product(1, "Test", 200));
		});
	}
	

	@AfterEach
	public void tearDown() {
		productDAO = null;
		cleanup();
	}

}
