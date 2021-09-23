package in.starthree.dao;

import java.util.List;
public class PricingService  implements IPricingService{

	private ProductDAO productDAO;

	public PricingService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	public List<Product> getBasePriceAll() {
		return productDAO.findAll();
	}
	@Override
	public double getNormalPrice(int productid) {
		return productDAO.findById(productid).getPrice();
	}
	@Override
	public double getPromoPrice(int productid, String promo) {
		
		double promoprice=0;
		for(Product p:productDAO.findAll()) {
			if (p.getId() == productid) {
				if (promo.equals("WEEKEND"))
				promoprice = p.getPrice() - (p.getPrice() * 0.05 );
				else if (promo.equals("WED")){
					promoprice = p.getPrice() - (p.getPrice() * 0.10 );	
				}
				else 
					promoprice = p.getPrice();
			}
			}
		
		return promoprice;
	}
}
