package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nmu.printingservice.service.StickerService;

@Controller
@RequestMapping("stickers")
@RequiredArgsConstructor
public class StickerController {

    private final StickerService stickerService;

    @GetMapping("list")
    public String getStickers(Model model) {
        model.addAttribute("stickers", stickerService.findAll());

        return "/products/sticker-list";
    }

}