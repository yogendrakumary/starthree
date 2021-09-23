package in.starthree.dao;

public class Promo {
	private String promo;
	private double discount;

	public Promo() {
		// TODO Auto-generated constructor stub
	}

	public Promo(String promo, double discount) {
		super();
		this.promo = promo;
		this.discount = discount;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
