package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.persistence.domain.product.AbstractPoster;

import java.util.Base64;

import static org.apache.commons.text.WordUtils.capitalizeFully;

@Component
public class PosterToDtoConverter implements Converter<AbstractPoster, ProductReadDto> {
    @Override
    public ProductReadDto convert(AbstractPoster indoorPoster) {
        String image = "";

        if (indoorPoster.getImage() != null) {
            // TODO: image format
            image = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(indoorPoster.getImage());
        }
        var material = indoorPoster.getMaterial();
        return ProductReadDto.builder()
                .id(indoorPoster.getId())
                .description(indoorPoster.getDescription())
                .height(indoorPoster.getHeight())
                .width(indoorPoster.getWidth())
                .orientation(capitalizeFully(indoorPoster.getOrientation().name()))
                .totalPrice(indoorPoster.getTotalPrice())
                .materialName(material.getTypeName())
                .paperQuality(capitalizeFully(material.getPaperQuality().name()))
                .image(image)
                .build();
    }
}
