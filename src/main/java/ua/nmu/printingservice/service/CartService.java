package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.CartDto;
import ua.nmu.printingservice.dto.ProductWriteDto;

public interface CartService {

    void addProductToCart(String productId, Integer count, String userId);

    void removeProductFromCart(String itemId);

    void changeItemCountInCart(String itemId, Integer count);

    CartDto findByUserId(String userId);

    void addUserPosterToCart(ProductWriteDto productWriteDto, Integer count, String userId);

}
