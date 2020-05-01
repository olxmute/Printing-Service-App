package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.persistence.domain.product.Sticker;

public interface StickerRepository extends JpaRepository<Sticker, String> {
}