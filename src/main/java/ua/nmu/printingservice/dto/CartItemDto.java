package ua.nmu.printingservice.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CartItemDto {
    String id;
    ProductReadDto product;
    int productCount;
}
