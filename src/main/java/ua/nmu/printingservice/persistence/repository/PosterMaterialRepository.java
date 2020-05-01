package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;

public interface PosterMaterialRepository extends JpaRepository<PosterMaterial, String> {
}
