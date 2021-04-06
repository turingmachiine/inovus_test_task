package ru.bvb.inovus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.bvb.inovus.models.Cat;
import ru.bvb.inovus.repositories.CatRepository;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Override
    public Cat getCat(Long catId) {
        return catRepository.getOne(catId);
    }

    @Override
    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    @Override
    public Boolean incrementScore(Long catId) {
        Cat cat = catRepository.getOne(catId);
        cat.setScore(cat.getScore() + 1);
        catRepository.save(cat);
        return true;
    }

    @Override
    public List<Cat> findAndSort() {
        List<Cat> cats = catRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
        return cats;
    }

}
