package com.exercises.market;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Client {
    private int idClient, age;
    private String name, lastname;
}
