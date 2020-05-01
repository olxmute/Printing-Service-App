package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.product.IndoorPoster;

public interface IndoorPosterRepository extends JpaRepository<IndoorPoster, String> {
}
