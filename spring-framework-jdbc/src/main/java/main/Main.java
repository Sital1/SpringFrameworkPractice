package main;

import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;

public class Main {
    public static void main(String[] args) {


        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){


            ProductRepository productRepository = c.getBean(ProductRepository.class);

            Product p = new Product();
            p.setName("ABC");
            p.setPrice(45.55);

            //productRepository.addProduct(p);
            System.out.println(productRepository.getProducts());

        }

    }
}
