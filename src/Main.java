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


        PrintFrame printframe = new PrintFrame();

        printframe.OutputFrame(datasource.getConn());

//##############################################################

        QueryStatement querystatement = new QueryStatement();

        ArrayList<Output> output = querystatement.Output(datasource.getConn(), querystatement.Query(printframe.getBooleans()));

        if (output == null) {
            System.out.println("Can't find an output");
            return;
        }

            for (Output op : output) {
                System.out.println(op.getRestaurantID() + " " + op.getRestaurantName() +" "+ op.getRestaurantCategory() +" "+ op.getAgvGrade() +" "+ op.getDistance());
            }

//##############################################################



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