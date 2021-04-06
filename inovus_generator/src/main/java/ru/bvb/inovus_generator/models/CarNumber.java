package ru.bvb.inovus_generator.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarNumber {
    Letter first;

    Integer num;

    Letter second;
    Letter third;

    @Override
    public String toString() {
        String output = "";

        output = output + first.getLetter();
        if (num < 100) {
            if (num < 10) {
                output = output + "00" + num;
            } else {
                output = output + "0" + num;
            }
        } else {
            output = output + num;
        }
        output = output + second.getLetter() + third.getLetter() + " 116 RUS";
        return output;
    }
}
