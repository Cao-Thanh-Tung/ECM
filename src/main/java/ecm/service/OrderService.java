package ecm.service;

import ecm.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(int id);
    Order save(Order order);
    Order update(Order order);
    void deleteById(int id);
}
