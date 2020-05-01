package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nmu.printingservice.dto.UserDto;
import ua.nmu.printingservice.service.UserService;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/security/registration";
    }

    @PostMapping
    public String register(@ModelAttribute UserDto userDto) {
        userService.registerUser(userDto);
        return "redirect:/login";
    }

}
