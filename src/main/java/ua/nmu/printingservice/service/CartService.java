package ua.nmu.printingservice.service;

public interface CartService {
    void addProductToCart(String productId, Integer count, String userId);
}
