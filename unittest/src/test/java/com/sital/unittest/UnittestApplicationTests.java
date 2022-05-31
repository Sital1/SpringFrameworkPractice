package com.sital.unittest;

import com.sital.unittest.repositories.ProductRepository;
import com.sital.unittest.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
class UnittestApplicationTests {

    // Not injected with the autowired
    @MockBean
    private ProductRepository productRepository;


    @Autowired
    private ProductService productService;

    @Test
    public void noProductReturnedTest() {

        // Fake Object. Always returns the empty list.
        given(productRepository.getProductNames()).willReturn(Collections.emptyList());

        List<String> res = productService.getProductWithEvenNumberOfCharacters();

        // assert method
        assertTrue(res.isEmpty());
    }

    @Test
    public void moreProductsAreFoundTest(){
        List<String> input = Arrays.asList("aa", "bbbb", "ccc");

        given(productRepository.getProductNames()).willReturn(input);

        List<String> res = productService.getProductWithEvenNumberOfCharacters();
        assertEquals(2,res.size());
//        verify(productRepository,times(2)).addProduct(any());
    }


}
