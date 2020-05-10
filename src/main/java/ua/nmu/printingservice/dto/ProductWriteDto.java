package ua.nmu.printingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductWriteDto {

    private String id;

    @NotNull(message = "width must be chosen")
    @DecimalMin(value = "1.0")
    @Digits(integer = 5, fraction = 2)
    @Builder.Default
    private BigDecimal width = BigDecimal.ONE;

    @NotNull(message = "height must be chosen")
    @DecimalMin(value = "1.0")
    @Digits(integer = 5, fraction = 2)
    @Builder.Default
    private BigDecimal height = BigDecimal.ONE;

    @Size(min = 3, message = "minimum 3 characters")
    private String description;

    @Size(min = 36, max = 36)
    private String materialId;

    @DecimalMin(value = "0.01")
    @Digits(integer = 5, fraction = 2)
    @Builder.Default
    private BigDecimal basePrice = BigDecimal.ONE;

    @NotEmpty(message = "image must be chosen")
    private String image;

}
