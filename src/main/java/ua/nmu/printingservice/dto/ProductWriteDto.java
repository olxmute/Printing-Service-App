package ua.nmu.printingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductWriteDto {
    private String id;
    private BigDecimal width;
    private BigDecimal height;
    private String description;
    private String materialName;
    private String paperQuality;
    private String orientation;
    private BigDecimal basePrice;
    private MultipartFile file;
}
