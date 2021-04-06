package ru.bvb.inovus_generator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvb.inovus_generator.models.CarNumber;
import ru.bvb.inovus_generator.models.Letter;

import java.util.Random;

@Service
public class NumberServiceImpl implements NumberService {

    @Override
    public CarNumber random() {
        return CarNumber.builder().first(Letter.random())
                .num(new Random().nextInt(999))
                .second(Letter.random())
                .third(Letter.random()).build();
    }

    @Override
    public CarNumber next(CarNumber carNumber) {
        if (carNumber.getNum() == 999) {
            if (!carNumber.getThird().next()) {
                if (!carNumber.getSecond().next()) {
                    if (!carNumber.getFirst().next()) {
                        carNumber.setNum(000);
                    }
                }
            }
        } else {
            carNumber.setNum(carNumber.getNum() + 1);
        }
        return carNumber;
    }
}
