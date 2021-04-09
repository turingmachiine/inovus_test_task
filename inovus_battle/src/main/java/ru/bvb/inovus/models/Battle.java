package ru.bvb.inovus.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class Battle implements Serializable {
    Cat cat1;
    Cat cat2;


}
