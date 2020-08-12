package bg.softuni.votingSysV2.controller;

import bg.softuni.votingSysV2.dto.RegistrationDTO;
import bg.softuni.votingSysV2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registration", new RegistrationDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@Valid @ModelAttribute("registration") RegistrationDTO registration, BindingResult bindingResult){

        System.out.println(registration);

        if (bindingResult.hasErrors()){
            return "register";
        }

        userService.registerUser(registration);

        return "login";
    }
}
