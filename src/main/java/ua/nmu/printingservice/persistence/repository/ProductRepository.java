package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.product.AbstractProduct;

public interface ProductRepository extends JpaRepository<AbstractProduct, String> {
}
