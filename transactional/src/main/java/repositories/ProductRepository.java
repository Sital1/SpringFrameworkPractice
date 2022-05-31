package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NEVER)
    public void addProduct(String name, Double price){
        String sql = "INSERT INTO product VALUES (NULL,?,?)";

        jdbcTemplate.update(sql,name,price);
        //throw new RuntimeException(":(");
    }

}
