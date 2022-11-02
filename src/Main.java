import model.Datasource;
import model.PrintFrame;
import model.Output;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Datasource datasource = new Datasource();

        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

//##############################################################

        PrintFrame pf = new PrintFrame();

        pf.JFrame();



//##############################################################

        ArrayList<Output> outputs= datasource.Output();

            if (outputs == null) {
                System.out.println("Can't find an output");
                return;
            }

            for (Output output : outputs) {
                System.out.println(output.getRestaurantName() +" "+ output.getRestaurantCategory() +" "+ output.getAgvGrade() +" "+ output.getDistance());

            }


//##############################################################

        datasource.close();

    }
}