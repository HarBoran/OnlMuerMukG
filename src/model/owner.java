package model;

import model.ArrayList_Collect.OMMG_MENU;

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

    public static void owner_main(String owner_name,Connection con){
        StringBuilder restaurant_name_str = new StringBuilder("Select ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" , ").append(data.COLUMN_RESTAURANT_ID)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_OWNER_ID).append(" = '").append(owner_name).append("'");

        try {
            Statement st = con.createStatement();
            String restaurant_name = st.executeQuery(String.valueOf(restaurant_name_str)).getString(data.COLUMN_RESTAURANT_NAME);
            int restaurant_id = st.executeQuery(String.valueOf(restaurant_name_str)).getInt(data.COLUMN_RESTAURANT_ID);
            while (true) {
                System.out.println(restaurant_name + "음식점 주인 모드입니다.");
                System.out.println("1.메뉴 보기");
                System.out.println("2.음식 추가");
                System.out.println("3.음식 제거");
                System.out.println("4.음식점 이름 바꾸기");
                System.out.println("5.로그아웃");
                System.out.print("사용할 기능을 선택하시오. : ");
                int select = scan.nextInt();
                switch (select){
                    case 1:
                        owner_MENU_table(restaurant_id,con);
                        break;
                    case 2:
                        adt.menu_Add(restaurant_id,con);
                        break;
                    case 3:
                        adt.menu_Delete(restaurant_id,con);
                        break;
                    case 4:
                        restaurant_name = restaurant_name_change(restaurant_id,con);
                        break;
                    case 5:
                        return;
                }
            }
        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();

        }
    }
    public static void owner_MENU_table(int restaurant_id,Connection con){
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
            for (OMMG_MENU a : ouAr)
                System.out.println(data.COLUMN_MENU_ID + " : " + a.getMenu_id()
                        + "  \t| "+ data.COLUMN_FOOD_NAME + " : " + a.getFood_name()
                        + "  \t| "+ data.COLUMN_FOOD_CATEGORY + " : " + a.getFood_category());

        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();

        }
    }
     public static String restaurant_name_change(int restaurant_id, Connection con){
        String chname =sign_Up.RESTAURANT_NAME_CHECK(con);
        StringBuilder Change_Name = new StringBuilder("UPDATE ").append(data.TABLE_RESTAURANT)
                .append(" SET ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" = '").append(chname)
                .append("' where ").append(data.COLUMN_RESTAURANT_ID)
                .append(" = ").append(restaurant_id);
        try {Statement st = con.createStatement();
            st.execute(String.valueOf(Change_Name));
            return chname;
        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
            return null;
        }
     }
}
