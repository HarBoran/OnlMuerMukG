package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class owner {

    static administrator_data adt = new administrator_data();
    static Datasource data = new Datasource();
    static Scanner scan = new Scanner(System.in);

    public static void owner_main(String owner_name,Connection con){
        StringBuilder restaurant_name_str = new StringBuilder("Select ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" , ").append(data.COLUMN_RESTAURANT_ID)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_OWNER_ID).append(" = ").append(owner_name);

        try {
            Statement st = con.createStatement();
            String restaurant_name = st.executeQuery(String.valueOf(restaurant_name_str)).getString(data.COLUMN_RESTAURANT_NAME);
            int restaurant_id = st.executeQuery(String.valueOf(restaurant_name_str)).getInt(data.COLUMN_RESTAURANT_ID);
            while (true) {
                System.out.println(restaurant_name + "음식점 주인 모드입니다.");
                System.out.println("1.음식 추가");
                System.out.println("2.음식 제거");
                System.out.print("사용할 기능을 선택하시오. : ");
                int select = scan.nextInt();
                switch (select){
                    case 1:
                        adt.menu_Add(restaurant_id,con);
                        break;
                    case 2:
                        adt.menu_Delete(restaurant_id,con);
                }
            }
        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();

        }


    }

}
