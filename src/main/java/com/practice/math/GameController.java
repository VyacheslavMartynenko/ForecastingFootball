package com.practice.math;

import com.practice.math.model.Game;
import com.practice.math.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "games")
public class GameController {
    private GameService gameService;

    @Autowired
    @Qualifier(value = "gameService")
    public void setGameService(GameService ps) {
        this.gameService = ps;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadStartPage() {
        return "redirect:/games/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String listGames(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("listGames", this.gameService.listGames());
        return "game";
    }

    @RequestMapping(value = "game/add", method = RequestMethod.POST)
    public String addGame(@ModelAttribute("game") Game p) {
        if (p.getId() == 0) {
            this.gameService.addGame(p);
        } else {
            this.gameService.updateGame(p);
        }
        return "redirect:/games/index";
    }

    @RequestMapping("remove/{id}")
    public String removeGame(@PathVariable("id") int id) {
        this.gameService.removeGame(id);
        return "redirect:/games/index";
    }

    @RequestMapping("edit/{id}")
    public String editGame(@PathVariable("id") int id, Model model) {
        model.addAttribute("game", this.gameService.getGameByID(id));
        model.addAttribute("listGames", this.gameService.listGames());
        return "game";
    }

}
