package top.yumbo.springcloud.user.dto;

/**
 * @author yyh
 * @create 2021-03-16 15:31
 */
public class Mycollect {
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
    private long collectId;
    private long userId;

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

    public long getCollectId() {
        return collectId;
    }

    public void setCollectId(long collectId) {
        this.collectId = collectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
