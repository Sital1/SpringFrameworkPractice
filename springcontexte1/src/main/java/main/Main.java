package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductDeliveryService;

public class Main {


    /**
     * XML
     * Annotations
     * @param args
     */
    public static void main(String[] args) {

        // Implementation of the application config context interface.
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){

//            // by name
//            // ask the context to give a particular bean
////            MyBean b1 = context.getBean(MyBean.class);
////            MyBean b2 = context.getBean( MyBean.class);
//
//            // Bean from stereotype annotation
//            MyBean b3 = context.getBean(MyBean.class);
//
//            // Same bean as the scope is singleton
//            // Will be false if bean specified.
////            System.out.println(b1.equals(b2));
////            // No Such Bean Exception as the Project Config is empty
////            System.out.println(b1.getText());
////            System.out.println(b2.getText());
//
//            // Bean from component scan
//            System.out.println(b3.getText());

            ProductDeliveryService bean = context.getBean(ProductDeliveryService.class);

            bean.addSomeProducts();


        }

    }
}
