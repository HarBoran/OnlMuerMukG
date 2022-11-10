package model;

import model.ArrayList_Collect.OMMG_OWNER_MENU;
import model.frame_Administrator_Collect.frame_Set_Food_Table;
import model.frame_Administrator_Data_Collect.frame_Restaurant_Setting;

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

public class administrator_data {
    public static Scanner scan = new Scanner(System.in);
    public static Datasource data = new Datasource();
    public static administrator admin = new administrator();
    public static frame_Set_Food_Table fsft = new frame_Set_Food_Table();
    //선택한 음식점 관리
//    public static void restaurant_Setting(String restaurant_Name,int restaurant_ID, Connection con) {
////        while (true) {
////            System.out.println(restaurant_Name + " 음식점 관리 모드입니다");
////            System.out.println("사용할 기능을 선택해주세요.");
////            System.out.println("1. 메뉴 보기");
////            System.out.println("2. 메뉴 추가");
////            System.out.println("3. 메뉴 삭제");
////            System.out.println("4. 폐점 신청");
////            System.out.println("5. 이전으로 돌아가기");
////            switch (num) {
////                case 0:
////                    select_this_restaurant_menu(restaurant_ID,con);
////                    break;
////                case 1:
////                    menu_Add(restaurant_ID, con);
////                    break;
////                case 2:
////                    menu_Delete(restaurant_ID, con);
////                    break;
////                case 3:
////                    restaurant_Delete(restaurant_Name, con);
////                    return;
////                case 4:
////                    return;
////        }
////        }
////        frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
////        frs.frame_Restaurant_Setting_Method(restaurant_Name,restaurant_ID,con);
//    }

    public static void select_this_restaurant_menu
            (int restaurant_ID, Connection con,JFrame JF){
        StringBuilder SELECT = new StringBuilder("SELECT ")
                .append(data.TABLE_MENU).append(".").append(data.COLUMN_MENU_ID)
                .append(",").append(data.COLUMN_FOOD_NAME)
                .append(" from ").append(data.TABLE_MENU)
                .append(" join ").append(data.TABLE_RESTAURANT_MENU)
                .append(" on ").append(data.TABLE_MENU).append(".").append(data.COLUMN_MENU_ID).append(" = ")
                .append(data.TABLE_RESTAURANT_MENU).append(".").append(data.COLUMN_MENU_ID)
                .append(" where ").append(data.COLUMN_RESTAURANT_ID).append(" = ").append(restaurant_ID)
                .append(" order by ").append(data.TABLE_MENU).append(".").append(data.COLUMN_MENU_ID);

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            ArrayList<OMMG_OWNER_MENU> ouAr = new ArrayList<>();
            while (results.next()) {
                OMMG_OWNER_MENU ou = new OMMG_OWNER_MENU();
                ou.setMenu_id(results.getInt(data.COLUMN_MENU_ID));
                ou.setFood_name(results.getString(data.COLUMN_FOOD_NAME));
                ouAr.add(ou);
            }
            if(ouAr == null){
                System.out.println("Can't find an artist");
                return;
            }
            int count = 0 ;
            for (OMMG_OWNER_MENU a : ouAr) {{
                JLabel txt = new JLabel("메뉴 번호 : " + a.getMenu_id()
                        + "  \t| " + "음식 이름 : " + a.getFood_name());
                txt.setBounds(10, count += 20,500, 40);
                JF.add(txt);
            }
//                System.out.println(data.COLUMN_MENU_ID + " : " + a.getMenu_id()
//                        + "  \t| " + data.COLUMN_FOOD_NAME + " : " + a.getFood_name());
            }

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }
    //관리할 음식점을 문자열로 받을경우 정수값과 함께 반환
    public static void restaurant_Setting(String restaurant_Name, Connection con, String type) {
        StringBuilder SELECT = new StringBuilder("SELECT ").append(data.COLUMN_RESTAURANT_ID)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_RESTAURANT_NAME).append(" = '").append(restaurant_Name).append("'");

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            //restaurant_Setting(restaurant_Name,results.getInt(data.COLUMN_RESTAURANT_ID),con);

            frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
            frs.frame_Restaurant_Setting_Method(restaurant_Name,results.getInt(data.COLUMN_RESTAURANT_ID),con,type);

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
            try {
                Thread.sleep(5000);

            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    //관리할 음식점을 정수값으로 받을경우 문자열과 함께 반환
    public static void restaurant_Setting(int num, Connection con, String type) {
        StringBuilder SELECT = new StringBuilder("SELECT ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_RESTAURANT_ID).append(" = ").append(num);

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            //restaurant_Setting(results.getString(1),num ,con);
            frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
            frs.frame_Restaurant_Setting_Method(results.getString(data.COLUMN_RESTAURANT_NAME),num,con,type);

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }

    //선택한 음식점의 메뉴 테이블 관리

    //선택한 음식점의 메뉴 추가
    public static void menu_Add(int restaurant_ID , String food_Name, Connection con) {
        StringBuilder food_Name_Select = new StringBuilder("Select ");
        ResultSet results;
        int num = 0;
//        test_Table.select_MENU_table(con);
//        System.out.print("추가할 메뉴의 번호 혹은이름을 입력하세요. : ");
//        String food_Name = scan.next();

        try {
            Integer.parseInt(food_Name);
            num = Integer.valueOf(food_Name);
        } catch (Exception e) {
            food_Name_Select.append(data.COLUMN_MENU_ID)
                    .append(" from ").append(data.TABLE_MENU)
                    .append(" where ").append(data.COLUMN_FOOD_NAME).append(" = '").append(food_Name).append("'");

            try {
                Statement st = con.createStatement();
                results = st.executeQuery(String.valueOf(food_Name_Select));

                num = results.getInt(data.COLUMN_MENU_ID);
            } catch (SQLException ex) {
                System.out.println(data.ERROR + ex.getMessage());
                e.printStackTrace();
            }

        }
        StringBuilder INSERT = new StringBuilder("INSERT INTO ").append(data.TABLE_RESTAURANT_MENU)
                .append(" ( ").append(data.COLUMN_RESTAURANT_ID).append(",").append(data.COLUMN_MENU_ID)
                .append(") Values (").append(restaurant_ID).append(" , ").append(num).append(")");
        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(INSERT));

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();

        }
    }

    //선택한 음식점의 메뉴 제거
    public static void menu_Delete(int restaurant_ID ,String food_Name, Connection con) {
        StringBuilder food_Name_Select = new StringBuilder("Select ");
        int num = 0;
        ResultSet results;
//        System.out.print("제거할 메뉴의 이름을 입력하세요. : ");
//        String food_Name = scan.next();


        try {
            Integer.parseInt(food_Name);
            num = Integer.valueOf(food_Name);

        } catch (Exception e) {
            food_Name_Select.append(data.COLUMN_MENU_ID)
                    .append(" from ").append(data.TABLE_MENU)
                    .append(" where ").append(data.COLUMN_FOOD_NAME).append(" = '").append(food_Name).append("'");

            try {
                Statement st = con.createStatement();
                results = st.executeQuery(String.valueOf(food_Name_Select));
                num = results.getInt(data.COLUMN_MENU_ID);
            } catch (SQLException ex) {
                System.out.println(data.ERROR + ex.getMessage());
                ex.printStackTrace();
            }
        }

        try {
            Statement st = con.createStatement();

            StringBuilder INSERT = new StringBuilder("Delete from ").append(data.TABLE_RESTAURANT_MENU).append(" where ")
                    .append(data.COLUMN_MENU_ID).append(" = ").append(num)
                    .append(" and ").append(data.COLUMN_RESTAURANT_ID).append(" = ").append(restaurant_ID);
            st.execute(String.valueOf(INSERT));
        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }


    //음식점 폐점
    public static void restaurant_Delete(String restaurant_name, Connection con) {
        StringBuilder DELETE_RESTAURANT_MENU = new StringBuilder("Delete from ").append(data.TABLE_RESTAURANT_MENU)
                .append(" Where ").append(data.COLUMN_RESTAURANT_ID).append(" = ")
                .append(" ( select ").append(data.COLUMN_RESTAURANT_ID)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" where ").append(data.COLUMN_RESTAURANT_NAME).append(" = '").append(restaurant_name).append("')");

        StringBuilder DELETE_RESTAURANT = new StringBuilder("Delete from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_RESTAURANT_NAME).append(" = '").append(restaurant_name).append("'");

        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(DELETE_RESTAURANT_MENU));
            st.execute(String.valueOf(DELETE_RESTAURANT));

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }

