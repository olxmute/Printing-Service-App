package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import ua.nmu.printingservice.persistence.domain.product.Sticker;

import java.util.List;

public interface StickerRepository extends GenericProductRepository<Sticker> {
    @Override
    @Query(
            nativeQuery = true,
            value = """
                    SELECT p.* FROM products p
                    WHERE p.dtype = 'STICKER'
                    AND (p.description REGEXP ?1)
                    AND p.user_id IS NULL
                    AND p.active = true
                    ORDER BY p.created_date DESC
                    """
    )
    List<Sticker> findAllByDescriptionMatchesRegex(String regexMatch);
}