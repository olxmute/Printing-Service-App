package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.CartDto;
import ua.nmu.printingservice.exeptions.ProductNotFoundException;
import ua.nmu.printingservice.persistence.domain.cart.CartItem;
import ua.nmu.printingservice.persistence.repository.CartItemRepository;
import ua.nmu.printingservice.persistence.repository.CartRepository;
import ua.nmu.printingservice.persistence.repository.ProductRepository;
import ua.nmu.printingservice.service.CartService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public void addProductToCart(String productId, Integer count, String userId) {
        var product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        var cart = cartRepository.findByUser_Id(userId);

        Optional<CartItem> optionalCartItem = cart.getItems()
                .stream()
                .filter(cartItem -> productId.equals(cartItem.getProduct().getId()))
                .findFirst();

        if (optionalCartItem.isPresent()) {
            var item = optionalCartItem.get();
            item.setCount(item.getCount() + count);
        } else {
            var item = CartItem.builder().product(product).count(count).cart(cart).build();
            cart.addItem(item);
        }

        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(String itemId) {
        var cartItem = cartItemRepository.findById(itemId).orElseThrow(ProductNotFoundException::new);
        cartItemRepository.delete(cartItem);
    }

    @Override
    @Transactional
    public CartDto findByUserId(String userId) {
        var cart = cartRepository.findByUser_Id(userId);
        return conversionService.convert(cart, CartDto.class);
    }

}
