package ru.bvb.inovus_generator.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CarNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Character first;

    Integer num;

    Character second;
    Character third;

    @Override
    public String toString() {
        String output = "";

        output = output + first;
        if (num < 100) {
            if (num < 10) {
                output = output + "00" + num;
            } else {
                output = output + "0" + num;
            }
        } else {
            output = output + num;
        }
        output = output + second + third + " 116 RUS";
        return output;
    }
}
