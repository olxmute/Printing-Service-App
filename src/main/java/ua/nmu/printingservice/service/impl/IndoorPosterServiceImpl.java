package ua.nmu.printingservice.service.impl;

import lombok.SneakyThrows;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.domain.product.IndoorPoster;
import ua.nmu.printingservice.persistence.repository.IndoorPosterRepository;
import ua.nmu.printingservice.service.IndoorPosterService;

import javax.transaction.Transactional;

@Service
public class IndoorPosterServiceImpl extends AbstractPosterService<IndoorPoster> implements IndoorPosterService {

    public IndoorPosterServiceImpl(ConversionService conversionService,
                                   IndoorPosterRepository indoorPosterRepository) {
        super(conversionService, indoorPosterRepository);
    }

    @Transactional(rollbackOn = Throwable.class)
    @SneakyThrows
    @Override
    public void save(ProductWriteDto productWriteDto) {
        IndoorPoster indoorPoster = repository.findById(productWriteDto.getId()).orElse(new IndoorPoster());

        indoorPoster.setBasePrice(productWriteDto.getBasePrice());
        indoorPoster.setDescription(productWriteDto.getDescription());
        indoorPoster.setHeight(productWriteDto.getHeight());
        indoorPoster.setWidth(productWriteDto.getWidth());
        indoorPoster.setOrientation(productWriteDto.getOrientation());
        indoorPoster.setMaterial(new PosterMaterial(productWriteDto.getMaterialId()));
        indoorPoster.setImage(productWriteDto.getImage());

        repository.save(indoorPoster);
    }

    @Override
    public ProductWriteDto finByIdForUpdate(String id) {
        //                                                  TODO: throw PosterNotFoundException
        IndoorPoster indoorPoster = repository.findById(id).orElse(new IndoorPoster());
        return conversionService.convert(indoorPoster, ProductWriteDto.class);
    }

}
