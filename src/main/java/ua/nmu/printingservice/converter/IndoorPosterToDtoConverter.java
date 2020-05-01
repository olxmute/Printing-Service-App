package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.IndoorPosterDto;
import ua.nmu.printingservice.persistence.domain.product.IndoorPoster;

import static org.apache.commons.text.WordUtils.capitalizeFully;

@Component
public class IndoorPosterToDtoConverter implements Converter<IndoorPoster, IndoorPosterDto> {
    @Override
    public IndoorPosterDto convert(IndoorPoster indoorPoster) {
        var material = indoorPoster.getMaterial();
        return IndoorPosterDto.builder()
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
