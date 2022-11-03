package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class login {
    static Scanner scan = new Scanner(System.in);
    static Datasource data = new Datasource();

    public static void LOGIN(Connection con) {
        System.out.print("사용할 ID를 입력하세요. : ");
        String user_id = scan.next();
        if (user_id.equals("Admin")) {
            administrator.administrator_Main(con);

        } else {
            StringBuilder USER_CHECK = new StringBuilder("SELECT ").append(data.COLUMN_LOGIN_ID)
                    .append(" from ").append(data.TABLE_USER)
                    .append(" where ").append(data.COLUMN_LOGIN_ID)
                    .append(" = '").append(user_id).append("'");
            try {
                Statement st = con.createStatement();
                if (st.executeQuery(String.valueOf(USER_CHECK)).next()) {
                    StringBuilder OWNER_CHECK = new StringBuilder("SELECT ").append(data.COLUMN_OWNER_ID)
                            .append(" from ").append(data.TABLE_RESTAURANT)
                            .append(" where ").append(data.COLUMN_OWNER_ID)
                            .append(" = '").append(user_id).append("'");

                    try {
                        ResultSet results = st.executeQuery(String.valueOf(OWNER_CHECK));
                        if (results.next()) {
                            owner.owner_main(user_id,con);
                        }else{
                            //로비화면 불러오기
                        }

                    }catch(SQLException ex){
                            System.out.println(data.ERROR + ex.getMessage());
                            ex.printStackTrace();
                        }

                    }
            } catch (SQLException e) {
                System.out.println(data.ERROR + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
