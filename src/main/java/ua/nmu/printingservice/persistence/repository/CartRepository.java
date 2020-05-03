package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.cart.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {
    Cart findByUser_Id(String id);
}
