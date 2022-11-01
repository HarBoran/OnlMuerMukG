package model;

import java.sql.*;
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

    public static final String COLUMN_MENU_ID = "menu_id"; //매뉴인덱스
    public static final String COLUMN_FOOD_NAME = "food_name"; //음식명
    public static final String COLUMN_FOOD_CATEGORY = "food_category"; //음식카테고리
    public static final String COLUMN_RESTAURANT_ID = "restaurant_id"; //가게인덱스
    public static final String COLUMN_OWNER_ID = "owner_id"; //가게주인ID
    public static final String COLUMN_RESTAURANT_NAME = "restaurant_name"; //가게명
    public static final String COLUMN_LATITUDE = "latitude"; //위도 좌표
    public static final String COLUMN_HARDNESS = "hardness";//경도 좌표
    public static final String COLUMN_RESTAURANT_CATEGORY = "restaurant_category"; //카테고리
    public static final String COLUMN_SIGNATURE_FOOD = "signature_food"; //대표음식
    public static final String COLUMN_USER_ID = "user_id"; //유저 인덱스
    public static final String COLUMN_LOGIN_ID = "login_id"; //로그인 아이디
    public static final String COLUMN_LATITUDE_USER = "latitude_user"; //위도 좌표
    public static final String COLUMN_HARDNESS_USER = "hardness_user";//경도 좌표
    public static final String COLUMN_EAT_DATE = "eat_date"; //이용 날짜
    public static final String COLUMN_EAT_TIME = "eat_time"; //도착 시간
    public static final String COLUMN_GRADE = "grade"; //평점

    private Connection conn;

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

    String[] rc = {"전체", "한식", "일식", "양식", "중식", "기타"};
    String[] ca = {"전체", "쌀밥", "면요리", "국탕", "고기", "채식", "디저트", "기타"};
    double[] dd ={0.01, 0.09, 0.25, 1, 25, 100};
    // 많이찾는, 평점이 좋은




    public ArrayList<Integer> queryOMMG() {
        PrintFrame pf = new PrintFrame();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " + TABLE_RESTAURANT+"."+COLUMN_RESTAURANT_ID + ", " + COLUMN_LATITUDE +", " + COLUMN_HARDNESS +" FROM ");
        sb.append(TABLE_RESTAURANT + " LEFT JOIN " + TABLE_RESTAURANT_MENU);
        sb.append(" ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_RESTAURANT_MENU + "." + COLUMN_RESTAURANT_ID);
        sb.append(" LEFT JOIN " + TABLE_MENU);
        sb.append(" ON " + TABLE_RESTAURANT_MENU + "." + COLUMN_MENU_ID + " = " + TABLE_MENU + "." + COLUMN_MENU_ID);
        if(pf.b11=true){
            if(!pf.b12 && !pf.b13 && !pf.b14 && !pf.b15 && !pf.b16) {
            }else{
                sb.append(" where");
            }
        } else if (pf.b12=true) {
            sb.append(" "+COLUMN_RESTAURANT_CATEGORY +  " = " + "\"한식\"");
            if(!pf.b13 && !pf.b14 && !pf.b15 && !pf.b16) {
            }else{
                sb.append(" or");
            }
        } else if (pf.b13=true) {
            sb.append(" "+COLUMN_RESTAURANT_CATEGORY +  " = " + "\"일식\"");
            if(!pf.b14 && !pf.b15 && !pf.b16) {
            }else{
                sb.append(" or");
            }
        } else if (pf.b14=true) {
            sb.append(" "+COLUMN_RESTAURANT_CATEGORY +  " = " + "\"중식\"");
            if(!pf.b15 && !pf.b16) {
            }else{
                sb.append(" or");
            }
        } else if (pf.b15=true) {
            sb.append(" "+COLUMN_RESTAURANT_CATEGORY +  " = " + "\"기타\"");
        }


//        sb.append(" AND " + COLUMN_FOOD_CATEGORY + " = " + "\"국/탕\"");

//        "POWER(111.64*("+COLUMN_LATITUDE+"-"+COLUMN_LATITUDE_USER+"),2) + POWER(111.64*("+COLUMN_HARDNESS+
//        "-"+COLUMN_HARDNESS_USER+"),2)");
        System.out.println(sb.toString());

        ArrayList<Integer> restaurantIds = new ArrayList();

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            while(results.next()) {
                restaurantIds.add(results.getInt(COLUMN_RESTAURANT_ID));
            }
            return restaurantIds;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<Output> Output(Integer id){

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT "+ COLUMN_RESTAURANT_NAME+", "+COLUMN_RESTAURANT_CATEGORY+", "+"AVG("+COLUMN_GRADE+")"+", "+COLUMN_LATITUDE+", "+COLUMN_HARDNESS+", "+COLUMN_LATITUDE_USER+", "+COLUMN_HARDNESS_USER);
        //6400 * 2 * 3.14 / 360 = 111.64444444...
        sb.append(" FROM "+TABLE_RESTAURANT + " LEFT JOIN " + TABLE_USER_RAP);
        sb.append(" ON "+TABLE_RESTAURANT+"."+COLUMN_RESTAURANT_ID+" = "+TABLE_USER_RAP+"."+COLUMN_RESTAURANT_ID);
        sb.append(" LEFT JOIN "+TABLE_USER);
        sb.append(" ON " + TABLE_USER_RAP+"."+COLUMN_USER_ID+" = "+TABLE_USER+"."+COLUMN_USER_ID);
        sb.append(" WHERE "+ TABLE_RESTAURANT+"."+COLUMN_RESTAURANT_ID+" = " + id);

        System.out.println(sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Output> ommgs = new ArrayList<Output>();

            while (results.next()) {
                Output ommg = new Output();
                ommg.setRestaurantName(results.getString(COLUMN_RESTAURANT_NAME));
                ommg.setRestaurantCategory(results.getString(COLUMN_RESTAURANT_CATEGORY));
                ommg.setAgvGrade(results.getFloat(3));
                ommg.setLatitude(results.getDouble(COLUMN_LATITUDE));
                ommg.setHardness(results.getDouble(COLUMN_HARDNESS));
                ommg.setLatitude_user(results.getDouble(COLUMN_LATITUDE_USER));
                ommg.setHardness_user(results.getDouble(COLUMN_HARDNESS_USER));
                ommgs.add(ommg);
            }
            return ommgs;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}