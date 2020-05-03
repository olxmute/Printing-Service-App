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
import ua.nmu.printingservice.service.PosterMaterialService;

@Controller
@RequestMapping("user-poster")
@RequiredArgsConstructor
public class UserPosterController {

    private final CartService cartService;
    private final PosterMaterialService posterMaterialService;

    @GetMapping
    public String getCreateUserPosterPage(Model model) {
        model.addAttribute("materials", posterMaterialService.getMaterialsMap());
        model.addAttribute("orientations", Orientation.getOrientationMap());
        model.addAttribute("productWriteDto", new ProductWriteDto());
        return "/products/create-user-poster";
    }

    @PostMapping
    public String addUserPosterToCart(@ModelAttribute ProductWriteDto productWriteDto,
                                      @RequestParam Integer count,
                                      @AuthenticationPrincipal SecurityUser user) {
        cartService.addUserPosterToCart(productWriteDto, count, user.getId());
        return "redirect:/posters/list";
    }
}
