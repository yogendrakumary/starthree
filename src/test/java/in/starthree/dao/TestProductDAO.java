package in.starthree.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestProductDAO {

	private ProductDAO productDAO = new ProductDAOImpl();

	
	@Test
	public void testfindAll() {

		cleanup();
		assertEquals(productDAO.findAll().size(), 0);
		productDAO.save(new Product(1, "Marker", 300));
		productDAO.save(new Product(2, "Pen", 200));
		assertEquals(productDAO.findAll().size(), 2);
		cleanup();
	}

	@Test
	@Disabled
	public void testfindbyId() {
		assertEquals(1, productDAO.findById(1).getId());
	}

	@Test
	@Disabled
	public void testsave() {
		productDAO.save(new Product(2, "Marker", 300));
		assertEquals(2, productDAO.findById(2).getId());
	}

	
	public void cleanup() {
		Connection con = JDBCUtil.getConnection();
		String sql  = "delete from products";
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
}
