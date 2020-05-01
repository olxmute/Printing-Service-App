package ua.nmu.printingservice.service.impl;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.persistence.domain.product.OutdoorPoster;
import ua.nmu.printingservice.persistence.repository.OutdoorPosterRepository;
import ua.nmu.printingservice.service.OutdoorPosterService;

@Service
public class OutdoorPosterServiceImpl extends AbstractPosterService<OutdoorPoster> implements OutdoorPosterService {

    public OutdoorPosterServiceImpl(ConversionService conversionService,
                                    OutdoorPosterRepository outdoorPosterRepository) {
        super(conversionService, outdoorPosterRepository);
    }

}