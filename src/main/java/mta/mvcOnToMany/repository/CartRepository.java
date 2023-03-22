package mta.mvcOnToMany.repository;


import mta.mvcOnToMany.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
