package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nmu.printingservice.security.model.SecurityUser;
import ua.nmu.printingservice.service.CartService;

@Controller
@RequestMapping("order-history")
@RequiredArgsConstructor
public class OrderHistoryController {

    private final CartService cartService;

    @GetMapping
    public String getOrderHistory(@AuthenticationPrincipal SecurityUser user, Model model) {
        var carts = cartService.findAllInactiveByUserId(user.getId());
        model.addAttribute("carts", carts);

        return "/cart/order-history";
    }
}
