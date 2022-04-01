package com.exercises.athletes.athlete;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Athlete {
    private int cod, height;
    private String birthDate;
    private String name, nationality;

}
