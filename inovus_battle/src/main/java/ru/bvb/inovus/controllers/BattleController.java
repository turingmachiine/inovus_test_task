package ru.bvb.inovus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.bvb.inovus.models.Battle;
import ru.bvb.inovus.models.Cat;
import ru.bvb.inovus.services.CatService;

import java.util.Queue;

@Controller
public class BattleController {

    @Autowired
    private CatService catService;

    @Autowired
    private Queue<Battle> battles;

    @GetMapping("/start")
    @ResponseBody
    Battle process(@RequestParam("ind") String ind) {
        if (!ind.equals("START")) {
            Battle battle = battles.peek();
            if (battle.getCat1().getId().equals(Long.parseLong(ind)) ||
                    battle.getCat2().getId().equals(Long.parseLong(ind))) {
                catService.incrementScore(Long.parseLong(ind));
                battles.poll();
            }
        }
        return battles.peek();

    }
}
