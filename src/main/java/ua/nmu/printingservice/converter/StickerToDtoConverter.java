package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.PosterDto;
import ua.nmu.printingservice.dto.StickerDto;
import ua.nmu.printingservice.persistence.domain.product.Sticker;

import static org.apache.commons.text.WordUtils.capitalizeFully;

@Component
public class StickerToDtoConverter implements Converter<Sticker, StickerDto> {
    @Override
    public StickerDto convert(Sticker sticker) {
        var material = sticker.getMaterial();
        return PosterDto.builder()
                .id(sticker.getId())
                .description(sticker.getDescription())
                .height(sticker.getHeight())
                .width(sticker.getWidth())
                .totalPrice(sticker.getTotalPrice())
                .materialName(material.getTypeName())
                .paperQuality(capitalizeFully(material.getPaperQuality().name()))
                .build();
    }
}