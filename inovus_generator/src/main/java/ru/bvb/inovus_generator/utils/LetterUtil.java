package ru.bvb.inovus_generator.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.Random;

public class LetterUtil {

    private static Random random = new Random();

    private static Character[] pool = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

    public static Character next(Character character) {
        return pool[(ArrayUtils.indexOf(pool, character) + 1) % pool.length];
    }

    public static Character random() {
        return pool[random.nextInt(pool.length)];
    }

}
