package com.theory.annotation;

@TestAnnotation
@SingleTestAnnotation(
        item = "Ciao",
        value = TestAnnotationEnum.SUCCESS)

public class TestTheAnnotation {
    @SingleTestAnnotation(
            item = "Ciao",
            value = TestAnnotationEnum.SUCCESS)
    private String annotation;
    public static void main(String[] args) {
     TestTheAnnotation testTheAnnotation = new TestTheAnnotation();
    }
}
