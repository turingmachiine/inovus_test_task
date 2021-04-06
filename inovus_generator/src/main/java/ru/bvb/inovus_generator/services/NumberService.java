package ru.bvb.inovus_generator.services;

import ru.bvb.inovus_generator.models.CarNumber;

public interface NumberService {
    CarNumber random();
    CarNumber next(CarNumber carNumber);
}
