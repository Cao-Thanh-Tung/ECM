package ecm.service;

import ecm.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllItems();

    Cart addItem(int productId, int quantity, double price);

    void removeItem(Long id);
    void clearCart();
}
