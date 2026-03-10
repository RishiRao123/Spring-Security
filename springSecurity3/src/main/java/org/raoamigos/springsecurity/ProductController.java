package org.raoamigos.springsecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    public record Product(Long id, String name, double price) {}

    List<Product> products = new ArrayList<>(List.of(
            new Product(1L, "Laptop", 90000),
            new Product(2L, "Mobile", 60000)
    ));

    @GetMapping("/products")
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
