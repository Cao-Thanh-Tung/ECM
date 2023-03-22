package mta.restAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class AppController {

    @Autowired
    private ProductService service;
 

    @CrossOrigin
    @GetMapping("/products")
    public List<Product> getALL() {
        List<Product> listProducts = service.listAll();

        return listProducts;
    }
    @CrossOrigin
    @GetMapping("/getProdByID/{id}")
    public Product getProdById(@PathVariable Long id) {
      Product prod = service.get(id);
        return prod;
    }
//    public void saveProduct(Product product) {
//        service.save(product);
//    }
    @CrossOrigin
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product prod) throws Exception {
       try {
              service.save(prod);
             return service.get(prod.getId());  
        } catch( Exception e) {
            throw new Exception("Đã   có");
        }
    }
    
//    public void deleteProduct(int id) {
//        service.delete(id);
//    }
    @CrossOrigin
    @DeleteMapping("/products/{id}")
       public String  deleteProduct(@PathVariable Long id) {
        service.delete(id); 
       Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return "deleted";
    }
//    public ResponseEntity<Map<String, Boolean>>  deleteProduct(@PathVariable Long id) {
//        service.delete(id); 
//       Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
      
}
