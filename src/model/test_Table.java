package model;

import model.ArrayList_Collect.*;
import model.frame_Administrator_Collect.frame_test_Table;
import model.frame_Administrator_Data_Collect.frame_Restaurant_Setting;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class test_Table{
    static Datasource data = new Datasource();
    public static Scanner scan = new Scanner(System.in);
//    public static void SELECT_TABLE(Connection con) {
//        while (true) {
//            System.out.println("테이블 상태확인");
//            System.out.println("1.유저, 2.유저기록, 3.음식점, 4.음식점메뉴, 5.메뉴, 6.나가기");
//            System.out.print("선택 : ");
//            int sel = scan.nextInt();
//            switch (sel){
//                case 1:
//                    select_USER_table(con);
//                    break;
//                case 2:
//                    select_USER_RAP_table(con);
//                    break;
//                case 3:
//                    select_RESTAURANT_table(con);
//                    break;
//                case 4:
//                    select_RESTAURANT_MENU_table(con);
//                    break;
//                case 5:
//                    select_MENU_table(con);
//                    break;
//                case 6:
//                    return;
//            }
//        }
//    }

    static StringBuilder SELECT = new StringBuilder("SELECT * from ");

    public void select_USER_table(Connection con,String type) {
        SELECT.append(data.TABLE_USER).append(";");
        JFrame JF = new JFrame();
        JF.setSize(800, 600);
        JF.setTitle("test_Table");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            ArrayList<OMMG_USER> ouAr = new ArrayList<>();
            while (results.next()) {
                OMMG_USER ou = new OMMG_USER();
                ou.setUser_id(results.getInt(data.COLUMN_USER_ID));
                ou.setLogin_id(results.getString(data.COLUMN_LOGIN_ID));
                ou.setLatitude_user(results.getDouble(data.COLUMN_LATITUDE_USER));
                ou.setHardness_user(results.getDouble(data.COLUMN_HARDNESS_USER));
                ouAr.add(ou);
            }
            if(ouAr == null){
                    System.out.println("Can't find an artist");
                    return;
                }
            int count = 0;
                for (OMMG_USER a : ouAr) {
//                    System.out.println(data.COLUMN_USER_ID + " : " + a.getUser_id()
//                            + "  \t| "+ data.COLUMN_LOGIN_ID + " : " + a.getLogin_id()
//                            + " \t|" + data.COLUMN_LATITUDE_USER + " : " + a.getLatitude_user()
//                            + " \t|" + data.COLUMN_HARDNESS_USER + " : " + a.getHardness_user());
                    JLabel text = new JLabel(data.COLUMN_USER_ID + " : " + a.getUser_id()
                            + "  \t| "+ data.COLUMN_LOGIN_ID + " : " + a.getLogin_id()
                            + " \t|" + data.COLUMN_LATITUDE_USER + " : " + a.getLatitude_user()
                            + " \t|" + data.COLUMN_HARDNESS_USER + " : " + a.getHardness_user());
                    text.setBounds(10, count += 20, 800, 40);
                    JF.add(text);
                }

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
        SELECT = new StringBuilder("SELECT * from ");


        JButton go_back = new JButton("돌아가기");
        go_back.setBounds(650,500,100,30);

        JF.add(go_back);
        JF.setVisible(true);
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                frame_test_Table ftt = new frame_test_Table();
                ftt.frame_test_Table_Mathod(con, type);
            }
        };
        go_back.addActionListener(action);
    }

    public static void select_USER_RAP_table(Connection con,String type){
        SELECT.append(data.TABLE_USER_RAP).append(";");
        JFrame JF = new JFrame();
        JF.setSize(800, 600);
        JF.setTitle("test_Table");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);


        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            ArrayList<OMMG_USER_RAP> ourAr = new ArrayList<>();
            while (results.next()) {
                OMMG_USER_RAP our = new OMMG_USER_RAP();
                our.setUser_id(results.getInt(data.COLUMN_USER_ID));
                our.setRestaurant_id(results.getInt(data.COLUMN_RESTAURANT_ID));
                our.setEat_date(results.getString(data.COLUMN_EAT_DATE));
                our.setEat_time(results.getString(data.COLUMN_EAT_TIME));
                our.setGrade(results.getInt(data.COLUMN_GRADE));
                ourAr.add(our);
            }
            if(ourAr == null){
                System.out.println("Can't find an artist");
                return;
            }
            int count = 0;
            for (OMMG_USER_RAP a : ourAr ){
//                System.out.println(data.COLUMN_USER_ID + " : " + a.getUser_id()
//                        + "  \t| "+ data.COLUMN_RESTAURANT_ID + " : " + a.getRestaurant_id()
//                        + " \t|" + data.COLUMN_EAT_DATE + " : " + a.getEat_date()
//                        + " \t|" + data.COLUMN_EAT_TIME + " : " + a.getEat_time()
//                        + " \t|" + data.COLUMN_GRADE + " : " + a.getGrade());
                JLabel text = new JLabel(data.COLUMN_USER_ID + " : " + a.getUser_id()
                        + "  \t| "+ data.COLUMN_RESTAURANT_ID + " : " + a.getRestaurant_id()
                        + " \t|" + data.COLUMN_EAT_DATE + " : " + a.getEat_date()
                        + " \t|" + data.COLUMN_EAT_TIME + " : " + a.getEat_time()
                        + " \t|" + data.COLUMN_GRADE + " : " + a.getGrade());
                text.setBounds(10, count += 20, 800, 40);
                JF.add(text);
            }

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
        SELECT = new StringBuilder("SELECT * from ");

        JButton go_back = new JButton("돌아가기");
        go_back.setBounds(650,500,100,30);

        JF.add(go_back);
        JF.setVisible(true);
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                frame_test_Table ftt = new frame_test_Table();
                ftt.frame_test_Table_Mathod(con, type);;
            }
        };
        go_back.addActionListener(action);
    }


    public static void select_RESTAURANT_table(Connection con,String type){
        SELECT.append(data.TABLE_RESTAURANT).append(";");
        JFrame JF = new JFrame();
        JF.setSize(1000, 600);
        JF.setTitle("test_Table");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            ArrayList<OMMG_RESTAURANT> ourAr = new ArrayList<>();
            while (results.next()) {
                OMMG_RESTAURANT our = new OMMG_RESTAURANT();
                our.setRestraurant_id(results.getInt(data.COLUMN_RESTAURANT_ID));
                our.setOwner_id(results.getString(data.COLUMN_OWNER_ID));
                our.setRestaurant_name(results.getString(data.COLUMN_RESTAURANT_NAME));
                our.setLatitude(results.getDouble(data.COLUMN_LATITUDE));
                our.setHardness(results.getDouble(data.COLUMN_HARDNESS));
                our.setRestaurant_category(results.getString(data.COLUMN_RESTAURANT_CATEGORY));
                our.setSignature_food(results.getString(data.COLUMN_SIGNATURE_FOOD));
                ourAr.add(our);
            }
            if(ourAr == null){
                System.out.println("Can't find an artist");
                return;
            }
            int count = 0;
            for (OMMG_RESTAURANT a : ourAr) {
//                System.out.println(data.COLUMN_RESTAURANT_ID + " : " + a.getRestraurant_id()
//                        + "  \t| "+ data.COLUMN_OWNER_ID + " : " + a.getOwner_id()
//                        + " \t|" + data.COLUMN_RESTAURANT_NAME + " : " + a.getRestaurant_name()
//                        + " \t|" + data.COLUMN_LATITUDE + " : " + a.getLatitude()
//                        + " \t|" + data.COLUMN_HARDNESS + " : " + a.getHardness()
//                        + " \t|" + data.COLUMN_RESTAURANT_CATEGORY + " : " + a.getRestaurant_category()
//                        + " \t|" + data.COLUMN_SIGNATURE_FOOD + " : " + a.getSignature_food());
                JLabel text = new JLabel(data.COLUMN_RESTAURANT_ID + " : " + a.getRestraurant_id()
                        + "  \t| " + data.COLUMN_OWNER_ID + " : " + a.getOwner_id()
                        + " \t|" + data.COLUMN_RESTAURANT_NAME + " : " + a.getRestaurant_name()
                        + " \t|" + data.COLUMN_LATITUDE + " : " + a.getLatitude()
                        + " \t|" + data.COLUMN_HARDNESS + " : " + a.getHardness()
                        + " \t|" + data.COLUMN_RESTAURANT_CATEGORY + " : " + a.getRestaurant_category()
                        + " \t|" + data.COLUMN_SIGNATURE_FOOD + " : " + a.getSignature_food());
                text.setBounds(10, count += 20, 1000, 40);
                JF.add(text);
            }

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
        SELECT = new StringBuilder("SELECT * from ");

        JButton go_back = new JButton("돌아가기");
        go_back.setBounds(650,500,100,30);

        JF.add(go_back);
        JF.setVisible(true);
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                frame_test_Table ftt = new frame_test_Table();
                ftt.frame_test_Table_Mathod(con, type);
            }
        };
        go_back.addActionListener(action);
    }


    public static void select_RESTAURANT_MENU_table(Connection con,String type){
        SELECT.append(data.TABLE_RESTAURANT_MENU).append(";");
        JFrame JF = new JFrame();
        JF.setSize(800, 600);
        JF.setTitle("test_Table");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            ArrayList<OMMG_RESTAURANT_MENU> ouAr = new ArrayList<>();
            while (results.next()) {
                OMMG_RESTAURANT_MENU ou = new OMMG_RESTAURANT_MENU();
                ou.setRestaurant_id(results.getInt(data.COLUMN_RESTAURANT_ID));
                ou.setMenu_id(results.getInt(data.COLUMN_MENU_ID));
                ouAr.add(ou);
            }
            if(ouAr == null){
                System.out.println("Can't find an artist");
                return;
            }
            int count = 0;
            for (OMMG_RESTAURANT_MENU a : ouAr) {
//                System.out.println(data.COLUMN_RESTAURANT_ID + " : " + a.getRestaurant_id()
//                        + "  \t| "+ data.COLUMN_MENU_ID + " : " + a.getMenu_id());
                JLabel text = new JLabel(data.COLUMN_RESTAURANT_ID + " : " + a.getRestaurant_id()
                        + "  \t| "+ data.COLUMN_MENU_ID + " : " + a.getMenu_id());
                text.setBounds(10, count += 20, 800, 40);
                JF.add(text);
            }

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
        SELECT = new StringBuilder("SELECT * from ");

        JButton go_back = new JButton("돌아가기");
        go_back.setBounds(650,500,100,30);

        JF.add(go_back);
        JF.setVisible(true);
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                frame_test_Table ftt = new frame_test_Table();
                ftt.frame_test_Table_Mathod(con, type);
            }
        };
        go_back.addActionListener(action);
    }


    public static void select_MENU_table(Connection con,String type){
        SELECT.append(data.TABLE_MENU).append(";");
        JFrame JF = new JFrame();
        JF.setSize(800, 600);
        JF.setTitle("test_Table");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            ArrayList<OMMG_MENU> ouAr = new ArrayList<>();
            while (results.next()) {
                OMMG_MENU ou = new OMMG_MENU();
                ou.setMenu_id(results.getInt(data.COLUMN_MENU_ID));
                ou.setFood_name(results.getString(data.COLUMN_FOOD_NAME));
                ou.setFood_category(results.getString(data.COLUMN_FOOD_CATEGORY));
                ouAr.add(ou);
            }
            if(ouAr == null){
                System.out.println("Can't find an artist");
                return;
            }
            int count = 0;
            for (OMMG_MENU a : ouAr) {
//                System.out.println(data.COLUMN_MENU_ID + " : " + a.getMenu_id()
//                        + "  \t| "+ data.COLUMN_FOOD_NAME + " : " + a.getFood_name()
//                        + "  \t| "+ data.COLUMN_FOOD_CATEGORY + " : " + a.getFood_category());
                JLabel text = new JLabel(data.COLUMN_MENU_ID + " : " + a.getMenu_id()
                        + "  \t| "+ data.COLUMN_FOOD_NAME + " : " + a.getFood_name()
                        + "  \t| "+ data.COLUMN_FOOD_CATEGORY + " : " + a.getFood_category());
                text.setBounds(10, count += 20, 800, 40);
                JF.add(text);
            }

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
        SELECT = new StringBuilder("SELECT * from ");

        JButton go_back = new JButton("돌아가기");
        go_back.setBounds(650,500,100,30);

        JF.add(go_back);
        JF.setVisible(true);
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                frame_test_Table ftt = new frame_test_Table();
                ftt.frame_test_Table_Mathod(con, type);
            }
        };
        go_back.addActionListener(action);
    }
}
