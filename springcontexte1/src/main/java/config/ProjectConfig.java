package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"beans", "services", "repositories"})
public class ProjectConfig {

//    /**
//     * Bean can be created with a method.
//     * Make the Bean Primary To distinguish the similar beans.
//     * @return
//     */
//    @Bean("A")
//    public MyBean myBean(){
//        MyBean myBean = new MyBean();
//        myBean.setText("HEllo");
//        return myBean;
//    }
//
//    @Bean("B")
//    public MyBean myBean2(){
//        MyBean myBean = new MyBean();
//        myBean.setText("World");
//        return myBean;
//    }

}
