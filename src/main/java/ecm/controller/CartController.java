package ecm.controller;

import ecm.DTO.CartItemDTO;
import ecm.model.Cart;
import ecm.model.Product;
import ecm.service.CartService;
import ecm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping
    public String viewCart(Model model) {
        List<Cart> cartItems = cartService.getAllItems();
        List<CartItemDTO> cartItemDTOs = new ArrayList<>();
        for (Cart cartItem : cartItems) {
            Product product = productService.findById(cartItem.getProductId()).orElse(null);
            CartItemDTO cartItemDTO = new CartItemDTO(cartItem, product);
            cartItemDTOs.add(cartItemDTO);
        }

        model.addAttribute("cartItems", cartItemDTOs);
        return "page/ShoppingCart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") int productId,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("price") double price) {
        cartService.addItem(productId, quantity, price);
        return "redirect:/cart"; // Redirect to the cart view
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeItem(id);
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}

