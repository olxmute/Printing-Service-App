package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.material.StickerMaterial;
import ua.nmu.printingservice.persistence.domain.product.Sticker;

@Component
public class ProductWriteDtoToStickerConverter implements Converter<ProductWriteDto, Sticker> {
    @Override
    public Sticker convert(ProductWriteDto dto) {
        return Sticker
                .builder()
                .id(dto.getId())
                .basePrice(dto.getBasePrice())
                .description(dto.getDescription())
                .height(dto.getHeight())
                .width(dto.getWidth())
                .material(new StickerMaterial(dto.getMaterialId()))
                .image(dto.getImage())
                .build();
    }
}
