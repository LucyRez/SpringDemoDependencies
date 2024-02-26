package cs.hse;

import cs.hse.dto.ProductDto;
import cs.hse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAfter {

    public static void main(String[] args) {
        // First step: set up context and get the service object
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        ProductService service = context.getBean(ProductService.class);

        // Perform queries
        System.out.println(service.putTheProduct(
                new ProductDto("1", "TestProduct", 100.99f, 16)
        ));
        System.out.println(service.getTheProductInfo("1"));
    }
}
