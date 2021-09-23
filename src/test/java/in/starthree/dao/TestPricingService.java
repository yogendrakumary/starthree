package in.starthree.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPricingService {
	
	@Test
	public void testgetPromoPrice() {
	
		ProductDAO pdao = new ProductDAOImpl();
		PricingService ps = new PricingService(pdao);
		
		pdao.save(new Product(1,"test",100));
		
		assertEquals(95,ps.getPromoPrice(1, "WEEKEND"));
		assertEquals(100,ps.getPromoPrice(1, "DUMMY"));
		
	}

}
