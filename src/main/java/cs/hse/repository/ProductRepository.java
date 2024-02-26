package cs.hse.repository;

import cs.hse.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final String databaseURL;
    private final List<ProductDto> productDtoList;

    public ProductRepository( @Value(value = "${db.url}") String databaseURL) {
        this.databaseURL = databaseURL;
        productDtoList = new ArrayList<>();
    }

    public ProductDto getProductById(String id) {
        return productDtoList.stream().filter(productDto -> productDto.getId().equals(id)).findFirst()
                .orElseThrow();
    }

    public String putTheProduct(ProductDto productDto) {
        var filtered = productDtoList.stream().filter(product -> product.getId().equals(productDto.getId())).toList();
        if (filtered.isEmpty()) {
            productDtoList.add(productDto);
            return String.format("Successfully inserted new product via %s", databaseURL);
        }

        return "ERROR: The product already exists";

    }
}
