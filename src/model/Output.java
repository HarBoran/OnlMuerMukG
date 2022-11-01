package model;

public class Output {

    private String restaurantName;
    private String restaurantCategory;
    private float AgvGrade;
    private double distance;
    private double latitude;
    private double hardness;
    private double latitude_user;
    private double hardness_user;


    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public float getAgvGrade() {
        return AgvGrade;
    }

    public void setAgvGrade(float agvGrade) {
        AgvGrade = agvGrade;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public double getLatitude_user() {
        return latitude_user;
    }

    public void setLatitude_user(double latitude_user) {
        this.latitude_user = latitude_user;
    }

    public double getHardness_user() {
        return hardness_user;
    }

    public void setHardness_user(double hardness_user) {
        this.hardness_user = hardness_user;
    }
}