    //삭제할 유저 선택
    public static void user_Delete_Select(String user_name, Connection con) {
//        System.out.print("삭제할 유저의 이름 혹은 번호를 입력하시오. : ");
//        String user_name = scan.next();
        try {
            Integer.parseInt(user_name);
            StringBuilder user_name_output = new StringBuilder("Select ").append(data.COLUMN_LOGIN_ID)
                    .append(" from ").append(data.TABLE_USER)
                    .append(" Where ").append(data.COLUMN_USER_ID).append(" = '").append(user_name).append("'");
            try {
                Statement st = con.createStatement();
                ResultSet results = st.executeQuery(String.valueOf(user_name_output));
                user_name = results.getString(data.COLUMN_LOGIN_ID);

            } catch (SQLException ex) {
                System.out.println(data.ERROR + ex.getMessage());
                ex.printStackTrace();
            }
        } catch (Exception ex2) {
        }
        user_Delete(user_name,con);
    }

    //유저 삭제
    public static void user_Delete(String user_name, Connection con) {
        StringBuilder owner_scan = new StringBuilder("Select ").append(data.COLUMN_RESTAURANT_NAME)
                        .append(" from ").append(data.TABLE_RESTAURANT)
                        .append(" where ").append(data.COLUMN_OWNER_ID).append(" = '").append(user_name).append("'");

        StringBuilder delete = new StringBuilder("delete from ").append(data.TABLE_USER)
                        .append(" where ").append(data.COLUMN_LOGIN_ID).append(" = '").append(user_name).append("'");

        StringBuilder delete_rap = new StringBuilder("delete from ").append(data.TABLE_USER_RAP)
                .append(" where ").append(data.COLUMN_USER_ID)
                .append(" = (SELECT ").append(data.COLUMN_USER_ID)
                .append(" from ").append(data.TABLE_USER)
                .append(" where ").append(data.COLUMN_LOGIN_ID).append(" = '").append(user_name).append("')");

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(owner_scan))){

            if(results.next())
                restaurant_Delete(results.getString(data.COLUMN_RESTAURANT_NAME),con);

            st.execute(String.valueOf(delete_rap));
            st.execute(String.valueOf(delete));

        }catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }

    //사용기록 삭제
    public static void grade_Delete(int grade_select, Connection con) {
//        System.out.print("삭제할 기록의 번호를 입력하시오. : ");
//        int grade_select = scan.nextInt();

        StringBuilder grade_id_delete = new StringBuilder("Delete from ").append(data.TABLE_USER_RAP)
                .append(" where ").append(data.COLUMN_GRADE_ID).append(" = ").append(grade_select);

        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(grade_id_delete));
        }catch (SQLException e) {
        System.out.println(data.ERROR + e.getMessage());
        e.printStackTrace();
    }
    }

    //음식점 테이블 관리//

    //선택한 음식"테이블"에 메뉴 추가
    public static void food_Add(String food_Name, String food_Category, Connection con) {
//        System.out.print("추가할 음식을 적어주세요. : ");
//        String food_Name = scan.next();
//
//        System.out.print("음식의 카테고리를 적어주세요. : ");
//        String food_Category = scan.next();

        StringBuilder INSERT = new StringBuilder("Insert into ")
                .append(data.TABLE_MENU).append(" ( ").append(data.COLUMN_FOOD_NAME).append(" , ")
                .append(data.COLUMN_FOOD_CATEGORY).append(" ) ").append(" Values ")
                .append(" ( '").append(food_Name).append("','").append(food_Category).append("' )");

        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(INSERT));

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }

    }


    //선택한 음식"테이블"에서 수정
    public static void food_Update(String change_food, Connection con, String type) {
//        System.out.print("수정할 음식의 이름 혹은 번호를 입력하세요. :");
//        String change_food = scan.next();
        try {
            Integer.parseInt(change_food);
            StringBuilder SELECT = new StringBuilder("SELECT ").append(data.COLUMN_FOOD_NAME)
                    .append(" from ").append(data.TABLE_MENU)
                    .append(" where ").append(data.COLUMN_MENU_ID)
                    .append(" = ").append(change_food);
            try {
                Statement st = con.createStatement();
                ResultSet results = st.executeQuery(String.valueOf(SELECT));
                change_food = results.getString(data.COLUMN_FOOD_NAME);

            }catch (SQLException e) {
                System.out.println(data.ERROR + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
        }

        JFrame JF = new JFrame();

        JF.setSize(300, 400);
        JF.setTitle("Administrator_Restaurant_Setting");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

//        System.out.println(change_food + "의 어떤 항목을 수정하시겠습니까?");
//        System.out.println("1.음식 이름 2.음식 종류");
//        System.out.print("입력 : ");
//        switch (scan.nextInt()){
//            case 1:
//                change_column = data.COLUMN_FOOD_NAME;
//                break;
//            case 2:
//                change_column = data.COLUMN_FOOD_CATEGORY;
//                break;
//        }

        final String[] change_column = {null};
        JLabel text = new JLabel(change_food + "의 어떤 항목을 수정하시겠습니까?");
        JButton button = new JButton("이름 변경");
        JButton button2 = new JButton("카테고리 변경");
        JButton go_back = new JButton("돌아가기");

        text.setBounds(20, 80, 500, 30);
        button.setBounds(20,140,100,30);
        button2.setBounds(130,140,150,30);
        go_back.setBounds(150,300,100,30);


        JF.add(text);
        JF.add(button);
        JF.add(button2);
        JF.add(go_back);
        JF.setVisible(true);
        String finalChange_food = change_food;
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_column[0] = data.COLUMN_FOOD_NAME;
                food_Update2(finalChange_food, change_column[0],con, type);
                JF.dispose();
            }
        };
        button.addActionListener(action);
        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_column[0] = data.COLUMN_FOOD_CATEGORY;
                food_Update2(finalChange_food, change_column[0],con, type);
                JF.dispose();
            }
        };
        button2.addActionListener(action2);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                fsft.frame_Set_Food_Table_Mathod(con, type);
            }
        };
        go_back.addActionListener(action3);
    }

    public static void food_Update2(String change_food, String change_column,Connection con, String type) {
        JFrame JF = new JFrame();
        JF.setSize(300, 400);
        JF.setTitle("Administrator_Restaurant_Setting");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        JLabel text = new JLabel(change_food + "의 " + change_column + "을/를 적어주세요. : ");
        JButton button = new JButton("이름 변경");
        JButton go_back = new JButton("돌아가기");

        TextField change_Text = new TextField();
        button.setText("설정 변경");
//        System.out.print(change_food + "의 " + change_column[0] + "을/를 적어주세요. : ");
//        String food_update = scan.next();
        text.setBounds(20, 80, 500, 30);
        change_Text.setBounds(20, 110, 100, 30);
        button.setBounds(20, 140, 100, 30);
        go_back.setBounds(150,300,100,30);

        JF.add(text);
        JF.add(button);
        JF.add(change_Text);
        JF.add(go_back);
        JF.setVisible(true);

        String finalChange_food = change_food;
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String food_update = change_Text.getText();
                StringBuilder UPDATE = new StringBuilder("UPDATE ").append(data.TABLE_MENU)
                        .append(" SET ").append(change_column)
                        .append(" = '").append(food_update)
                        .append("' where '").append(finalChange_food).append("' = ").append(data.COLUMN_FOOD_NAME);
                try {
                    Statement st = con.createStatement();
                    st.execute(String.valueOf(UPDATE));

                } catch (SQLException ex) {
                    System.out.println(data.ERROR + ex.getMessage());
                    ex.printStackTrace();
                }
                JF.dispose();
                fsft.frame_Set_Food_Table_Mathod(con, type);
            }
        };
        button.addActionListener(action);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                fsft.frame_Set_Food_Table_Mathod(con, type);
            }
        };
        go_back.addActionListener(action2);
    }

    //선택한 음식"테이블"에서 메뉴 제거
    public static void food_Delete(String foodName, Connection con) {
//        System.out.print("음식 혹은 번호를 적어주세요. : ");
//        String foodName = scan.next();
        StringBuilder DELETE = new StringBuilder("Delete from ").append(data.TABLE_MENU).append(" Where ");
        StringBuilder DELETE_restaurant_menu = new StringBuilder("Delete from ").append(data.TABLE_RESTAURANT_MENU).append(" Where ");
        try {
            Integer.parseInt(foodName);
            DELETE.append(data.COLUMN_MENU_ID).append(" = ").append(foodName);
            DELETE_restaurant_menu.append(data.COLUMN_MENU_ID).append(" = ").append(foodName);


        } catch (Exception e) {
            DELETE.append(data.COLUMN_FOOD_NAME).append(" = '").append(foodName).append("'");
            DELETE_restaurant_menu.append(data.COLUMN_MENU_ID)
                    .append(" = (Select ").append(data.COLUMN_MENU_ID)
                    .append(" from ").append(data.TABLE_RESTAURANT_MENU).append(" where ")
                    .append(data.COLUMN_FOOD_NAME).append(" = '").append(foodName).append("')");
        }

        try {
            Statement st = con.createStatement();
            st.execute(String.valueOf(DELETE));
            st.execute(String.valueOf(DELETE_restaurant_menu));

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }
}