package ecm.controller;

import ecm.model.Category;
import ecm.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CategoryController {
    private final CategoryServiceImpl categoryServiceImpl;
    @Autowired
    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categoryList = categoryServiceImpl.findAll();
        model.addAttribute("categoryList", categoryList);
        return "page/Default";
    }
}
