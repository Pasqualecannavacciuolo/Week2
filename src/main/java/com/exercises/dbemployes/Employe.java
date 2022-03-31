package com.exercises.dbemployes;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Employe {
    private int ID;
    private String name, lastname;
}
