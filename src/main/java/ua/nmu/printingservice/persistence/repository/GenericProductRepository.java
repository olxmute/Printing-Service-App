package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nmu.printingservice.persistence.domain.product.AbstractProduct;

import java.util.List;

public interface GenericProductRepository<T extends AbstractProduct> extends JpaRepository<T, String> {

    List<T> findAllByActiveAndUserNull(boolean active, Sort sort);

    @Modifying
    @Query("UPDATE AbstractProduct p SET p.active = false WHERE p = :product")
    void delete(@Param("product") T product);

    @Query("SELECT p FROM AbstractProduct p")
    List<T> findAllByDescriptionMatchesRegex(String regexMatch);

}
