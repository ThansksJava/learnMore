package com.learn.java8;

/**
 * @author Feng Jie
 * @date 2021/12/27 11:38
 */
public class Apple {
    private Integer weight = 0;
    private String color = "";
    public Apple(){}
    public Apple(Integer weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
