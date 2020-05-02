package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.product.Poster;

public interface PosterRepository extends JpaRepository<Poster, String> {
}
