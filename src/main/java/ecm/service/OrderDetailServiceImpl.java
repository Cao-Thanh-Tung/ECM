package ecm.service;

import ecm.model.OrderDetail;
import ecm.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    // Lấy tất cả chi tiết đơn hàng
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    // Tìm chi tiết đơn hàng theo ID
    public Optional<OrderDetail> findById(int id) {
        return orderDetailRepository.findById(id);
    }

    // Thêm chi tiết đơn hàng mới
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    // Cập nhật chi tiết đơn hàng
    public OrderDetail update(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    // Xóa chi tiết đơn hàng theo ID
    public void deleteById(int id) {
        orderDetailRepository.deleteById(id);
    }
}
