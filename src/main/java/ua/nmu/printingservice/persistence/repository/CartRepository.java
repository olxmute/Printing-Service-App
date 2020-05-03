package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.cart.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, String> {

    Cart findByActiveAndUser_Id(boolean active, String userId);

    List<Cart> findAllByActiveAndUser_Id(boolean active, String userId, Sort sort);

}
