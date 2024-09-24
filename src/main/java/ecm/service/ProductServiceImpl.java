package ecm.service;

import ecm.model.Product;
import ecm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Lấy tất cả sản phẩm
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Tìm sản phẩm theo ID
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    // Thêm sản phẩm mới
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Cập nhật sản phẩm
    public Product update(Product product) {
        return productRepository.save(product);
    }

    // Xóa sản phẩm theo ID
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    // Tìm sản phẩm theo keyword trong tên sản phẩm hoac mô tả va id danh mục
    public List<Product> findByKeyword(String keyword, int categoryId) {
        return productRepository.findByKeywordAndCategoryId(keyword, categoryId);
    }

}
