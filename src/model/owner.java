package model;

import model.ArrayList_Collect.OMMG_MENU;
import model.frame_Administrator_Collect.frame_test_Table;
import model.frame_Administrator_Data_Collect.frame_Menu_Add;
import model.frame_Administrator_Data_Collect.frame_Menu_Delete;
import model.frame_Owner_Collect.frame_Owner_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class owner {

    static administrator_data adt = new administrator_data();
    static Datasource data = new Datasource();
    static Scanner scan = new Scanner(System.in);
    static test_Table test = new test_Table();
    static frame_Owner_Main fom = new  frame_Owner_Main();
//    public static void owner_main(String owner_name,Connection con){
//        StringBuilder restaurant_name_str = new StringBuilder("Select ").append(data.COLUMN_RESTAURANT_NAME)
//                .append(" , ").append(data.COLUMN_RESTAURANT_ID)
//                .append(" from ").append(data.TABLE_RESTAURANT)
//                .append(" Where ").append(data.COLUMN_OWNER_ID).append(" = '").append(owner_name).append("'");
//
//        try {
//            Statement st = con.createStatement();
//            String restaurant_name = st.executeQuery(String.valueOf(restaurant_name_str)).getString(data.COLUMN_RESTAURANT_NAME);
//            int restaurant_id = st.executeQuery(String.valueOf(restaurant_name_str)).getInt(data.COLUMN_RESTAURANT_ID);
//            while (true) {
//                System.out.println(restaurant_name + "음식점 주인 모드입니다.");
//                System.out.println("1.메뉴 보기");
//                System.out.println("2.음식 추가");
//                System.out.println("3.음식 제거");
//                System.out.println("4.음식점 이름 바꾸기");
//                System.out.println("5.로그아웃");
//                System.out.print("사용할 기능을 선택하시오. : ");
//                int select = scan.nextInt();
//                switch (select){
//                    case 1:
//                        owner_MENU_table(restaurant_id,con);
//                        break;
//                    case 2:
//                        frame_Menu_Add fma = new frame_Menu_Add();
//                        fma.frame_Menu_Add_Method(restaurant_name,restaurant_id, con);
//                        break;
//                    case 3:
//                        frame_Menu_Delete fmd= new frame_Menu_Delete();
//                        fmd.frame_Menu_Delete_Method(restaurant_name, restaurant_id, con);
//                        break;
//                    case 4:
//                        restaurant_name = restaurant_name_change(restaurant_id,con);
//                        break;
//                    case 5:
//                        return;
//                }
//            }
//        }catch (SQLException e){
//            System.out.println(data.ERROR + e.getMessage());
//            e.printStackTrace();
//
//        }
//    }
    public static void owner_MENU_table(String owner_name,int restaurant_id,Connection con,String type){
        StringBuilder RESTRAUNT_MENU = new StringBuilder("Select ")
                .append(data.TABLE_MENU).append(".").append(data.COLUMN_MENU_ID)
                .append(" as ").append(data.COLUMN_MENU_ID).append(",")
                .append(data.COLUMN_FOOD_NAME).append(",")
                .append(data.COLUMN_FOOD_CATEGORY)
                .append(" from ").append(data.TABLE_MENU)
                .append(" join ").append(data.TABLE_RESTAURANT_MENU)
                .append(" on ").append(data.TABLE_MENU).append(".").append(data.COLUMN_MENU_ID)
                .append(" = ").append(data.TABLE_RESTAURANT_MENU).append(".").append(data.COLUMN_MENU_ID)
                .append(" where ").append(data.COLUMN_RESTAURANT_ID)
                .append(" = ").append(restaurant_id).append(" order by ")
                .append(data.TABLE_MENU).append(".").append(data.COLUMN_MENU_ID);


        frame_Owner_Main fom = new frame_Owner_Main();
        JFrame JF = new JFrame();
        JF.setSize(800, 600);
        JF.setTitle("test_Table");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        try (Statement st = con.createStatement();
        ResultSet results = st.executeQuery(String.valueOf(RESTRAUNT_MENU))){
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
        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();

        }

        JButton go_back = new JButton("돌아가기");
        go_back.setBounds(650,500,100,30);

        JF.add(go_back);
        JF.setVisible(true);
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                fom.frame_Owner_Main_Mathod(owner_name,con,type);
            }
        };
        go_back.addActionListener(action);
    }
     public static void restaurant_name_change(String chname, String owner_name,int restaurant_id, Connection con,String type){
//        change_RESTAURANT_NAME_CHECK(owner_name,restaurant_id,con,type);
        StringBuilder Change_Name = new StringBuilder("UPDATE ").append(data.TABLE_RESTAURANT)
                .append(" SET ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" = '").append(chname)
                .append("' where ").append(data.COLUMN_RESTAURANT_ID)
                .append(" = ").append(restaurant_id);
        try {Statement st = con.createStatement();
            st.execute(String.valueOf(Change_Name));
            fom.frame_Owner_Main_Mathod(owner_name,con,type);

        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
     }
    public static void change_RESTAURANT_NAME_CHECK(String owner_name,int restaurant_id, Connection con,String type){

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
            JButton button = new JButton("이름 바꾸기");
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
            ActionListener action = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JF.dispose();
                    StringBuilder RESTRUNT_NAME_CHECK = new StringBuilder("SELECT ")
                            .append(data.COLUMN_RESTAURANT_NAME)
                            .append(" from ").append(data.TABLE_RESTAURANT)
                            .append(" where ").append(data.COLUMN_RESTAURANT_NAME)
                            .append(" = '").append(restrunt_name).append("'");
                    try (Statement st = con.createStatement();
                         ResultSet results = st.executeQuery(String.valueOf(RESTRUNT_NAME_CHECK))) {
                        results.getString(data.COLUMN_RESTAURANT_NAME);
                        owner.change_RESTAURANT_NAME_CHECK(owner_name, restaurant_id,con,type);
                    } catch (SQLException ex) {
                        restaurant_name_change(restrunt_name.getText(),owner_name,restaurant_id,con,type);
                    }
                }
            };

            button.addActionListener(action);
            ActionListener action2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JF.dispose();
                    fom.frame_Owner_Main_Mathod(owner_name,con,type);
                }
            };
            go_back.addActionListener(action2);

    }
}
