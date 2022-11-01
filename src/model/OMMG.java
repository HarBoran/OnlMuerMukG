package model;

public class OMMG {

    private String restaurantName;
    private String restaurantCategory;
    private float AgvGrade;
    private double distance;

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


}
