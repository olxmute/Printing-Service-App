package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nmu.printingservice.persistence.domain.product.Poster;

import java.util.List;

public interface PosterRepository extends JpaRepository<Poster, String> {

    List<Poster> findAllByActiveAndUserNull(boolean active, Sort sort);

    @Modifying
    @Query("UPDATE Poster p SET p.active = false WHERE p = :poster")
    void delete(@Param("poster") Poster poster);

}
