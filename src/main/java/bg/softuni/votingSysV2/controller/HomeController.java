package bg.softuni.votingSysV2.controller;

import bg.softuni.votingSysV2.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final PartyService partyService;

    @Autowired
    public HomeController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping("/")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("/index");

        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                    .stream()
                    .anyMatch(o -> ((GrantedAuthority) o).getAuthority().equalsIgnoreCase("ROLE_ADMIN"))){
                modelAndView.addObject("partyStatistics", partyService.getPartyStatistics());
            }
        }
        return modelAndView;
    }

    @PostMapping("/")
    public String indexPost(){
        return "redirect:/";
    }

}