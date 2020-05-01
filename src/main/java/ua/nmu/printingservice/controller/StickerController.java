package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.nmu.printingservice.service.StickerService;

@Controller
@RequiredArgsConstructor
public class StickerController {

    private final StickerService stickerService;

    @GetMapping("stickers")
    public String getIndoorPosters(Model model) {
        model.addAttribute("stickers", stickerService.findAll());

        return "/products/sticker-list";
    }

}