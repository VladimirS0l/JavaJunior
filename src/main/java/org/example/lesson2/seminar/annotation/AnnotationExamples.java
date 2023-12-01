package org.example.lesson2.seminar.annotation;

public class AnnotationExamples {

    private String string;
    @RandomInteger(min = 1, max = 20)
    private Integer positive;
    @RandomInteger
    private Integer negative;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getPositive() {
        return positive;
    }

    public void setPositive(Integer positive) {
        this.positive = positive;
    }

    public Integer getNegative() {
        return negative;
    }

    public void setNegative(Integer negative) {
        this.negative = negative;
    }
}
