package ecm.service;

import ecm.model.Category;
import ecm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Lấy tất cả danh mục
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Tìm danh mục theo ID
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    // Thêm danh mục mới
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // Cập nhật danh mục
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa danh mục theo ID
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
