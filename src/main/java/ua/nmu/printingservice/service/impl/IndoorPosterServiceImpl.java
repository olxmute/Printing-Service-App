package ua.nmu.printingservice.service.impl;

import lombok.SneakyThrows;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.domain.product.Image;
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
    public void save(ProductWriteDto productWriteDto) {
        IndoorPoster indoorPoster = new IndoorPoster();
        var file = productWriteDto.getFile();

        indoorPoster.setImage(new Image(file.getBytes(), file.getContentType()));
        indoorPoster.setBasePrice(productWriteDto.getBasePrice());
        indoorPoster.setDescription(productWriteDto.getDescription());
        indoorPoster.setHeight(productWriteDto.getHeight());
        indoorPoster.setWidth(productWriteDto.getWidth());
        indoorPoster.setOrientation(productWriteDto.getOrientation());
        indoorPoster.setMaterial(new PosterMaterial(productWriteDto.getMaterialId()));

        repository.save(indoorPoster);
    }
}
