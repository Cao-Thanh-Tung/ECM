package ecm.service;

import ecm.model.Cart;
import ecm.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public List<Cart> getAllItems() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addItem(int productId, int quantity, double price) {
        Cart cartItem = new Cart();
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(price);
        return cartRepository.save(cartItem);
    }

    @Override
    public void removeItem(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void clearCart() {
        cartRepository.deleteAll();
    }
}