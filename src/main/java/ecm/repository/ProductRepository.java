package ecm.repository;

import ecm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Tìm sản phẩm theo keyword trong tên sản phẩm hoặc mô tả và theo id danh mục
    @Query("SELECT p FROM Product p WHERE (p.name LIKE %:keyword% OR p.description LIKE %:keyword%) AND p.categoryId = :categoryId")
    List<Product> findByKeywordAndCategoryId(@Param("keyword") String keyword, @Param("categoryId") int categoryId);
}
