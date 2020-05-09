package ua.nmu.printingservice.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.dto.CartDto;
import ua.nmu.printingservice.dto.CartItemDto;
import ua.nmu.printingservice.persistence.domain.cart.Cart;
import ua.nmu.printingservice.persistence.domain.cart.CartItem;
import ua.nmu.printingservice.persistence.domain.product.Poster;
import ua.nmu.printingservice.persistence.domain.product.Sticker;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class CartToDtoConverter implements Converter<Cart, CartDto> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy").localizedBy(Locale.ENGLISH);

    private final PosterToDtoConverter posterToDtoConverter;
    private final StickerToDtoConverter stickerToDtoConverter;

    @Override
    public CartDto convert(Cart cart) {
        var cartItems = cart.getItems()
                .stream()
                .map(this::convertProduct)
                .collect(toList());

        return CartDto.builder()
                .items(cartItems)
                .totalItemsCount(cart.getItemsCount())
                .totalPrice(cart.getTotalPrice())
                .lastModifiedDate(cart.getLastModifiedDate().format(FORMATTER))
                .build();
    }

    private CartItemDto convertProduct(CartItem cartItem) {
        var product = cartItem.getProduct();

        var productReadDto = switch (product.getDtype()) {
            case POSTER -> posterToDtoConverter.convert((Poster) product);
            case STICKER -> stickerToDtoConverter.convert((Sticker) product);
        };

        return CartItemDto.builder()
                .id(cartItem.getId())
                .productCount(cartItem.getCount())
                .product(productReadDto)
                .build();
    }
}
