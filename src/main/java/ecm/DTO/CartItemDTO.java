package ecm.DTO;

import ecm.model.Cart;
import ecm.model.Product;

import java.util.Optional;

public class CartItemDTO {
    private Cart cart;
    private Product product;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItemDTO(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }
}

