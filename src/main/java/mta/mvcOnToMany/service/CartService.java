package mta.mvcOnToMany.service;


import mta.mvcOnToMany.entity.Cart;

import java.util.List;

public interface CartService {
    void save(Cart cart);
    Cart findById(Long id);
    public List<Cart> listAllCars();
}
