package bg.softuni.votingSysV2.controller;

import bg.softuni.votingSysV2.dto.PartyDto;
import bg.softuni.votingSysV2.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PartyController {

    private final PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping("/add-party")
    public ModelAndView addPartyPage() {
        ModelAndView modelAndView = new ModelAndView("/add-party");
        modelAndView.addObject("partyList", partyService.getAllParties());
        modelAndView.addObject("party", new PartyDto());
        return modelAndView;
    }

    @PostMapping("/add-party")
    public String addPartyPost(@ModelAttribute("party") PartyDto partyDto, Model model){
        if (!partyService.exists(partyDto)){
            partyService.addParty(partyDto);
            return "redirect:/add-party";
        }
        model.addAttribute("partyList", partyService.getAllParties());
        model.addAttribute("party", new PartyDto());

        return "add-party-error-exists";
    }

    @PostMapping("/delete-party")
    public String deleteParty(@RequestParam(value = "delete") Long partyId){
        partyService.deleteById(partyId);
        return "redirect:/add-party";
    }



}
