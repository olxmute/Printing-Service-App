package ua.nmu.printingservice.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class ProductReadDto {
    String id;
    BigDecimal width;
    BigDecimal height;
    BigDecimal totalPrice;
    String description;
    String materialName;
    String paperQuality;
    String orientation;
    String image;
}
