package ua.nmu.printingservice.service.impl;

import lombok.SneakyThrows;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.product.IndoorPoster;
import ua.nmu.printingservice.persistence.repository.IndoorPosterRepository;
import ua.nmu.printingservice.service.IndoorPosterService;

@Service
public class IndoorPosterServiceImpl extends AbstractPosterService<IndoorPoster> implements IndoorPosterService {

    public IndoorPosterServiceImpl(ConversionService conversionService,
                                   IndoorPosterRepository indoorPosterRepository) {
        super(conversionService, indoorPosterRepository);
    }

    @SneakyThrows
    @Override
    public void save(ProductWriteDto productReadDto) {
        IndoorPoster indoorPoster = new IndoorPoster();
        // TODO: persist image format
        indoorPoster.setImage(productReadDto.getFile().getBytes());
        indoorPoster.setBasePrice(productReadDto.getBasePrice());
        indoorPoster.setDescription(productReadDto.getDescription());
        indoorPoster.setHeight(productReadDto.getHeight());
        indoorPoster.setWidth(productReadDto.getWidth());
        // TODO: finish saving flow

        repository.save(indoorPoster);
    }
}
