package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan(basePackages = "repositories")
public class ProjectConfig {

    // need a bean of datasource to connect to the db
    // driver manager datasource
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("Abcde12345@");
        return dataSource;

    }


    // jdbc bean
    @Bean
    public JdbcTemplate jdbcTemplate(){
        // will give the instance as the bean is already in the context.
        return new JdbcTemplate(dataSource());
    }


}
