package ua.nmu.printingservice.service.impl;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.exeptions.ProductNotFoundException;
import ua.nmu.printingservice.persistence.domain.product.Sticker;
import ua.nmu.printingservice.persistence.repository.StickerRepository;
import ua.nmu.printingservice.service.StickerService;

@Service
public class StickerServiceImpl extends AbstractProductService<Sticker> implements StickerService {

    public StickerServiceImpl(StickerRepository repository,
                              ConversionService conversionService) {
        super(repository, conversionService, Sticker.class);
    }

    public Sticker getById(String id) {
        return repository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

}