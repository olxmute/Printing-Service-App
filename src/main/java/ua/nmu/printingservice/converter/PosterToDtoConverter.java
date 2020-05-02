package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.persistence.domain.product.AbstractPoster;
import ua.nmu.printingservice.persistence.domain.product.Image;

import java.util.Base64;

import static org.apache.commons.text.WordUtils.capitalizeFully;

@Component
public class PosterToDtoConverter implements Converter<AbstractPoster, ProductReadDto> {
    @Override
    public ProductReadDto convert(AbstractPoster poster) {
        var material = poster.getMaterial();
        return ProductReadDto.builder()
                .id(poster.getId())
                .description(poster.getDescription())
                .height(poster.getHeight())
                .width(poster.getWidth())
                .orientation(capitalizeFully(poster.getOrientation().name()))
                .totalPrice(poster.getTotalPrice())
                .materialName(material.getTypeName())
                .paperQuality(capitalizeFully(material.getPaperQuality().name()))
                .image(getImageString(poster.getImage()))
                .build();
    }

    private String getImageString(Image image) {
        // TODO: image must be required, no null checks
        if (image != null) {
            return "data:image/" + image.getImageFormat() + ";base64," + Base64.getEncoder().encodeToString(image.getImageBytes());
        }
        return "";
    }
}
