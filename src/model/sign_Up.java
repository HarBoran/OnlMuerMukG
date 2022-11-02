package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class sign_Up {
    static Datasource data = new Datasource();
    static Scanner scan = new Scanner(System.in);
    public static void SIGN_UP_SELECT(Connection con) {
        System.out.println("고객님의 사용 용도를 알려주세요.");
        System.out.println("1.일반 회원가입");
        System.out.println("2.음식점 주인 가입");
        System.out.println("3.로비로 돌아가기");
        System.out.print("입력 : ");
        switch (scan.nextInt()){
            case 1:
                NOMAL_SIGN_UP(con);
                break;
            case 2:
                OWNER_SIGN_UP(con);
                break;
            case 3:
                break;
        }

    }
    public static void NOMAL_SIGN_UP(Connection con) {
        StringBuilder INSERT = new StringBuilder("INSERT INTO ")
                .append(data.TABLE_USER)
                .append(" ( ").append(data.COLUMN_LOGIN_ID)
                .append(",").append(data.COLUMN_LATITUDE_USER)
                .append(",").append(data.COLUMN_HARDNESS_USER).append(") VALUES ('");
        System.out.println("일반회원가입입니다.");
        System.out.print("이름을 입력하세요. : ");
        INSERT.append(scan.next()).append("',");
        System.out.print("위도를 입력하세요. : ");
        INSERT.append(scan.nextDouble()).append(",");
        System.out.print("경도를 입력하세요. : ");
        INSERT.append(scan.nextDouble()).append(")");

        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(INSERT));

        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void OWNER_SIGN_UP(Connection con) {
        StringBuilder INSERT_USER = new StringBuilder("INSERT INTO ")
                .append(data.TABLE_USER)
                .append(" ( ").append(data.COLUMN_LOGIN_ID)
                .append(",").append(data.COLUMN_LATITUDE_USER)
                .append(",").append(data.COLUMN_HARDNESS_USER).append(") VALUES ('");

        StringBuilder INSERT_RESTAURANT = new StringBuilder("INSERT INTO ")
                .append(data.TABLE_RESTAURANT)
                .append(" ( ").append(data.COLUMN_OWNER_ID)
                .append(",").append(data.COLUMN_RESTAURANT_NAME)
                .append(",").append(data.COLUMN_LATITUDE)
                .append(",").append(data.COLUMN_HARDNESS)
                .append(",").append(data.COLUMN_RESTAURANT_CATEGORY)
                .append(",").append(data.COLUMN_SIGNATURE_FOOD)
                .append(") VALUES ('");
        System.out.println("음식점 주인 회원가입입니다.");
        System.out.print("이름을 입력하세요. : ");
        String name = scan.next();
        INSERT_USER.append(name).append("',");
        INSERT_RESTAURANT.append(name).append("',");

        System.out.print("음식점 이름을 입력하세요. : ");
        INSERT_RESTAURANT.append("'").append(scan.next()).append("',");

        System.out.print("위도를 입력하세요. : ");
        double latitude = scan.nextDouble();
        INSERT_USER.append(latitude).append(",");
        INSERT_RESTAURANT.append(latitude).append(",");

        System.out.print("경도를 입력하세요. : ");
        double hardness = scan.nextDouble();
        INSERT_USER.append(hardness).append(")");
        INSERT_RESTAURANT.append(hardness).append(",");

        System.out.print("음식점의 카테고리를 입력하세요. : ");
        INSERT_RESTAURANT.append("'").append(scan.next()).append("',");

        System.out.print("대표 음식을 입력하세요. : ");
        INSERT_RESTAURANT.append("'").append(scan.next()).append("')");

        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(INSERT_USER));
            st.execute(String.valueOf(INSERT_RESTAURANT));

        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }
}
