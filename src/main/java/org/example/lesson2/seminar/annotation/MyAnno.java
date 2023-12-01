package org.example.lesson2.seminar.annotation;

import java.lang.reflect.Field;

public class MyAnno {
    public static void main(String[] args) throws Exception {
        AnnotationExamples annotationExamples = new AnnotationExamples();
//        Field positive = AnnotationExamples.class.getDeclaredField("positive");
//        positive.setAccessible(true);
//        RandomInteger annotation = positive.getAnnotation(RandomInteger.class);
//        System.out.println(annotation.min());
//        System.out.println(annotation.max());

        RandomIntegerProcessor.processObject(annotationExamples);

        System.out.println(annotationExamples.getPositive());
        System.out.println(annotationExamples.getNegative());

    }
}


