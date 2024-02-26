package cs.hse;

import cs.hse.dto.ProductDto;
import cs.hse.repository.ProductRepository;
import cs.hse.service.ProductService;

public class MainBefore {
    public static void main(String[] args) {
        // First step: create repository
        var productRepository = new ProductRepository("Test");

        // Second step: create service
        var productService = new ProductService(productRepository);

        // Perform queries
        System.out.println(productService.putTheProduct(
                new ProductDto("1", "TestProduct", 100.99f, 16)
        ));
        System.out.println(productService.getTheProductInfo("1"));
    }
}