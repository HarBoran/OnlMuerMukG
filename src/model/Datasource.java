package model;

//<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//public class Datasource {
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
//=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
//>>>>>>> 76397a0a39b86248d6ef8427ce089bf6ba346fb7
    public static final String DB_NAME = "ommg.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:db/" + DB_NAME;

    public static final String TABLE_MENU = "menu";
    public static final String TABLE_RESTAURANT_MENU = "restaurant_menu";
    public static final String TABLE_RESTAURANT = "restaurant";
    public static final String TABLE_USER = "user";
    public static final String TABLE_USER_RAP = "user_rap";
//<<<<<<< HEAD
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
    public static final String COLUMN_GRADE_ID = "grade_id";

    private static Connection con;
    public static final String ERROR = "오류 발생";
//    public static final String COLUMN_MENU_ID = "menu_id"; //매뉴인덱스
//    public static final String COLUMN_FOOD_NAME = "food_name"; //음식명
//    public static final String COLUMN_FOOD_CATEGORY = "food_category"; //음식카테고리
//    public static final String COLUMN_RESTAURANT_ID = "restaurant_id"; //가게인덱스
//    public static final String COLUMN_OWNER_ID = "owner_id"; //가게주인ID
//    public static final String COLUMN_RESTAURANT_NAME = "restaurant_name"; //가게명
//    public static final String COLUMN_LATITUDE = "latitude"; //위도 좌표
//    public static final String COLUMN_HARDNESS = "hardness";//경도 좌표
//    public static final String COLUMN_RESTAURANT_CATEGORY = "restaurant_category"; //카테고리
//    public static final String COLUMN_SIGNATURE_FOOD = "signature_food"; //대표음식
//    public static final String COLUMN_USER_ID = "user_id"; //유저 인덱스
//    public static final String COLUMN_LOGIN_ID = "login_id"; //로그인 아이디
//    public static final String COLUMN_LATITUDE_USER = "latitude_user"; //위도 좌표
//    public static final String COLUMN_HARDNESS_USER = "hardness_user";//경도 좌표
//    public static final String COLUMN_EAT_DATE = "eat_date"; //이용 날짜
//    public static final String COLUMN_EAT_TIME = "eat_time"; //도착 시간
//    public static final String COLUMN_GRADE = "grade"; //평점
//
    private static Connection conn;

    public static Connection getCon() {
        return con;
    }

    public static Connection getConn() {
        return conn;
    }
//>>>>>>> 76397a0a39b86248d6ef8427ce089bf6ba346fb7

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

//<<<<<<< HEAD
//=======
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



    /*
        구현 해야하는 쿼리문
        restaurant_category 따라 음식점 선택하기
        AND
        선택한 food_category에 따라 음식점 선택하기
        AND
        선택한 거리에 따라 음식 선택하기
        AND
        많이 찾는 음식점 선택하기
        AND
        평점 좋은 음식점 선택하기
    */


    //SELECT COLUMN_RESTAURANT_ID
    //FROM TABLE_RESTAURANT LEFT JOIN TABLE_RESTAURANT_MENU
    //ON TABLE_RESTAURANT.COLUMN_RESTAURANT_ID = TABLE_RESTAURANT_MENU.COLUMN_RESTAURANT_ID
    //TABLE_RESTAURANT_MENU LEFT JOIN TABLE_MENU
    //ON TABLE_RESTAURANT_MENU.COLUMN_MENU_ID = TABLE_MENU.COLUMN_MENU_ID
    //WHERE TABLE_MENU.COLUMN_FOOD_CATEGORY = 1 or COLUMN_RESTAURANT_CATEGORY
    //AND TABLE_RESTAURANT.COLUMN_RESTAURANT_CATEGORY = 1
    //	or TABLE_RESTAURANT.COLUMN_RESTAURANT_CATEGORY = 3
    //    or TABLE_RESTAURANT.COLUMN_RESTAURANT_CATEGORY = 5

