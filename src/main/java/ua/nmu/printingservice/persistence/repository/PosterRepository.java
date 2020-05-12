package ua.nmu.printingservice.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nmu.printingservice.persistence.domain.product.Poster;

import java.util.List;

public interface PosterRepository extends GenericProductRepository<Poster> {

    @Override
    @Query(
            nativeQuery = true,
            value = """
                    SELECT p.* FROM products p
                    WHERE p.dtype = 'POSTER'
                    AND (p.description REGEXP ?1)
                    AND p.user_id IS NULL
                    AND p.active = true
                    ORDER BY p.created_date
                    """
    )
    List<Poster> findAllByDescriptionMatchesRegex(@Param("regexMatch") String regexMatch);

}
