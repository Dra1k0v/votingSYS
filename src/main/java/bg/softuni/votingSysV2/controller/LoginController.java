package bg.softuni.votingSysV2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping(value = "/login-error")
    public String loginErrorPage() {
        return "login-error";
    }
}
