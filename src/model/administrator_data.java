package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class administrator_data {
    public static Scanner scan = new Scanner(System.in);
    public static Datasource data = new Datasource();

    public static void restaurant_Setting(String name,Connection con) {
        while (true) {
            System.out.flush();
            System.out.println(name + " 음식점 관리 모드입니다");
            System.out.println("사용할 기능을 선택해주세요.");
            System.out.println("1. 메뉴 추가");
            System.out.println("2. 메뉴 삭제");
            System.out.println("3. 폐점 신청");
            System.out.println("4. 이전으로 돌아가기");
            int num = scan.nextInt();

            switch (num) {
                case 1:
                    menu_Add(name, con);
                    break;
                case 2:
                    menu_Delete(name, con);
                    break;
                case 3:
                    restaurant_Delete(name, con);
                    break;
                case 4:
                    return;
            }
        }
    }
    public static void restaurant_Setting(int num,Connection con) {
        StringBuilder SELECT = new StringBuilder("SELECT ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" from ").append(data.TABLE_RESTAURANT).append(" Where ")
                .append(data.COLUMN_RESTAURANT_ID).append(" = ").append(num);

        try (Statement st = con.createStatement();
        ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            restaurant_Setting(results.getString(1),con);

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void menu_Add(String name , Connection con){
        System.out.flush();
        System.out.print(name + " 음식점에 추가할 음식을 적어주세요. : ");
        String foodName = scan.next();

        System.out.print(name + " 음식의 카테고리를 적어주세요. : ");
        String foodCategory= scan.next();

        StringBuilder INSERT = new StringBuilder("Insert into ")
                .append(name).append(" ( ").append(data.COLUMN_FOOD_NAME).append(" , ")
                .append(data.COLUMN_FOOD_CATEGORY).append(" ) ").append(" Values ")
                .append(" ( ").append(foodName).append(",").append(foodCategory).append(" )");

        try  {
        Statement st = con.createStatement();
        st.executeQuery(String.valueOf(INSERT));

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void menu_Delete(String name , Connection con){
        System.out.flush();
        System.out.print(name + " 음식점에서 삭제할 음식을 적어주세요. : ");
        String foodName = scan.next();
            StringBuilder DELETE = new StringBuilder("Delete from ").append(data.TABLE_MENU)
                    .append(" Where ").append(data.COLUMN_MENU_ID).append(" = ").append(foodName);

        try  {
            Statement st = con.createStatement();
            st.executeQuery(String.valueOf(DELETE));

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void  restaurant_Delete(String name , Connection con){
        System.out.println("정말 이 음식점을 삭제하시겠습니까? (yes/no) : ");
        String select = scan.next();
        if (select.equals("yes")){
            StringBuilder DELETE = new StringBuilder("Delete from ").append(data.TABLE_RESTAURANT_MENU)
                    .append(" Where ").append(data.COLUMN_MENU_ID).append(" = ").append(foodName);
            StringBuilder DELETE = new StringBuilder("Delete from ").append(name)
                    .append(" Where ").append(data.COLUMN_MENU_ID).append(" = ").append(foodName);
            StringBuilder DELETE = new StringBuilder("Delete from ").append(name)
                    .append(" Where ").append(data.COLUMN_MENU_ID).append(" = ").append(foodName);

            try  {
                Statement st = con.createStatement();
                st.executeQuery(String.valueOf(DELETE));

            } catch (SQLException e) {
                System.out.println(data.ERROR + e.getMessage());
                e.printStackTrace();
            }

        }

    }

    public static void user_Delete(Connection con){
        System.out.print("삭제할 유저의 이름 혹은 번호를 입력하시오. : ");
        String user = scan.next();
        try{
            Integer.parseInt(user);


            StringBuilder SELECT = new StringBuilder("SELECT * from ")
                    .append(data.TABLE_USER).append(" where ")
                    .append(data.COLUMN_USER_ID).append(" = ").append(user);

            try(Statement st = con.createStatement();
                ResultSet results = st.executeQuery(String.valueOf(SELECT.append(user)))){

            } catch (SQLException e) {

            }

        }
         catch (Exception e) {

        }


    }
    public static void grade_Delete(Connection con){
        System.out.print("삭제할 평가의번호 혹은 유저의 이름을 입력하시오. : ");

    }
}
