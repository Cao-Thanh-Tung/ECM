package ecm.service;

import ecm.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(int id);
    Category save(Category category);
    Category update(Category category);
    void deleteById(int id);
}
