package ecm.service;

import ecm.model.Order;
import ecm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Lấy tất cả đơn hàng
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    // Tìm đơn hàng theo ID
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    // Thêm đơn hàng mới
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    // Cập nhật đơn hàng
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    // Xóa đơn hàng theo ID
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
