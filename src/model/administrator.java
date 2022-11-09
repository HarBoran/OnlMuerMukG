package model;

import model.frame_Administrator_Collect.frame_Administrator_Main;

import java.sql.Connection;
import java.util.Scanner;

//관리자 메인
public class administrator {
    static administrator_data adt = new administrator_data();
    static Scanner scan = new Scanner(System.in);
    static test_Table test = new test_Table();
    public static void administrator_Main(Connection con, String type) {
//        while (true){
//            System.out.println("관리자 모드입니다.");
//            System.out.println("사용할 기능을 선택해주세요.");
//            System.out.println("1.음식점 관리");
//            System.out.println("2.유저 및 평점 관리");
//            System.out.println("3.음식테이블 관리");
//            System.out.println("4.데이터베이스 확인");
//            System.out.println("5.로그아웃");
//            System.out.print("번호 입력 : ");
//            int num = scan.nextInt();
//            switch (num) {
//                case 1:
//                    set_Restaurant_Select(con);
//                    break;
//                case 2:
//                    set_user_Select(con);
//                    break;
//                case 3:
//                    set_food_table(con);
//                    break;
//                case 4:
//                    test.SELECT_TABLE(con);
//                    break;
//                case 5:
//                    return;
//            }
//        }
        frame_Administrator_Main fam = new frame_Administrator_Main();
        fam.frame_Administrator_Main_Mathod(con, type);
    }

    //관리할 음식점 선택
//    public static void set_Restaurant_Select(Connection con) {
//            String st;
//            System.out.println("음식점 관리 모드입니다.");
//            System.out.print("관리할 음식점을 선택해주세요. : ");
//            st = scan.next();
//            try {
//                Integer.parseInt(st);
//                adt.restaurant_Setting((Integer.valueOf(st)),con);
//
//            } catch (Exception e) {
//                adt.restaurant_Setting(st,con);
//
//            }
//    }

    //유저 관리 선택지
//    public static void set_user_Select(Connection con) {
//        while (true) {
//            System.out.println("유저 관리 모드입니다.");
//            System.out.println("1.유저 삭제");
//            System.out.println("2.기록 삭제");
//            System.out.println("3.이전으로 돌아가기");
//            System.out.print("번호 입력 :  ");
//
//            int num = scan.nextInt();
//
//            switch (num) {
//                case 1:
////                    adt.user_Delete_Select(con);
//                    frame_User_Delete_Select fuds = new frame_User_Delete_Select();
//                    fuds.frame_User_Delete_Select_Method(con);
//                    break;
//                case 2:
////                    adt.grade_Delete(con);
//                    frame_Grade_Delete fgd = new frame_Grade_Delete();
//                    fgd.frame_Grade_Delete_Method(con);
//                    break;
//                case 3:
//                    return;
//
//            }
//        }
//
//
//    }

//    public static void set_food_table(Connection con) {
//        while (true) {
//            System.out.println("음식 추가/제거 입니다.");
//            System.out.println("1.음식 추가");
//            System.out.println("2.음식 수정");
//            System.out.println("3.음식 제거");
//            System.out.println("4.돌아가기");
//            System.out.print("번호 입력 : ");
//            int num = scan.nextInt();
//
//            switch (num) {
//                case 1:
////                    adt.food_Add(con);
//                    frame_Food_Add ffa = new frame_Food_Add();
//                    ffa.frame_Food_Add_Method(con);
//                    break;
//                case 2:
////                    adt.food_Update("임시",con);
//                    frame_Food_Update ffu = new frame_Food_Update();
//                    ffu.frame_Food_Update_Method(con);
//                    break;
//                case 3:
////                    adt.food_Delete(con);
//                    frame_Food_Delete ffd = new frame_Food_Delete();
//                    ffd.frame_Food_Delete_Method(con);
//                    break;
//                case 4:
//                    return;
//            }
//        }
//    }
}
