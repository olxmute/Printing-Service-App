package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.material.StickerMaterial;

public interface StickerMaterialRepository extends JpaRepository<StickerMaterial, String> {
}