package ua.nmu.printingservice.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class CartDto {
    List<CartItemDto> items;
    int totalItemsCount;
    BigDecimal totalPrice;
}
