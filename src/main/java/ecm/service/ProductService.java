package ecm.service;

import ecm.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
    Product save(Product product);
    Product update(Product product);
    void deleteById(int id);
}
