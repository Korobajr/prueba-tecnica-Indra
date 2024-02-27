package challenge.pojo;

public class ProductSales {

	private Long productId;
	private Double salesAmount;

	public ProductSales(Long productId, Double salesAmount) {
		this.productId = productId;
		this.salesAmount = salesAmount;
	}

	public Long getProductId() {
		return productId;
	}

	public Double getSalesAmount() {
		return salesAmount;
	}

}