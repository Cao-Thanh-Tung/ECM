package ecm.service;

import ecm.model.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(int id);
    OrderDetail save(OrderDetail orderDetail);
    OrderDetail update(OrderDetail orderDetail);
    void deleteById(int id);
}
