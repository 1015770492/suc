package top.yumbo.springcloud.car.dto;

import org.bouncycastle.cms.bc.BcKeyTransRecipientInfoGenerator;

public class Myreserve {
    private long carId;
    private String carType;
    private String carBrand;
    private String carColor;
    private double carPrice;
    private String carDescription;
    private String carInfo;
    private String carArea;
    private String carImage;
    private String carRegtime;
    private String carMileage;
    private String carStatus;
    private long reserveId;

    public long getReserveId() {
        return reserveId;
    }

    public void setReserveId(long reserveId) {
        this.reserveId = reserveId;
    }

    private String reserveTime;
    private String reservePlace;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public String getCarArea() {
        return carArea;
    }

    public void setCarArea(String carArea) {
        this.carArea = carArea;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getCarRegtime() {
        return carRegtime;
    }

    public void setCarRegtime(String carRegtime) {
        this.carRegtime = carRegtime;
    }

    public String getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(String carMileage) {
        this.carMileage = carMileage;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getReservePlace() {
        return reservePlace;
    }

    public void setReservePlace(String reservePlace) {
        this.reservePlace = reservePlace;
    }
}
