package model;

import model.frame_Owner_Collect.frame_Owner_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
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
        switch (scan.nextInt()) {
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
        INSERT.append(LOGIN_FILTER(con)).append("',");
        System.out.print("위도를 입력하세요. : ");
        INSERT.append(scan.nextDouble()).append(",");
        System.out.print("경도를 입력하세요. : ");
        INSERT.append(scan.nextDouble()).append(")");

        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(INSERT));

        } catch (SQLException e) {
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

        String name = LOGIN_FILTER(con);
        INSERT_USER.append(name).append("',");
        INSERT_RESTAURANT.append(name).append("',");

        INSERT_RESTAURANT.append("'").append(RESTAURANT_NAME_CHECK(con)).append("',");

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

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String LOGIN_FILTER(Connection con) {

        System.out.print("아이디를 입력하세요. : ");
        String name = scan.next();

        StringBuilder NAME_CHECK = new StringBuilder("SELECT ")
                .append(data.COLUMN_LOGIN_ID)
                .append(" from ").append(data.TABLE_USER)
                .append(" where ").append(data.COLUMN_LOGIN_ID)
                .append(" = '").append(name).append("'");
        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(NAME_CHECK))) {
            results.getString(data.COLUMN_LOGIN_ID);
            return null;
        } catch (SQLException e) {
            return name;
        }
    }

    public static String RESTAURANT_NAME_CHECK(Connection con){
        do {
            JFrame JF = new JFrame();
            JF.setSize(300, 400);
            JF.setTitle("Owner_Main");
            JF.setLocationRelativeTo(null);
            JF.setResizable(false);
            JF.getContentPane().setLayout(null);
//            System.out.print("음식점 이름을 입력하세요. : ");
//            String restrunt_name = scan.next();

            JLabel text = new JLabel("음식점 이름을 입력하세요. ");
            TextField restrunt_name = new TextField();
            JButton button = new JButton("이름 확인");
            JButton go_back = new JButton("돌아가기");

            text.setBounds(20, 80, 500, 30);
            restrunt_name.setBounds(20, 110, 90, 30);
            button.setBounds(20, 140, 100, 30);
            go_back.setBounds(150, 300, 100, 30);

            JF.add(text);
            JF.add(restrunt_name);
            JF.add(button);
            JF.add(go_back);
            JF.setVisible(true);

            StringBuilder RESTRUNT_NAME_CHECK = new StringBuilder("SELECT ")
                    .append(data.COLUMN_RESTAURANT_NAME)
                    .append(" from ").append(data.TABLE_RESTAURANT)
                    .append(" where ").append(data.COLUMN_RESTAURANT_NAME)
                    .append(" = '").append(restrunt_name).append("'");
            try (Statement st = con.createStatement();
                 ResultSet results = st.executeQuery(String.valueOf(RESTRUNT_NAME_CHECK))) {
                results.getString(data.COLUMN_RESTAURANT_NAME);
            } catch (SQLException e) {
                return String.valueOf(restrunt_name);
            }

        }while (true);
    }
}
