package bg.softuni.votingSysV2.controller;

import bg.softuni.votingSysV2.config.auth.MyUserPrincipal;
import bg.softuni.votingSysV2.entity.User;
import bg.softuni.votingSysV2.service.PartyService;
import bg.softuni.votingSysV2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VoteController {

    private final PartyService partyService;
    private final UserService userService;

    @Autowired
    public VoteController(PartyService partyService, UserService userService) {
        this.partyService = partyService;
        this.userService = userService;
    }

    @GetMapping("/vote")
    public ModelAndView votePage(){
        User user = ((MyUserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();

        ModelAndView modelAndView = new ModelAndView("/vote");

        if (user.getParty() != null){
            modelAndView.addObject("voteError", new Object());
            return modelAndView;
        }

        modelAndView.addObject("partyList", partyService.getAllParties());
        return modelAndView;
    }

    @PostMapping("/vote")
    public String vote(@RequestParam(value = "vote") Long partyId){
        User user = ((MyUserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        userService.vote(user, partyId);

        return "index";
    }
}
