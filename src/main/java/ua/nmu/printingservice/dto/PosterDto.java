package ua.nmu.printingservice.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class PosterDto extends StickerDto {
    private final String orientation;
}
