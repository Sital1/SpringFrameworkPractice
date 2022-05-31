package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductService {


    /**
     * REQUIRED (default)
     * REQUIRES_NEW
     * MANDATORY
     * NEVER
     * SUPPORTS
     * NOT_SUPPORTED
     * NESTED
     */


    /**
     * Isolation levels
     * DEFAULT -> Directly From Database, Under layer
     *
     * READ_UNCOMMITTED
     * READ_COMMITTED
     * REPEATABLE_READ
     * SERIALIZABLE
     */

    /**
     * - dirty reads
     * - repeatable reads
     * - phantom reads
     */


    @Autowired
    private ProductRepository productRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addOneProduct(String name, Double price){
        productRepository.addProduct(name,price);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void addTenProduct(){ //created
        for (int i=1; i<=10; i++){
            productRepository.addProduct("Beer",10.99);
            if(i==5){
                throw new RuntimeException(":(");
            }
        }
    } //commits

}
