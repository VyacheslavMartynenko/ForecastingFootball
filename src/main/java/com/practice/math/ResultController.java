package com.practice.math;

import com.practice.math.model.Club;
import com.practice.math.model.Player;
import com.practice.math.model.Result;
import com.practice.math.service.ClubService;
import com.practice.math.service.PlayerService;
import com.practice.math.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "results")
public class ResultController {
    private ResultService resultService;
    private ClubService clubService;
    private PlayerService playerService;

    @Autowired
    @Qualifier(value = "resultService")
    public void setResultService(ResultService ps) {
        this.resultService = ps;
    }

    @Autowired
    @Qualifier(value = "clubService")
    public void setClubService(ClubService ps) {
        this.clubService = ps;
    }

    @Autowired
    @Qualifier(value = "playerService")
    public void setPlayerService(PlayerService ps) {
        this.playerService = ps;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadStartPage() {
        return "redirect:/results/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String listResults(Model model) {
        model.addAttribute("result", new Result());
        model.addAttribute("listResults", this.resultService.listResults());
        return "result";
    }

    @RequestMapping(value = "result/add", method = RequestMethod.POST)
    public String addResult(@ModelAttribute("result") Result p) {
        if (p.getId() == 0) {

            Club firstClub = clubService.getClubByName(p.getFirstClub());
            Club secondClub = clubService.getClubByName(p.getSecondClub());

            List<Player> playersFromFirstClub = playerService.getPlayersByClub(p.getFirstClub());
            List<Player> playersFromSecondClub = playerService.getPlayersByClub(p.getSecondClub());

            //TODO calculate rates using club stats or players skills

            p.setFirstRate(1.12);
            p.setSecondRate(2.32);

            this.resultService.addResult(p);
        } else {
            this.resultService.updateResult(p);
        }
        return "redirect:/results/index";
    }

    @RequestMapping("remove/{id}")
    public String removeResult(@PathVariable("id") int id) {
        this.resultService.removeResult(id);
        return "redirect:/results/index";
    }

    @RequestMapping("edit/{id}")
    public String editResult(@PathVariable("id") int id, Model model) {
        model.addAttribute("result", this.resultService.getResultByID(id));
        model.addAttribute("listResults", this.resultService.listResults());
        return "result";
    }

}

