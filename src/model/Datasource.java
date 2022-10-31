package model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;
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
}
