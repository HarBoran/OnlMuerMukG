package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
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

    /*
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("It was connected");
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }
    */


    /*
    구현 해야하는 쿼리문
        선택한 restaurant_category 따라 음식점 선택하기

        선택한 food_category에 따라 음식점 선택하기

        선택한 거리에 따라 음식 선택하기

        많이 찾는 음식점 선택하기

        평점 좋은 음식점 선택하기
*/

}
