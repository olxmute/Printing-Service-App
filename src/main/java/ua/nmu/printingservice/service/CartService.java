package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.CartDto;

public interface CartService {

    void addProductToCart(String productId, Integer count, String userId);

    CartDto findByUserId(String userId);

}
