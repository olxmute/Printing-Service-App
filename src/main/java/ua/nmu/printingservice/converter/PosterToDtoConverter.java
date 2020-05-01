package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.PosterDto;
import ua.nmu.printingservice.persistence.domain.product.AbstractPoster;

import static org.apache.commons.text.WordUtils.capitalizeFully;

@Component
public class PosterToDtoConverter implements Converter<AbstractPoster, PosterDto> {
    @Override
    public PosterDto convert(AbstractPoster indoorPoster) {
        var material = indoorPoster.getMaterial();
        return PosterDto.builder()
                .id(indoorPoster.getId())
                .description(indoorPoster.getDescription())
                .height(indoorPoster.getHeight())
                .width(indoorPoster.getWidth())
                .orientation(capitalizeFully(indoorPoster.getOrientation().name()))
                .totalPrice(indoorPoster.getTotalPrice())
                .materialName(material.getTypeName())
                .paperQuality(capitalizeFully(material.getPaperQuality().name()))
                .build();
    }
}
