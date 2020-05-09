package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.CartDto;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.exeptions.ProductNotFoundException;
import ua.nmu.printingservice.persistence.domain.User;
import ua.nmu.printingservice.persistence.domain.cart.Cart;
import ua.nmu.printingservice.persistence.domain.cart.CartItem;
import ua.nmu.printingservice.persistence.domain.product.AbstractProduct;
import ua.nmu.printingservice.persistence.repository.CartItemRepository;
import ua.nmu.printingservice.persistence.repository.CartRepository;
import ua.nmu.printingservice.persistence.repository.ProductRepository;
import ua.nmu.printingservice.service.CartService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ConversionService conversionService;

    @Override
    public Cart findActiveByUserId(String userId) {
        return cartRepository.findByActiveAndUser_Id(true, userId);
    }

    @Override
    public CartDto findByUserId(String userId) {
        var cart = findActiveByUserId(userId);
        return conversionService.convert(cart, CartDto.class);
    }

    @Override
    @Transactional
    public void addProductToCart(String productId, Integer count, String userId) {
        var product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        var cart = findActiveByUserId(userId);

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
    public void changeItemCountInCart(String itemId, Integer count) {
        var cartItem = cartItemRepository.findById(itemId).orElseThrow(ProductNotFoundException::new);

        int totalCount = cartItem.getCount() + count;
        if (totalCount == 0) {
            removeProductFromCart(itemId);
            return;
        }

        cartItem.setCount(totalCount);
        cartItemRepository.save(cartItem);
    }

    @Override
    @Transactional
    public <T extends AbstractProduct> void addUserProductToCart(ProductWriteDto productWriteDto, Integer count,
                                                                 String userId, Class<T> productClass) {
        var product = conversionService.convert(productWriteDto, productClass);
        product.setUser(new User(userId));

        var savedPoster = productRepository.save(product);

        addProductToCart(savedPoster.getId(), count, userId);
    }

    @Override
    @Transactional
    public void submitOrder(String userId) {
        var cart = findActiveByUserId(userId);
        cart.setActive(false);

        var newCart = new Cart();
        newCart.setUser(new User(userId));
        cartRepository.saveAll(List.of(cart, newCart));
    }

    @Override
    public List<CartDto> findAllInactiveByUserId(String userId) {
        var sort = Sort.by(Sort.Direction.DESC, "createdDate");
        return cartRepository.findAllByActiveAndUser_Id(false, userId, sort)
                .stream()
                .map(cart -> conversionService.convert(cart, CartDto.class))
                .collect(toList());
    }

}
