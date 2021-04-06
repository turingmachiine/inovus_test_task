package ru.bvb.inovus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bvb.inovus.models.Cat;
import ru.bvb.inovus.repositories.CatRepository;
import ru.bvb.inovus.services.CatService;

import java.util.List;

@Controller
public class FinishController {

    @Autowired
    private CatService catService;

    @GetMapping("/finish")
    String finish(Model model) {
        List<Cat> cats = catService.findAndSort();
        model.addAttribute("cats", cats);
        return "finish";
    }
}
