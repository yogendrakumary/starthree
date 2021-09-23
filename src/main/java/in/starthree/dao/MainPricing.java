package in.starthree.dao;

public class MainPricing {

	public static void main(String[] args) {
		
		ProductDAO productDAO = new ProductDAOImpl();
		
		IPricingService pricingService = new PricingService(productDAO);
		//pricingService.getBasePriceAll().forEach(System.out::println);
		
		double d1 =  pricingService.getPromoPrice(1, "WEEKEND");
		double d2 =  pricingService.getPromoPrice(1, "WED");
		double d3 =  pricingService.getPromoPrice(1, "NEWYEAR");
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		
		
	}
}
