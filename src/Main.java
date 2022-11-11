import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();

        if(datasource.open()) {
            new LoginFrame((datasource.getConn()));
//            return;
        }

    }
}