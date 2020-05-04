package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.product.Sticker;

@Component
public class StickerToWriteDtoConverter implements Converter<Sticker, ProductWriteDto> {
    @Override
    public ProductWriteDto convert(Sticker poster) {
        return ProductWriteDto.builder()
                .id(poster.getId())
                .basePrice(poster.getBasePrice())
                .materialId(poster.getMaterial().getId())
                .height(poster.getHeight())
                .width(poster.getWidth())
                .description(poster.getDescription())
                .image(poster.getImage())
                .build();
    }
}
