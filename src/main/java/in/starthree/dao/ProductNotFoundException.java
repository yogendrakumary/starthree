package in.starthree.dao;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {
		super("missing product...");
	}

}
