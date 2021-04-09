package ru.bvb.inovus.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.bvb.inovus.models.Cat;
import ru.bvb.inovus.repositories.CatRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CatRepository catRepository;


    public void run(ApplicationArguments args) {
        List<Cat> cats = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            cats.add(Cat.builder()
                    .id((long) i)
                    .name("cat" + i)
                    .score(0)
                    .image("/" + i + ".jpg")
                    .build());
        }
        catRepository.saveAll(cats);
    }
}
