package ru.bvb.inovus.services;

import ru.bvb.inovus.models.Cat;

import java.util.List;

public interface CatService {

    Cat getCat(Long catId);
    List<Cat> getCats();
    Boolean incrementScore(Long catId);
    List<Cat> findAndSort();
}
