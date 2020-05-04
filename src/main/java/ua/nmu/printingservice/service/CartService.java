package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.CartDto;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.cart.Cart;
import ua.nmu.printingservice.persistence.domain.product.AbstractProduct;

import java.util.List;

public interface CartService {

    void addProductToCart(String productId, Integer count, String userId);

    void removeProductFromCart(String itemId);

    void changeItemCountInCart(String itemId, Integer count);

    Cart findActiveByUserId(String userId);

    CartDto findByUserId(String userId);

    <T extends AbstractProduct> void addUserProductToCart(ProductWriteDto productWriteDto, Integer count,
                                                          String userId, Class<T> productClass);

    void submitOrder(String userId);

    List<CartDto> findAllInactiveByUserId(String userId);

}
