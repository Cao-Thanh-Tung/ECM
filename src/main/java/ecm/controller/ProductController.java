package ecm.controller;

import ecm.model.Category;
import ecm.model.Product;
import ecm.service.CategoryServiceImpl;
import ecm.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;
    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl, CategoryServiceImpl categoryServiceImpl) {
        this.productServiceImpl = productServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping
    public String getAllProduct(@RequestParam("categoryId") String categoryId, @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword, Model model) {
        List<Product> productList = productServiceImpl.findByKeyword(keyword, Integer.parseInt(categoryId));
        model.addAttribute("products", productList);
        model.addAttribute("categoryId", categoryId);
        List<Category> categoryList = categoryServiceImpl.findAll();
        model.addAttribute("categoryList", categoryList);
        return "page/BrowseCatalog";
    }
    @GetMapping("/{productId}")
    public String getAllProduct(@PathVariable String productId, Model model) {
        Product product = productServiceImpl.findById(Integer.parseInt(productId)).orElse(null);
        model.addAttribute("product", product);
        List<Category> categoryList = categoryServiceImpl.findAll();
        model.addAttribute("categoryList", categoryList);
        return "page/ProductDetails";
    }

}
