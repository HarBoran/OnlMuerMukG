import model.*;
import model.ArrayList_Collect.Output;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Datasource datasource = new Datasource();

        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

//##############################################################

        PrintFrame pf = new PrintFrame();

        pf.OutputFrame(datasource.getConn());


//##############################################################
//
//        ArrayList<Output> outputs= datasource.Output();
//
//            if (outputs == null) {
//                System.out.println("Can't find an output");
//                return;
//            }
//
////            for (Output output : outputs) {
////                System.out.println(output.getRestaurantID() + " " + output.getRestaurantName() +" "+ output.getRestaurantCategory() +" "+ output.getAgvGrade() +" "+ output.getDistance());
////            }
//
//        String[] name = new String[20];
//        String[] category = new String[20];
//        Float[] grade = new Float[20];
//        Double[] distance = new Double[20];
//        int i =0;
//
//        for (Output output : outputs) {
//            name[i] = output.getRestaurantName();
//            category[i] = output.getRestaurantCategory();
//            grade[i] = output.getAgvGrade();
//            distance[i] = output.getDistance();
//            i++;
//        }
//
//        System.out.println(name[0] +" "+ category[0] + " 평점"+ grade[0] +" 거리"+ distance[0]);
//        System.out.println(name[1] +" "+ category[1] + " 평점"+ grade[1] +" 거리"+ distance[1]);
//        System.out.println(name[2] +" "+ category[2] + " 평점"+ grade[2] +" 거리"+ distance[2]);
//        System.out.println(name[3] +" "+ category[3] + " 평점"+ grade[3] +" 거리"+ distance[3]);
//        System.out.println(name[4] +" "+ category[4] + " 평점"+ grade[4] +" 거리"+ distance[4]);

//##############################################################

        QueryStatement querystatement = new QueryStatement();
        ArrayList<Output> qs = querystatement.Output(datasource.getConn(), querystatement.Query());

        if (qs == null) {
            System.out.println("Can't find an output");
            return;
        }

            for (Output output : qs) {
                System.out.println(output.getRestaurantID() + " " + output.getRestaurantName() +" "+ output.getRestaurantCategory() +" "+ output.getAgvGrade() +" "+ output.getDistance());
            }


//##############################################################

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
            datasource.close();

    }
}