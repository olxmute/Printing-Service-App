package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.enums.ProductType;
import ua.nmu.printingservice.security.annotation.Access;
import ua.nmu.printingservice.service.MaterialService;
import ua.nmu.printingservice.service.StickerService;

import javax.validation.Valid;

@Controller
@RequestMapping("stickers")
@RequiredArgsConstructor
public class StickerController {

    private final StickerService stickerService;
    private final MaterialService materialService;

    @GetMapping("list")
    public String getStickers(Model model, @RequestParam(defaultValue = "") String q) {
        model.addAttribute("products", stickerService.findAll(q));
        model.addAttribute("productType", ProductType.STICKER.getValue());
        return "/products/product-list";
    }

    @Access.Admin
    @GetMapping("add")
    public String getCreateStickerPage(Model model) {
        model.addAttribute("materials", materialService.getStickerMaterialsMap());
        model.addAttribute("productWriteDto", new ProductWriteDto());
        model.addAttribute("productType", ProductType.STICKER.getValue());
        return "/products/write-poster";
    }

    @Access.Admin
    @PostMapping("write")
    public String createSticker(@ModelAttribute @Valid ProductWriteDto productWriteDto,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productType", ProductType.STICKER.getValue());
            model.addAttribute("materials", materialService.getStickerMaterialsMap());
            return "/products/write-poster";
        }
        stickerService.save(productWriteDto);
        return "redirect:/stickers/list";
    }

    @Access.Admin
    @GetMapping("update")
    public String getUpdatePage(@RequestParam String id, Model model) {
        model.addAttribute("materials", materialService.getStickerMaterialsMap());
        model.addAttribute("productWriteDto", stickerService.finByIdForUpdate(id));
        model.addAttribute("productType", ProductType.STICKER.getValue());
        return "/products/write-poster";
    }

    @Access.Admin
    @GetMapping("delete")
    public String deleteById(@RequestParam String id) {
        stickerService.deleteById(id);
        return "redirect:/stickers/list";
    }

}