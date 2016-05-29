package com.practice.math.controller;

import com.practice.math.model.Player;
import com.practice.math.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "players")
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    @Qualifier(value = "playerService")
    public void setPlayerService(PlayerService ps) {
        this.playerService = ps;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadStartPage() {
        return "redirect:/players/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String listPlayers(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("listPlayers", this.playerService.listPlayers());
        return "player";
    }

    @RequestMapping(value = "player/add", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") Player p) {
        if (p.getId() == 0) {
            this.playerService.addPlayer(p);
        } else {
            this.playerService.updatePlayer(p);
        }
        return "redirect:/players/index";
    }

    @RequestMapping("remove/{id}")
    public String removePlayer(@PathVariable("id") int id) {
        this.playerService.removePlayer(id);
        return "redirect:/players/index";
    }

    @RequestMapping("edit/{id}")
    public String editPlayer(@PathVariable("id") int id, Model model) {
        model.addAttribute("player", this.playerService.getPlayerByID(id));
        model.addAttribute("listPlayers", this.playerService.listPlayers());
        return "player";
    }

}
