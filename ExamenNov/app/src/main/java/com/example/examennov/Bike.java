package com.example.examennov;

public class Bike {

    private String bikeName;
    private int bikeImage;

    public Bike(String bikeName, int bikeImage) {
        this.bikeName = bikeName;
        this.bikeImage = bikeImage;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public int getBikeImage() {
        return bikeImage;
    }

    public void setBikeImage(int bikeImage) {
        this.bikeImage = bikeImage;
    }
}


