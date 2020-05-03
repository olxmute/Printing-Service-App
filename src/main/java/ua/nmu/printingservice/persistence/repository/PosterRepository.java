package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.product.Poster;

import java.util.List;

public interface PosterRepository extends JpaRepository<Poster, String> {
    List<Poster> findAllByUserNull(Sort sort);
}
