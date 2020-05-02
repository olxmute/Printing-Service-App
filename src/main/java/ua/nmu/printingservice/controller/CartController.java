package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nmu.printingservice.security.model.SecurityUser;
import ua.nmu.printingservice.service.CartService;

@Controller
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("product")
    public String addToCart(@RequestParam String productId,
                            @RequestParam Integer count,
                            @RequestHeader("Referer") String redirect,
                            @AuthenticationPrincipal SecurityUser user) {
        cartService.addProductToCart(productId, count, user.getId());
        return "redirect:" + redirect;
    }

}
