package com.theory.lombok;

import lombok.Builder;
import lombok.Data;


@Data @Builder
public class LombokStudent {
    private String name, lastname, email, username, password;
    private int age;
    private boolean enabled;
}
