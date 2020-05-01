package ua.nmu.printingservice.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@ToString
@SuperBuilder
public class StickerDto {
    private final String id;
    private final BigDecimal width;
    private final BigDecimal height;
    private final String description;
    private final String materialName;
    private final String paperQuality;
    private final BigDecimal totalPrice;
}