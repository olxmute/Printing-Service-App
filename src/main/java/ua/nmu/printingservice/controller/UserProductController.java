package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;
import ua.nmu.printingservice.security.model.SecurityUser;
import ua.nmu.printingservice.service.CartService;
import ua.nmu.printingservice.service.MaterialService;

@Controller
@RequestMapping("user-product")
@RequiredArgsConstructor
public class UserProductController {

    private final CartService cartService;
    private final MaterialService materialService;

    @GetMapping("poster")
    public String getCreateUserPosterPage(Model model) {
        model.addAttribute("materials", materialService.getPosterMaterialsMap());
        model.addAttribute("orientations", Orientation.getOrientationMap());
        model.addAttribute("productWriteDto", new ProductWriteDto());
        return "/products/create-user-poster";
    }

    @PostMapping
    public String addUserProductToCart(@ModelAttribute ProductWriteDto productWriteDto,
                                       @RequestParam Integer count,
                                       @AuthenticationPrincipal SecurityUser user) {
        cartService.addUserPosterToCart(productWriteDto, count, user.getId());
        return "redirect:/cart";
    }
}
