package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


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

    public ArrayList<Integer> queryOMMG() {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT " + TABLE_RESTAURANT+"."+COLUMN_RESTAURANT_ID + ", " + "111.64*ABS(("+COLUMN_LATITUDE+"-"+COLUMN_LATITUDE_USER+")-("+COLUMN_LATITUDE+"-"+COLUMN_LATITUDE_USER+") + ("+COLUMN_HARDNESS+"-"+COLUMN_HARDNESS_USER+"))" + " AS DistanceSquared");
        sb.append(" FROM " + TABLE_RESTAURANT + " LEFT JOIN " + TABLE_RESTAURANT_MENU);
        sb.append(" ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_RESTAURANT_MENU + "." + COLUMN_RESTAURANT_ID);
        sb.append(" LEFT JOIN " + TABLE_MENU+" ON " + TABLE_RESTAURANT_MENU + "." + COLUMN_MENU_ID + " = " + TABLE_MENU + "." + COLUMN_MENU_ID);
        sb.append(" LEFT JOIN " + TABLE_USER_RAP + " ON " + TABLE_RESTAURANT+"."+COLUMN_RESTAURANT_ID+" = "+TABLE_USER_RAP+"."+COLUMN_RESTAURANT_ID);
        sb.append(" LEFT JOIN " + TABLE_USER + " ON " + TABLE_USER_RAP+"."+COLUMN_USER_ID+" = "+TABLE_USER+"."+COLUMN_USER_ID);
        sb.append(" WHERE " + "DistanceSquared" + " > " + 0);

        //        if(!(pf.b11 && pf.b22)){
//            AND
//        }else {
//          WHERE
//        }

        // double[] dd ={0.01, 0.09, 0.25, 1, 25, 100};
        //6400 * 2 * 3.14 / 360 = 111.64444444...

        PrintFrame pf = new PrintFrame();

        pf.b11 =false; //전채
        pf.b12 =false; //한식
        pf.b13 =false; //일식
        pf.b14 =false; //양식
        pf.b15 =false; //중식
        pf.b16 =false; //기타

        if(!pf.b11) {
            if (pf.b12) {
                sb.append(" AND ");
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"한식\"");
                if (!(!pf.b13 && !pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b13) {
                if (!pf.b12) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"일식\"");
                if (!(!pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b14) {
                if (!pf.b12 && !pf.b13) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"양식\"");
                if (!(!pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b15) {
                if (!pf.b12 && !pf.b13 && !pf.b14) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"중식\"");
                if (!(!pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b16) {
                if (!pf.b12 && !pf.b13 && !pf.b14 && !pf.b15) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"기타\"");
            }
        }

        pf.b21 = false;
        pf.b22 = true;
        pf.b23 = true;
        pf.b24 = true;
        pf.b25 = true;
        pf.b26 = true;
        pf.b27 = true;
        pf.b28 = false;

        if (!pf.b21) {
            if (pf.b22) {
                sb.append(" AND ");
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"쌀/밥\"");
                if (!(!pf.b23 && !pf.b24 && !pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b23) {
                if (!pf.b22) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"면요리\"");
                if (!(!pf.b24 && !pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b24) {
                if (!pf.b22 && !pf.b23) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"국/탕\"");
                if (!(!pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b25) {
                if (!pf.b22 && !pf.b23 && !pf.b24) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"고기\"");
                if (!(!pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b26) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"채식\"");
                if (!(!pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b27) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25 && !pf.b26) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"디저트\"");
                if (!(!pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b28) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25 && !pf.b26 && !pf.b27) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"기타\"");
            }
        }

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
        sb.append("SELECT " + COLUMN_RESTAURANT_NAME + ", " + COLUMN_RESTAURANT_CATEGORY + ", " + "AVG(" + COLUMN_GRADE + ")" + ", " + "111.64*ABS((" + COLUMN_LATITUDE + "-" + COLUMN_LATITUDE_USER + ")-(" + COLUMN_LATITUDE + "-" + COLUMN_LATITUDE_USER + ") + (" + COLUMN_HARDNESS + "-" + COLUMN_HARDNESS_USER + "))" + "AS DistanceSquared");
        sb.append(" FROM " + TABLE_RESTAURANT + " LEFT JOIN " + TABLE_USER_RAP);
        sb.append(" ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_USER_RAP + "." + COLUMN_RESTAURANT_ID);
        sb.append(" LEFT JOIN " + TABLE_USER);
        sb.append(" ON " + TABLE_USER_RAP + "." + COLUMN_USER_ID + " = " + TABLE_USER + "." + COLUMN_USER_ID);
//          sb.append(" GROUP BY " + COLUMN_RESTAURANT_NAME);
        sb.append(" WHERE " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + id);

//        System.out.println(sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Output> ommgs = new ArrayList<Output>();

            while (results.next()) {
                Output ommg = new Output();
                ommg.setRestaurantName(results.getString(COLUMN_RESTAURANT_NAME));
                ommg.setRestaurantCategory(results.getString(COLUMN_RESTAURANT_CATEGORY));
                ommg.setAgvGrade(results.getFloat(3));
                ommg.setDistance(Math.sqrt(results.getFloat(4)));
                ommgs.add(ommg);
            }

//            Iterator<Output> iterator = ommgs.iterator();
//
//            while (iterator.hasNext()) {
//                Output ommg = new Output();
//                ommg.setRestaurantName(results.getString(COLUMN_RESTAURANT_NAME));
//                ommg.setRestaurantCategory(results.getString(COLUMN_RESTAURANT_CATEGORY));
//                ommg.setAgvGrade(results.getFloat(3));
//                ommg.setDistance(Math.sqrt(results.getFloat(4)));
//                ommgs.add(ommg);
//            }

            return ommgs;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

    }
}