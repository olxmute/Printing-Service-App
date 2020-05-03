package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String getCart(@AuthenticationPrincipal SecurityUser user, Model model) {
        model.addAttribute("cart", cartService.findByUserId(user.getId()));
        return "/cart/cart-view";
    }

    @PostMapping("product")
    public String addToCart(@RequestParam String productId,
                            @RequestParam Integer count,
                            @RequestHeader("Referer") String redirect,
                            @AuthenticationPrincipal SecurityUser user) {
        cartService.addProductToCart(productId, count, user.getId());
        return "redirect:" + redirect;
    }

    @PostMapping("product/delete")
    public String removeFromCart(@RequestParam String itemId,
                                 @RequestHeader("Referer") String redirect) {
        cartService.removeProductFromCart(itemId);
        return "redirect:" + redirect;
    }

    @PostMapping("product/count")
    public String changeItemCountCart(@RequestParam String itemId,
                                      @RequestParam Integer count,
                                      @RequestHeader("Referer") String redirect) {
        cartService.changeItemCountInCart(itemId, count);
        return "redirect:" + redirect;
    }

}
