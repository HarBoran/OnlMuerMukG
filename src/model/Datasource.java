package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    /*

        //매뉴 테이블 : menu
        메뉴인덱스 : menu_id
        음식명 : food_name
        음식카테고리 : food_category

        //음식점매뉴 테이블 :  restaurant_menu
        가게인덱스 : restaurant_id
        메뉴인덱스 : menu_id

        //음식점 테이블 : restaurant
        인덱스 : restaurant_id
        가게주인ID : owner_id
        가게명 : restaurant_name
        위도 좌표 : latitude
        경도 좌표 : hardness
        카테고리 : restaurant_category
        대표음식 : signature_food

        //유저 테이블 : user
        인덱스 : user_id
        로그인 아이디 : login_id
        위도 좌표 : latitude_user
        경도 좌표 : hardness_user

        //유저기록 : user_rap
        유저 인덱스 : user_id
        식당 인덱스 : restaurant_id
        이용 날짜 : eat_date
        도착 시간 : eat_time
        평점 : grade
    */
    public static final String DB_NAME = "ommg.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public static final String TABLE_MENU = "menu";
    public static final String TABLE_RESTAURANT_MENU = "restaurant_menu";
    public static final String TABLE_RESTAURANT = "restaurant";
    public static final String TABLE_USER = "user";
    public static final String TABLE_USER_RAP = "user_rap";

    public static final String COLUMN_MENU_ID = "menu_id";
    public static final String COLUMN_FOOD_NAME = "food_name";
    public static final String COLUMN_FOOD_CATEGORY = "food_category";
    public static final String COLUMN_RESTAURANT_ID = "restaurant_id";
    public static final String COLUMN_OWNER_ID = "owner_id";
    public static final String COLUMN_RESTAURANT_NAME = "restaurant_name";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_HARDNESS = "hardness";
    public static final String COLUMN_RESTAURANT_CATEGORY = "restaurant_category";
    public static final String COLUMN_SIGNATURE_FOOD = "signature_food";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_LOGIN_ID = "login_id";
    public static final String COLUMN_LATITUDE_USER = "latitude_user";
    public static final String COLUMN_HARDNESS_USER = "hardness_user";
    public static final String COLUMN_USER_RAP = "user_rap";
    public static final String COLUMN_EAT_DATE = "eat_date";
    public static final String COLUMN_EAT_TIME = "eat_time";
    public static final String COLUMN_GRADE = "grade";

    private static Connection con;
    public static final String ERROR = "오류 발생";

    public boolean open() {
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("in was connected");
            return true;

        } catch (SQLException e) {
            System.out.println(ERROR + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
