package in.starthree.dao;

public class MainProductDAO {
	
	public static void main(String[] args) {
		
		ProductDAO pd = new ProductDAOImpl();
		pd.findAll().stream().forEach(System.out::println);
		
	}

}
