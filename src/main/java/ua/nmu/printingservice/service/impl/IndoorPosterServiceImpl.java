package ua.nmu.printingservice.service.impl;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.persistence.domain.product.IndoorPoster;
import ua.nmu.printingservice.persistence.repository.IndoorPosterRepository;
import ua.nmu.printingservice.service.IndoorPosterService;

@Service
public class IndoorPosterServiceImpl extends AbstractPosterService<IndoorPoster> implements IndoorPosterService {

    public IndoorPosterServiceImpl(ConversionService conversionService,
                                   IndoorPosterRepository indoorPosterRepository) {
        super(conversionService, indoorPosterRepository);
    }

}
