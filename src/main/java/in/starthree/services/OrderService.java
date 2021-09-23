package in.starthree.services;

public class OrderService implements IOrderService{

	private IEmailService emailService;
	
	
	public OrderService(IEmailService emailService) {
			this.emailService = emailService;
	}


	@Override
	public int placeOrder() {
		System.out.println("order placed...");
		emailService.sendEmail("john@gmail.com");
		return 100;
	}

}
