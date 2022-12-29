package com.company;

public class Artikl {
    private String name;
    private double price;
    private String kod;
    public Artikl(String name, int price, String kod) {
        this.name = name;
        this.price = price;
        this.kod = kod;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getKod(){
        return kod;
    }
}
