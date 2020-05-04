package ua.nmu.printingservice.service.impl;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.exeptions.ProductNotFoundException;
import ua.nmu.printingservice.persistence.domain.product.Poster;
import ua.nmu.printingservice.persistence.repository.PosterRepository;
import ua.nmu.printingservice.service.PosterService;

@Service
public class PosterServiceImpl extends AbstractProductService<Poster> implements PosterService {

    public PosterServiceImpl(PosterRepository posterRepository,
                             ConversionService conversionService) {
        super(posterRepository, conversionService, Poster.class);
    }

    public Poster getById(String id) {
        return repository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

}
