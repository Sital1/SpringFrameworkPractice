package repositories;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    // injecting JdbcTemplate bean
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(Product product) {

        String sql = "INSERT INTO product VALUES (NULL,?,?)";

        jdbcTemplate.update(sql, product.getName(), product.getPrice());

    }


    private Product rowMapper(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }


    public List<Product> getProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (rs,i)-> rowMapper(rs));
    }

}
