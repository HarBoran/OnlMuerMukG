package model;

import com.sun.tools.javac.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class administrator {
    static administrator_data adt = new administrator_data();
    Datasource data = new Datasource();
    static Scanner scan = new Scanner(System.in);
    public static void administrator_Main(Connection con){
        while (true){
            System.out.flush();
            System.out.println("관리자 모드입니다.");
            System.out.println("사용할 기능을 선택해주세요.");
            System.out.println("1.음식점 관리");
            System.out.println("2.유저 및 평점 관리");
            System.out.println("3.로그아웃");
            System.out.print("번호 입력 : ");
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    set_Restaurant_Select(con);
                    break;
                case 2:
                    set_user_Select(con);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void set_Restaurant_Select(Connection con) {
            System.out.flush();
            String st;
            System.out.println("음식점 관리 모드입니다.");
            System.out.print("관리할 음식점을 선택해주세요. : ");
            st = scan.next();
            try {
                Integer.parseInt(st);
                adt.restaurant_Setting((Integer.valueOf(st)),con);

            } catch (Exception e) {
                adt.restaurant_Setting(st,con);

            }
    }

    public static void set_user_Select(Connection con) {
        while (true) {
            System.out.flush();
            int num = 0;
            System.out.println("유저 관리 모드입니다.");
            System.out.println("사용할 기능을 선택해주세요.");
            System.out.println("1.유저 삭제");
            System.out.println("2.평점 관리");
            System.out.println("3.이전으로 돌아가기");

            switch (num) {
                case 1:
                    adt.user_Delete(con);
                case 2:
                    adt.grade_Delete(con);
                case 3:
                    return;

            }
        }
    }



}
