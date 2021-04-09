package ru.bvb.inovus_generator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.bvb.inovus_generator.models.CarNumber;
import ru.bvb.inovus_generator.services.NumberService;

@Controller
public class NumberController {
    @Autowired
    private NumberService numberService;

    @Autowired
    private CarNumber carNumber;

    @GetMapping("/next")
    @ResponseBody
    String next() {
        carNumber = numberService.next(carNumber);
        return carNumber.toString();
    }

    @GetMapping("/random")
    @ResponseBody
    String random() {
        carNumber = numberService.random();

        return carNumber.toString();
    }
}
