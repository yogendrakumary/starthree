package in.starthree.dao;

import java.util.List;

public interface ProductDAO {

	public List<Product> findAll();
	public Product findById(int  id);
	public Product save(Product p);
}
