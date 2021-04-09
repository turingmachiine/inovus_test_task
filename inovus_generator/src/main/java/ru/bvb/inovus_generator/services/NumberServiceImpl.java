package ru.bvb.inovus_generator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvb.inovus_generator.models.CarNumber;
import ru.bvb.inovus_generator.repositories.NumberRepository;
import ru.bvb.inovus_generator.utils.LetterUtil;

import java.util.Random;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberRepository numberRepository;

    @Override
    public CarNumber random() {
        CarNumber carNumber = CarNumber.builder().first(LetterUtil.random())
                .num(new Random().nextInt(999))
                .second(LetterUtil.random())
                .third(LetterUtil.random()).build();
        numberRepository.save(carNumber);
        return carNumber;
    }

    @Override
    public CarNumber next(CarNumber carNumber) {
        if (carNumber.getNum() == 999) {
            carNumber.setNum(0);
            Character prev = carNumber.getThird();
            carNumber.setThird(LetterUtil.next(prev));
            if (prev > carNumber.getThird()) {
                prev = carNumber.getSecond();
                carNumber.setSecond(LetterUtil.next(prev));
                if (prev > carNumber.getSecond()) {
                    carNumber.setFirst(LetterUtil.next(carNumber.getFirst()));
                }
            }
        } else {
            carNumber.setNum(carNumber.getNum() + 1);
        }
        carNumber.setId(carNumber.getId() + 1);
        numberRepository.save(carNumber);
        return carNumber;
    }
}
