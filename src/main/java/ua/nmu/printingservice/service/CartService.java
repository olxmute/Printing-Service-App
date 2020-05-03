package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.CartDto;

public interface CartService {

    void addProductToCart(String productId, Integer count, String userId);

    void removeProductFromCart(String itemId);

    void changeItemCountInCart(String itemId, Integer count);

    CartDto findByUserId(String userId);

}
