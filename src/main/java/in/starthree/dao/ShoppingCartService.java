package in.starthree.dao;

import java.util.ArrayList;

public class ShoppingCartService {
	private ArrayList<Product> items = new ArrayList<>();

	public double getBalance() {
		double balance = 0.00;

		for (Product product : items) {
			balance += product.getPrice();
		}
		return balance;
	}

	public void addItem(Product item) {
		items.add(item);
	}

	public void removeItem(Product item) throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();
		}
	}

	public int getItemCount() {
		return items.size();
	}

	public void empty() {
		items.clear();
	}
}
