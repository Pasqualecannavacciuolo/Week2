package com.theory.lombok;

public class LombokStudentRunner {
    public static void main(String[] args) {
        LombokStudent lombokStudent = LombokStudent.builder()
                .name("Pasquale")
                .lastname("Cannavacciuolo")
                .email("p.cannavacciuolo@icloud.com")
                .username("pandorenki")
                .age(24)
                .enabled(true)
                .build();
    }
}
