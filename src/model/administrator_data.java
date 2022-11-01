package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class administrator_data {
    public static Scanner scan = new Scanner(System.in);
    public static Datasource data = new Datasource();

    //선택한 음식점 관리
    public static void restaurant_Setting(String restaurant_Name,int restaurant_ID, Connection con) {
        while (true) {
            System.out.flush();
            System.out.println(restaurant_Name + " 음식점 관리 모드입니다");
            System.out.println("사용할 기능을 선택해주세요.");
            System.out.println("1. 메뉴 추가");
            System.out.println("2. 메뉴 삭제");
            System.out.println("3. 폐점 신청");
            System.out.println("4. 이전으로 돌아가기");
            int num = scan.nextInt();

            switch (num) {
                case 1:
                    menu_Add(restaurant_ID, con);
                    break;
                case 2:
                    menu_Delete(restaurant_ID, con);
                    break;
                case 3:
                    restaurant_Delete(restaurant_Name, con);
                    break;
                case 4:
                    return;
            }
        }
    }

    //관리할 음식점을 문자열로 받을경우 정수값과 함께 반환
    public static void restaurant_Setting(String restaurant_Name, Connection con) {
        StringBuilder SELECT = new StringBuilder("SELECT ").append(data.COLUMN_RESTAURANT_ID)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_RESTAURANT_NAME).append(" = '").append(restaurant_Name).append("'");

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            restaurant_Setting(restaurant_Name,results.getInt(1),con);

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
    public static void restaurant_Setting(int num, Connection con) {
        StringBuilder SELECT = new StringBuilder("SELECT ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_RESTAURANT_ID).append(" = ").append(num);

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(SELECT))) {
            restaurant_Setting(results.getString(1),num ,con);

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

    //선택한 음식점의 메뉴 테이블 관리

    //선택한 음식점의 메뉴 추가
    public static void menu_Add(int restaurant_ID , Connection con) {
        StringBuilder food_Name_Select = new StringBuilder("Select ");
        ResultSet results;
        int num = 0;
        System.out.print("추가할 메뉴의 번호 혹은이름을 입력하세요. : ");
        String food_Name = scan.next();

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
    public static void menu_Delete(int restaurant_ID , Connection con) {
        StringBuilder food_Name_Select = new StringBuilder("Select ");
        int num = 0;
        ResultSet results;

        System.out.print("제거할 메뉴의 이름을 입력하세요. : ");
        String food_Name = scan.next();


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
    public static void restaurant_Delete(String name, Connection con) {
        System.out.flush();
        System.out.println("정말 이 음식점을 삭제하시겠습니까? (yes/no) : ");
        String select = scan.next();
        if (select.equals("yes")) {
            StringBuilder DELETE_RESTAURANT_MENU = new StringBuilder("Delete from ").append(data.TABLE_RESTAURANT_MENU)
                    .append(" Where ").append(data.COLUMN_RESTAURANT_ID).append(" = ")
                    .append(" ( select ").append(data.COLUMN_RESTAURANT_ID)
                    .append(" from ").append(data.TABLE_RESTAURANT)
                    .append(" where ").append(data.COLUMN_RESTAURANT_NAME).append(" = '").append(name).append("')");

            StringBuilder DELETE_RESTAURANT = new StringBuilder("Delete from ").append(data.TABLE_RESTAURANT)
                    .append(" Where ").append(data.COLUMN_MENU_ID).append(" = '").append(name).append("'");

            try {
                Statement st = con.createStatement();
                st.executeQuery(String.valueOf(DELETE_RESTAURANT_MENU));
                st.executeQuery(String.valueOf(DELETE_RESTAURANT));

            } catch (SQLException e) {
                System.out.println(data.ERROR + e.getMessage());
                e.printStackTrace();
            }

        }

    }

    //삭제할 유저 선택
    public static void user_Delete_Select(Connection con) {
        System.out.print("삭제할 유저의 이름 혹은 번호를 입력하시오. : ");
        String user_name = scan.next();
        String str;
        try {
            Integer.parseInt(user_name);
            System.out.println(user_name + "번 유저를 정말 삭제하시겠습니까? yes/no :");
            str = scan.next();

            if(str.equals("yes")) {
                StringBuilder user_name_output = new StringBuilder("Select ").append(data.COLUMN_LOGIN_ID)
                        .append(" from ").append(data.TABLE_USER)
                        .append(" Where").append(data.COLUMN_USER_ID).append(" = ").append(user_name);
                try {
                    Statement st = con.createStatement();
                    ResultSet results = st.executeQuery(String.valueOf(user_name_output));

                    user_Delete(results.getString(1), con);
                } catch (SQLException e) {
                    System.out.println(data.ERROR + e.getMessage());
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(user_name + " 유저를 정말 삭제하시겠습니까? yes/no :");
            str = scan.next();
            if(str.equals("yes")) {
                user_Delete(user_name, con);
            }
        }
    }

    //유저 삭제
    public static void user_Delete(String user_name,Connection con) {
        StringBuilder owner_scan = new StringBuilder("Select ").append(data.COLUMN_RESTAURANT_NAME)
                        .append(" from ").append(data.TABLE_RESTAURANT)
                        .append(" where ").append(data.COLUMN_OWNER_ID).append(" = ").append(user_name);

        StringBuilder delete = new StringBuilder("delet from").append(data.TABLE_USER)
                        .append(" where ").append(data.COLUMN_LOGIN_ID).append(" = ").append(user_name);

        try {
            Statement st = con.createStatement();
            ResultSet results = st.executeQuery(String.valueOf(owner_scan));
            if(results.getString(1) != null)
                restaurant_Delete(results.getString(1),con);

            st.executeQuery(String.valueOf(delete));

        }catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }

    }

    //사용기록 삭제
    public static void grade_Delete(Connection con) {
        System.out.print("삭제할 기록의 번호를 입력하시오. : ");
        int grade_select = scan.nextInt();

        StringBuilder grade_id_delete = new StringBuilder("Delete from ").append(data.TABLE_USER_RAP)
                .append(" where ").append(data.COLUMN_USER_RAP).append(" = ").append(grade_select);

    }

    //음식점 테이블 관리//

    //선택한 음식"테이블"에 메뉴 추가
    public static void food_Add(Connection con) {
        System.out.flush();
        System.out.print("추가할 음식을 적어주세요. : ");
        String food_Name = scan.next();

        System.out.print("음식의 카테고리를 적어주세요. : ");
        String food_Category = scan.next();

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

    //선택한 음식"테이블"에서 메뉴 제거
    public static void food_Delete(Connection con) {
        System.out.flush();
        System.out.print("음식 혹은 번호를 적어주세요. : ");
        String foodName = scan.next();
        StringBuilder DELETE = new StringBuilder("Delete from ").append(data.TABLE_MENU).append(" Where ");
        try {
            Integer.parseInt(foodName);
            DELETE.append(data.COLUMN_MENU_ID).append(" = '").append(foodName).append("'");


        } catch (Exception e) {
            DELETE.append(data.COLUMN_FOOD_NAME).append(" = '").append(foodName).append("'");
        }

        try {
            Statement st = con.createStatement();
            if (st.executeQuery(String.valueOf(DELETE)) == null) {
                System.out.println("해당음식은 존재하지 않습니다.");
                Thread.sleep(3000);
            }
            st.executeQuery(String.valueOf(DELETE));

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}