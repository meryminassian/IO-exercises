package com.company;

public class Circle {
    private double radius;
    private String name;

    public Circle() {
    }

    public Circle(double radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double area(){
        return Math.sqrt(getRadius()) * Math.PI;
    }

    public double perimeter(){
        return 2* getRadius() * Math.PI;
    }

    public String toString(){
        return "{\nname: " + getName() +"\n radius: " + getRadius()
                + "\narea:" + area() + "\n perimeter" + perimeter() + "\n }";
    }
}
