package com.theory.annotation;

@TestAnnotation
@SingleTestAnnotation(
        item = "Ciao",
        value = TestAnnotationEnum.SUCCESS)

public class TestTheAnnotation {
    public static void main(String[] args) {
     TestTheAnnotation testTheAnnotation = new TestTheAnnotation();
    }
}
