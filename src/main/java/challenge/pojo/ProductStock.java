package challenge.pojo;

public class ProductStock {

	private Long productId;
	private Long availableStock;

	public ProductStock(Long productId, Long availableStock) {
		this.productId = productId;
		this.availableStock = availableStock;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getAvailableStock() {
		return availableStock;
	}

}