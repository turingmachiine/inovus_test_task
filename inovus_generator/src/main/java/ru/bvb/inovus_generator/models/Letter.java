package ru.bvb.inovus_generator.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Letter {

    private static Character[] pool = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private Character letter;

    public boolean next() {
        Character temp = letter;
        this.letter = pool[(Arrays.asList(pool).indexOf(letter) + 1) % pool.length];
        return letter > temp;
    }

    public static Letter random() {
        Random random = new Random();
        return Letter.builder().letter(pool[random.nextInt(pool.length)]).build();
    }

}
