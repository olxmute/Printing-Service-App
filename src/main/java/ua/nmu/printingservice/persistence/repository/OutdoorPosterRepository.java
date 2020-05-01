package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.product.OutdoorPoster;

public interface OutdoorPosterRepository extends JpaRepository<OutdoorPoster, String> {
}
