package in.starthree.services;

public class MainOrder {
	public static void main(String[] args) {

		IEmailService es = new EmailService();
		IOrderService os = new OrderService(es);
		os.placeOrder();

	}
}
