package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.product.Poster;

@Component
public class PosterToWriteDtoConverter implements Converter<Poster, ProductWriteDto> {
    @Override
    public ProductWriteDto convert(Poster poster) {
        return ProductWriteDto.builder()
                .id(poster.getId())
                .basePrice(poster.getBasePrice())
                .orientation(poster.getOrientation())
                .materialId(poster.getMaterial().getId())
                .height(poster.getHeight())
                .width(poster.getWidth())
                .description(poster.getDescription())
                .image(poster.getImage())
                .build();
    }
}
