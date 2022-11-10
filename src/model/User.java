package model;

import model.ArrayList_Collect.OMMG_RAP_CHECK;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    static Datasource data = new Datasource();
    static Scanner scan = new Scanner(System.in);

//    public static void USER_MAIN(String user_Name, Connection con) {
//        while (true) {
//            System.out.println(user_Name + "유저 메인 임시 입니다.");
//            System.out.println("1. 음식점 뽑기");
//            System.out.println("2. 유저 사용기록 보기 및 리뷰입력");
//            System.out.println("3. 로그아웃");
//            System.out.print("입력 : ");
//            switch (scan.nextInt()) {
//                case 1:
//                    User_Select_restaurant(1,user_Name,con);
//                    break;
//                case 2:
//                    User_Rap_Check(user_Name, con);
//                    break;
//                case 3:
//                    return;
//            }
//        }
//    }

    //음식점 사용
//    public static void User_Select_restaurant(int restaurnt_Id, String user_Name, Connection con){
//        System.out.print("정말 이 음식점에서 식사하시겠습니까? (yes/no) : ");
//        if(scan.next().equals("yes")){
//
//            System.out.println("이용해주셔서 감사합니다.");
//
//            StringBuilder User_Id = new StringBuilder("SELECT ").append(data.COLUMN_USER_ID)
//                    .append(" from ").append(data.TABLE_USER)
//                    .append(" Where ").append(data.COLUMN_LOGIN_ID)
//                    .append(" = '").append(user_Name).append("'");
//
//            try (Statement st = con.createStatement();
//            ResultSet results = st.executeQuery(String.valueOf(User_Id))){
//                LocalTime use_Time = LocalTime.now();
//                DateTimeFormatter eat_Time = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//                StringBuilder RAP = new StringBuilder("INSERT INTO ").append(data.TABLE_USER_RAP)
//                        .append(" ( ").append(data.COLUMN_USER_ID)
//                        .append(" , ").append(data.COLUMN_RESTAURANT_ID)
//                        .append(" , ").append(data.COLUMN_EAT_DATE)
//                        .append(" , ").append(data.COLUMN_EAT_TIME)
//                        .append(" ) Values (").append(results.getInt(data.COLUMN_USER_ID))
//                        .append(" , ").append(restaurnt_Id)
//                        .append(" , '").append(LocalDate.now())
//                        .append("' , '").append(use_Time.format(eat_Time)).append("')");
//
//                st.execute(String.valueOf(RAP));
//
//            }catch (SQLException e){
//                System.out.println(data.ERROR+e.getMessage());
//                e.printStackTrace();
//            }
//        }
//    }


    //유저 사용기록 확인 및 리뷰입력
