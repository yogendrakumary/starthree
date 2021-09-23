package in.starthree.dao;

import java.util.List;

public interface IPricingService {
	public List<Product> getBasePriceAll();
	public double getPromoPrice(int productid,String promo); 
	public double getNormalPrice(int productid); 
}
