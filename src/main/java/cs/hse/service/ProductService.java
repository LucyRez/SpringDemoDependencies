package cs.hse.service;

import cs.hse.dto.ProductDto;
import cs.hse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTheProductInfo(String id) {
        return productRepository.getProductById(id).toString();
    }

    public String putTheProduct(ProductDto product) {
        return productRepository.putTheProduct(product);
    }

}
