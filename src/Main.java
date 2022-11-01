import model.Datasource;
import model.administrator;

import javax.swing.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Datasource data = new Datasource();
        Scanner scan = new Scanner(System.in);
        if(data.open()) {

            System.out.print("사용할 ID를 입력하세요. : ");
            String user_id = "Admin";
            if (user_id.equals("Admin")) {
                administrator.administrator_Main(data.getCon());
            }
        }
    }
}