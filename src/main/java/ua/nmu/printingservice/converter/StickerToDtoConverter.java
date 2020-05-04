package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.persistence.domain.product.Sticker;

import static org.apache.commons.text.WordUtils.capitalizeFully;

@Component
public class StickerToDtoConverter implements Converter<Sticker, ProductReadDto> {
    @Override
    public ProductReadDto convert(Sticker sticker) {
        var material = sticker.getMaterial();
        return ProductReadDto.builder()
                .id(sticker.getId())
                .description(sticker.getDescription())
                .height(sticker.getHeight())
                .width(sticker.getWidth())
                .totalPrice(sticker.getTotalPrice())
                .materialName(material.getTypeName())
                .paperQuality(capitalizeFully(material.getPaperQuality().name()))
                .image(sticker.getImage())
                .build();
    }
}