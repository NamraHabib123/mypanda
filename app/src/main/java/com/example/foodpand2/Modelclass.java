package com.example.foodpand2;

public class Modelclass {
    String resturantnames;
    int price;
    int rating;
    int numbersofreviews;

    public Modelclass() {
    }

    public Modelclass(String resturantnames, int price, int rating, int numbersofreviews) {
        this.resturantnames = resturantnames;

        this.price = price;
        this.rating = rating;
        this.numbersofreviews = numbersofreviews;
    }

    public String getResturantnames() {
        return resturantnames;
    }

    public void setResturantnames(String resturantnames) {
        this.resturantnames = resturantnames;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNumbersofreviews() {
        return numbersofreviews;
    }

    public void setNumbersofreviews(int numbersofreviews) {
        this.numbersofreviews = numbersofreviews;
    }
}
