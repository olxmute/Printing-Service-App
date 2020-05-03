package ua.nmu.printingservice.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CartItemDto {
    ProductReadDto product;
    int productCount;
}
