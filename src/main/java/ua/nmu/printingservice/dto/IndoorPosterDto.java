package ua.nmu.printingservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class IndoorPosterDto {
    private String id;
    private BigDecimal width;
    private BigDecimal height;
    private String orientation;
    private String description;
    private String materialName;
    private String paperQuality;
    private BigDecimal totalPrice;
}
