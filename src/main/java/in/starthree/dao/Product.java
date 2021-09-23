package in.starthree.dao;

public class Product {
	private int id;
	private String name;
	private double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getId() + " : " + getName() + " : " + getPrice();
	}

	@Override
	public boolean equals(Object obj) {
		Product p = (Product) obj;
		if (p.getId() == getId())
			return true;
		else
			return false;

	}
	@Override
	public int hashCode() {
		return getId();
	}
}
