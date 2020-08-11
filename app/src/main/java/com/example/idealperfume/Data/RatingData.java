package com.example.idealperfume.Data;

public class RatingData {
    String starPoint, one, two, three, four, five;

    public RatingData(String starPoint, String one, String two,
                      String three, String four, String five) {
        this.starPoint = starPoint;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
    }

    public String getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(String starPoint) {
        this.starPoint = starPoint;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }
}
