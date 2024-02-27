package challenge;

import challenge.pojo.ProductSales;
import challenge.pojo.ProductStock;

import java.util.*;
import java.util.Map.Entry;

public class Solution {

	public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
			List<ProductStock> productsStockInformation, List<ProductSales> productsSalesInformation) {

		Map<Long, Double> salesMap = new HashMap<>();
		Map<Long, Long> stocksMap = new HashMap<>();

		for (ProductSales sale : productsSalesInformation) {
			salesMap.put(sale.getProductId(), sale.getSalesAmount());
		}

		for (ProductStock stock : productsStockInformation) {
			stocksMap.put(stock.getProductId(), stock.getAvailableStock());
		}

		List<Long> productIDs = new ArrayList<>();
		for (Long productID : salesMap.keySet()) {
			productIDs.add(productID);
		}

		productIDs.sort(Comparator.comparing(id -> {
			Double salesLast72h = salesMap.get(id);
			Long stock = stocksMap.get(id);
			return (salesWeight * salesLast72h) + (stockWeight * stock);
		}).reversed());

		return productIDs;

	}

	public static void main(String[] args) {

		List<ProductSales> ventas = new ArrayList<>();
		ventas.add(new ProductSales(1L, 200.0));
		ventas.add(new ProductSales(2L, 150.0));
		ventas.add(new ProductSales(3L, 100.0));

		List<ProductStock> stocks = new ArrayList<>();
		stocks.add(new ProductStock(1L, 50L));
		stocks.add(new ProductStock(2L, 30L));
		stocks.add(new ProductStock(3L, 80L));

		int stockWeight = 75;
		int salesWeight = 25;

		List<Long> orderList = sortProductsByScores(stockWeight, salesWeight, stocks, ventas);

		System.out.println("Lista ordenada de IDs de producto según su Valor de Peso para la empresa son: " + orderList);
	}
}
