package com.example.examennov;

public class Car {

    private String carName;
    private int carImage;

    public Car(String carName, int carImage) {
        this.carName = carName;
        this.carImage = carImage;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }
}
