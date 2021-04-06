package ru.bvb.inovus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import ru.bvb.inovus.models.Battle;
import ru.bvb.inovus.models.Cat;
import ru.bvb.inovus.services.CatService;

import java.util.Collections;
import java.util.List;
import java.util.Queue;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    private Queue<Battle> battles;

    @Autowired
    private CatService catService;

    @GetMapping
    public String getRoot(Model model) {
        List<Cat> cats = catService.getCats();
        Collections.shuffle(cats);
        battles.clear();
        for (int i = 1; i < cats.size(); i += 2) {
            battles.add(Battle.builder()
                    .cat1(cats.get(i - 1))
                    .cat2(cats.get(i))
                    .build());
        }
        model.addAttribute("name", "baddie");
        return "index";
    }
}
