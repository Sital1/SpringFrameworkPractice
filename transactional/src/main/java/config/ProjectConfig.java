package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"repositories", "services"})
public class ProjectConfig {

    // datasource
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("Abcde12345@");
        return dataSource; // placed into the context
    }

    // jdbc template
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    // platform transaction manager
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        var tm = new DataSourceTransactionManager(dataSource);
        return tm;
    }

}
