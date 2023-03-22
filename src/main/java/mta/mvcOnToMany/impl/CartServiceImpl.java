package mta.mvcOnToMany.impl;


import mta.mvcOnToMany.entity.Cart;
import mta.mvcOnToMany.repository.CartRepository;
import mta.mvcOnToMany.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Các bạn có thể tìm hiểu thêm  phần này tại blogs: https://levunguyen.com,
 * blogs chuyên về lập trình và các kỹ năng mềm trong nghề lập trình
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        this.cartRepository.save(cart);
    }

    @Override
    public Cart findById(Long id) {

        return this.cartRepository.findById(id).orElse(null);
    }
    public List<Cart> listAllCars() {
        return cartRepository.findAll();
    }
}
