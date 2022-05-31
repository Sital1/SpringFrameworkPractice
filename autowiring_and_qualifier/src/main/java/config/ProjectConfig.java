package config;

import beans.Cat;
import beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

//    @Bean
//    public Cat cat() {
//        Cat cat = new Cat();
//        cat.setName("Tom");
//        return cat;
//    }
//
////    @Bean
////    public Owner owner(){
////        Owner owner = new Owner();
////        owner.setCat(cat());
////        return owner;
////    }
//
//    @Bean
//    public Owner owner(Cat cat) {
//        Owner owner = new Owner();
//        owner.setCat(cat);
//        return owner;
//    }

    // more than one cat
    @Bean

    public Cat cat1(){

        Cat cat = new Cat();
        cat.setName("TOM");
        return cat;
    }

    @Bean
    public Cat cat2(){
        return new Cat();
    }




}
