import model.*;
import model.ArrayList_Collect.Output;
import model.frame_Collect.ServeFrame;
import model.frame_Collect.frame_Restaurant_Setting;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Datasource datasource = new Datasource();
//
//        if(!datasource.open()) {
//            System.out.println("Can't open datasource");
//            return;
//        }
//
////##############################################################
//
//
//        PrintFrame printframe = new PrintFrame();
//
//        printframe.OutputFrame(datasource.getConn());
//
//
        Datasource data = new Datasource();
        Scanner scan = new Scanner(System.in);
        if(data.open()) {
            while (true) {
                System.out.println("오늘 뭐 먹지?");
                System.out.println("1.로그인");
                System.out.println("2.회원가입");
                System.out.println("3.프로그램 종료");
                System.out.print("입력 : ");
                switch (scan.nextInt()) {
                    case 1:
                        login.LOGIN(data.getConn());
                        break;
                    case 2:
                        sign_Up.SIGN_UP_SELECT(data.getConn());
                        break;
                    case 3:
                        System.out.println("이용해주셔서 감사합니다.");
                        return;
                }
            }
        }


//##############################################################

            data.close();
//            datasource.close();
//        if(data.open()) {
//            frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
//            frs.frame_Restaurant_Setting_Method("restaurant_Name",1,data.getConn());
//        }



    }
}