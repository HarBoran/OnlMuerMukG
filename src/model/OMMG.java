package model;

public class OMMG {

    private String restaurantName;
    private String restaurantCategory;
    private float AgvGrade;
    private int latitude;
    private int hardness;
    private int latitudeUser;
    private int hardnessUser;

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

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public int getLatitudeUser() {
        return latitudeUser;
    }

    public void setLatitudeUser(int latitudeUser) {
        this.latitudeUser = latitudeUser;
    }

    public int getHardnessUser() {
        return hardnessUser;
    }

    public void setHardnessUser(int hardnessUser) {
        this.hardnessUser = hardnessUser;
    }
}
