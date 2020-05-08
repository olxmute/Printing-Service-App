package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.domain.product.Poster;

@Component
public class ProductWriteDtoToPosterConverter implements Converter<ProductWriteDto, Poster> {
    @Override
    public Poster convert(ProductWriteDto dto) {
        return Poster
                .builder()
                .id(dto.getId())
                .basePrice(dto.getBasePrice())
                .description(dto.getDescription())
                .height(dto.getHeight())
                .width(dto.getWidth())
                .orientation(Orientation.PORTRAIT)
                .material(new PosterMaterial(dto.getMaterialId()))
                .image(dto.getImage())
                .build();
    }
}
