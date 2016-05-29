package com.practice.math.controller;

import com.practice.math.model.Club;
import com.practice.math.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "clubs")
public class ClubController {
    private ClubService clubService;

    @Autowired
    @Qualifier(value = "clubService")
    public void setClubService(ClubService ps) {
        this.clubService = ps;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadStartPage() {
        return "redirect:/clubs/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String listClubs(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("listClubs", this.clubService.listClubs());
        return "club";
    }

    @RequestMapping(value = "club/add", method = RequestMethod.POST)
    public String addClub(@ModelAttribute("club") Club p) {
        if (p.getId() == 0) {
            this.clubService.addClub(p);
        } else {
            this.clubService.updateClub(p);
        }
        return "redirect:/clubs/index";
    }

    @RequestMapping("remove/{id}")
    public String removeClub(@PathVariable("id") int id) {
        this.clubService.removeClub(id);
        return "redirect:/clubs/index";
    }

    @RequestMapping("edit/{id}")
    public String editClub(@PathVariable("id") int id, Model model) {
        model.addAttribute("club", this.clubService.getClubByID(id));
        model.addAttribute("listClubs", this.clubService.listClubs());
        return "club";
    }

}
