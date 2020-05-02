package ua.nmu.printingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;

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
    private String materialId;
    private Orientation orientation;
    private BigDecimal basePrice;
    private MultipartFile file;
}
