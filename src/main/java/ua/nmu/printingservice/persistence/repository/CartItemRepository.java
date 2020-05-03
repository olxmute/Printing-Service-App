package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.cart.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, String> {
}
