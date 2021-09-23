package in.starthree.dao;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestProductDAO {

	private ProductDAO productDAO = new ProductDAOImpl();

	
	@Test
	public void testfindAll() {

		assertEquals(productDAO.findAll().size(), 2);

	}

	@Test
	public void testfindbyId() {
		assertEquals(1, productDAO.findById(1).getId());
	}

	@Test
	@Disabled
	public void testsave() {
		productDAO.save(new Product(2, "Marker", 300));

		assertAll(() -> {
			assertEquals(300, productDAO.findById(2).getPrice());
		}, () -> {
			assertEquals(2, productDAO.findById(2).getId());
		}, () -> {
			assertEquals("Marker", productDAO.findById(3).getName());
		});

	}

}