//    public static void User_Rap_Check(String user_Name, Connection con) {
//        while (true) {
//            User_Rap_Check_Table_Select(User_Rap_Check_Table(user_Name, con));
//            System.out.println("1.리뷰 쓰기");
//            System.out.println("2.이전으로 돌아가기");
//            System.out.print("입력 : ");
//            switch (scan.nextInt()) {
//                case 1:
//                    User_Grade(user_Name, con);
//                    break;
//                case 2:
//                    return;
//            }
//
//        }
//    }

    public static void User_Grade(int grade_id, int grade ,String user_Name, Connection con) {
        ArrayList<OMMG_RAP_CHECK> URCT = User_Rap_Check_Table(user_Name, con);
//        User_Rap_Check_Table_Select(URCT);
//        while (true) {
//            System.out.print("몇번 기록의 리뷰를 입력하시겠습니까? : ");
//            int num = scan.nextInt();
            for(OMMG_RAP_CHECK i : URCT){
                if(i.getGRADE_ID() == grade_id){
//                    System.out.print("별점을 입력해주세요. 1 ~ 5 : ");
//                    int grade = scan.nextInt();
                    StringBuilder GRADE_UPDATE = new StringBuilder("UPDATE ")
                            .append(data.TABLE_USER_RAP)
                            .append(" SET ").append(data.COLUMN_GRADE)
                            .append(" = ").append(grade)
                            .append(" where ").append(data.COLUMN_GRADE_ID)
                            .append(" = ").append(grade_id);
                    try {
                        con.createStatement().execute(String.valueOf(GRADE_UPDATE));
                    }catch (SQLException e){
                        System.out.println(data.ERROR+e.getMessage());
                        e.printStackTrace();
                    }
                    return;
                }
            }
//            System.out.println("해당 번호의 리뷰는 존재하지 않습니다.");
//            System.out.println("다시 입력해주세요.");
//        }
    }

    public static ArrayList<OMMG_RAP_CHECK> User_Rap_Check_Table(String user_Name, Connection con) {
        StringBuilder USER_RAP_SELECT = new StringBuilder("SELECT ")
                .append(data.COLUMN_GRADE_ID)
                .append(",").append(data.COLUMN_RESTAURANT_NAME)
                .append(",").append(data.COLUMN_EAT_DATE)
                .append(",").append(data.COLUMN_EAT_TIME)
                .append(",").append(data.COLUMN_GRADE)
                .append(" from ").append(data.TABLE_USER_RAP)
                .append(" join ").append(data.TABLE_RESTAURANT)
                .append(" on ").append(data.TABLE_RESTAURANT).append(".").append(data.COLUMN_RESTAURANT_ID)
                .append(" = ").append(data.TABLE_USER_RAP).append(".").append(data.COLUMN_RESTAURANT_ID)
                .append(" where ").append(data.COLUMN_USER_ID)
                .append(" = (SELECT ").append(data.COLUMN_USER_ID)
                .append(" from ").append(data.TABLE_USER)
                .append(" where ").append(data.COLUMN_LOGIN_ID)
                .append(" = '").append(user_Name).append("')");

        try (Statement st = con.createStatement();
             ResultSet results = st.executeQuery(String.valueOf(USER_RAP_SELECT))) {
            ArrayList<OMMG_RAP_CHECK> ORCS = new ArrayList<>();
            while (results.next()) {
                OMMG_RAP_CHECK orc = new OMMG_RAP_CHECK();
                orc.setGRADE_ID(results.getInt(data.COLUMN_GRADE_ID));
                orc.setRESTAURANT_NAME(results.getString(data.COLUMN_RESTAURANT_NAME));
                orc.setEAT_DATE(results.getString(data.COLUMN_EAT_DATE));
                orc.setEAT_TIME(results.getString(data.COLUMN_EAT_TIME));
                orc.setGRADE(results.getInt(data.COLUMN_GRADE));
                ORCS.add(orc);
            }
            if (ORCS == null) {
                System.out.println("Can't find an artist");
            }
            return ORCS;
//            for (OMMG_RAP_CHECK a : ORCS)
//                System.out.println(data.COLUMN_USER_ID + " : " + a.getGRADE_ID()
//                        + "  \t| "+ data.COLUMN_RESTAURANT_ID + " : " + a.getRESTAURANT_NAME()
//                        + "   \t|" + data.COLUMN_EAT_DATE + " : " + a.getEAT_DATE()
//                        + " \t|" + data.COLUMN_EAT_TIME + " : " + a.getEAT_TIME()
//                        + " \t|" + data.COLUMN_GRADE + " : " + a.getGRADE());

        } catch (SQLException e) {
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void User_Rap_Check_Table_Select(ArrayList<OMMG_RAP_CHECK> URCT,JFrame JF) {

        int count = 0;
        for (OMMG_RAP_CHECK a : URCT){
            JLabel text = new JLabel(data.COLUMN_GRADE_ID + " : " + a.getGRADE_ID()
                    + "  \t| " + data.COLUMN_RESTAURANT_ID + " : " + a.getRESTAURANT_NAME()
                    + "   \t|" + data.COLUMN_EAT_DATE + " : " + a.getEAT_DATE()
                    + " \t|" + data.COLUMN_EAT_TIME + " : " + a.getEAT_TIME()
                    + " \t|" + data.COLUMN_GRADE + " : " + a.getGRADE());
            text.setBounds(10, count += 20, 800, 40);
            JF.add(text);
        }
//            System.out.println(data.COLUMN_USER_ID + " : " + a.getGRADE_ID()
//                    + "  \t| " + data.COLUMN_RESTAURANT_ID + " : " + a.getRESTAURANT_NAME()
//                    + "   \t|" + data.COLUMN_EAT_DATE + " : " + a.getEAT_DATE()
//                    + " \t|" + data.COLUMN_EAT_TIME + " : " + a.getEAT_TIME()
//                    + " \t|" + data.COLUMN_GRADE + " : " + a.getGRADE());
    }
}
