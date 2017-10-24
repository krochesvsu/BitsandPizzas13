package com.hfad.bitsandpizzas;

public class Salad {
    private String name;
    private int imageResourceId;

    public static final Salad[] salads = {
            new Salad("Caesar", R.drawable.caesar),
            new Salad("Pasta", R.drawable.pasta)
    };

    private Salad(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}