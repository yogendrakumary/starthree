package starthree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import in.starthree.services.EmailService;
import in.starthree.services.OrderService;

public class OrderServiceTest {
	private OrderService os = new OrderService(new EmailService());
	
	@Test
	public void placeOrderTest() {
		
		
			assertEquals(100, os.placeOrder());
			
	}

}
