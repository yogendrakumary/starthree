package in.starthree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public List<Product> findAll() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select * from products";
		ResultSet rs;
		PreparedStatement pst;
		List<Product> products = new ArrayList<Product>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
				products.add(p);
			}

			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;

	}

	@Override
	public Product findById(int id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select * from products where id = ?";
		ResultSet rs;
		PreparedStatement pst;
		Product p = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
			}
			else
				throw new ProductNotFoundException();

			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Product save(Product p) {
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into products(id,name,price) values(?,?,?)";
		PreparedStatement pst;
		int n = 0;
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, p.getId());
			pst.setString(2, p.getName());
			pst.setDouble(3, p.getPrice());
			n = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (n == 1)
		{
			return p;
		}
		else
			return null;
	}

}