//    #COLUMN_RESTAURANT_ID가 선택됨
//    SELECT COLUMN_RESTAURANT_NAME, COLUMN_RESTAURANT_CATEGORY, AGV(COLUMN_GRADE), COLUMN_LATITUDE, COLUMN_HARDNESS, COLUMN_LATITUDE_USER, COLUMN_HARDNESS_USER
//    FROM TABLE_RESTAURANT LEFT JOIN TABLE_USER_RAP
//    ON TABLE_RESTAURANT.COLUMN_RESTAURANT_ID = TABLE_USER_RAP.COLUMN_RESTAURANT_ID
//    TABLE_USER_RAP LEFT JOIN TABLE_USER
//    ON TABLE_USER_RAP.COLUMN_USER_ID = TABLE_USER.COLUMN_USER_ID
//    WHERE COLUMN_RESTAURANT_ID = 123


    public ArrayList<Integer> queryOMMG() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " + COLUMN_RESTAURANT_ID + " FROM ");
        sb.append(TABLE_RESTAURANT + " LEFT JOIN " + TABLE_RESTAURANT_MENU);
        sb.append(" ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_RESTAURANT_MENU + "." + COLUMN_RESTAURANT_ID);
        sb.append(" " + TABLE_RESTAURANT_MENU + " LEFT JOIN " + TABLE_MENU);
        sb.append(" ON " + TABLE_RESTAURANT_MENU + "." + COLUMN_MENU_ID + " = " + TABLE_MENU + "." + COLUMN_MENU_ID);
        sb.append(" WHERE " + TABLE_MENU + "." + COLUMN_FOOD_CATEGORY + " = " + "1");
        sb.append(" or " + COLUMN_RESTAURANT_CATEGORY + " = " + "1");
        sb.append(" AND " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_CATEGORY + " = " + "1");
        sb.append(" or " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_CATEGORY + " = " + "3");
        sb.append(" or " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_CATEGORY + " = " + "5");

        System.out.println(sb.toString());

        ArrayList<Integer> restaurantIds = new ArrayList();

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            while(results.next()) {
                restaurantIds.add(results.getInt(COLUMN_RESTAURANT_ID));
            }
//            for(int i : restaurantIds){
//                System.out.println(restaurantIds.get(i));
//            }
            return restaurantIds;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<OMMG> OMMG(Integer id){

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT "+ COLUMN_RESTAURANT_NAME+", "+COLUMN_RESTAURANT_CATEGORY+", "+"AGV("+COLUMN_GRADE+")"+", ");
        //6400 * 2 * 3.14 / 360 = 111.64444444...
        sb.append("POWER(111.64*("+COLUMN_LATITUDE+"-"+COLUMN_LATITUDE_USER+"),2) + POWER(111.64*("+COLUMN_HARDNESS+"-"+COLUMN_HARDNESS_USER+"),2))");
        sb.append(" FROM "+TABLE_RESTAURANT + " LEFT JOIN " + TABLE_USER_RAP);
        sb.append(" ON "+TABLE_RESTAURANT+"."+COLUMN_RESTAURANT_ID+" = "+TABLE_USER_RAP+"."+COLUMN_RESTAURANT_ID);
        sb.append(" "+TABLE_USER_RAP+" LEFT JOIN "+TABLE_USER);
        sb.append(" ON " + TABLE_USER_RAP+"."+COLUMN_USER_ID+" = "+TABLE_USER+"."+COLUMN_USER_ID);
        sb.append(" WHERE "+ COLUMN_RESTAURANT_ID+" = " + id);

        System.out.println(sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<OMMG> ommgs = new ArrayList<OMMG>();

            while (results.next()) {
                OMMG ommg = new OMMG();
                ommg.setRestaurantName(results.getString(COLUMN_RESTAURANT_NAME));
                ommg.setRestaurantCategory(results.getString(COLUMN_RESTAURANT_CATEGORY));
                ommg.setAgvGrade(results.getFloat(3));
                ommg.setDistance(Math.sqrt(results.getDouble(4)));
                ommgs.add(ommg);
            }
            return ommgs;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}
//>>>>>>> 76397a0a39b86248d6ef8427ce089bf6ba346fb7
