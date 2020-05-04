package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.enums.ProductType;
import ua.nmu.printingservice.service.MaterialService;
import ua.nmu.printingservice.service.StickerService;

@Controller
@RequestMapping("stickers")
@RequiredArgsConstructor
public class StickerController {

    private final StickerService stickerService;
    private final MaterialService materialService;

    @GetMapping("list")
    public String getStickers(Model model) {
        model.addAttribute("stickers", stickerService.findAll());
        return "/products/sticker-list";
    }

    @GetMapping("add")
    public String getCreateStickerPage(Model model) {
        model.addAttribute("materials", materialService.getStickerMaterialsMap());
        model.addAttribute("productWriteDto", new ProductWriteDto());
        model.addAttribute("productType", ProductType.STICKER.getValue());
        return "/products/write-poster";
    }

    @PostMapping("write")
    public String createSticker(@ModelAttribute ProductWriteDto productWriteDto) {
        stickerService.save(productWriteDto);
        return "redirect:/stickers/list";
    }

    @GetMapping("update")
    public String getUpdatePage(@RequestParam String id, Model model) {
        model.addAttribute("materials", materialService.getStickerMaterialsMap());
        model.addAttribute("productWriteDto", stickerService.finByIdForUpdate(id));
        model.addAttribute("productType", ProductType.STICKER.getValue());
        return "/products/write-poster";
    }

    @PostMapping("delete")
    public String deleteById(@RequestParam String id) {
        stickerService.deleteById(id);
        return "redirect:/stickers/list";
    }

}