package challenge;

import challenge.pojo.ProductSales;
import challenge.pojo.ProductStock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    public void testHappyPath() {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(2L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));


        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(1L, 100000L));
        productStock.add(new ProductStock(2L, 400000L));
        productStock.add(new ProductStock(3L, 200000L));
        productStock.add(new ProductStock(4L, 300000L));


        Long[] expectedResult = {2L, 4L, 3L, 1L};
        Assert.assertArrayEquals(Solution.sortProductsByScores(50, 50, productStock, productSales).toArray(),
                expectedResult);
        System.out.println("test Case passed");
    }
}