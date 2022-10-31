import model.Datasource;
import model.PrintFrame;
import model.OMMG;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Datasource datasource = new Datasource();

        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        PrintFrame pf = new PrintFrame();
        //pf.JFrame();



        datasource.queryOMMG();
        ArrayList<Integer> restaurantIds = datasource.queryOMMG();;

        if(restaurantIds==null){
            System.out.println("Can't find a restaurantIds");
            return;
        }

        for (int restaurantId : restaurantIds){
            System.out.println(restaurantId);
            System.out.println(restaurantIds.get(restaurantId));
        }


        datasource.OMMG(123);
        List<OMMG> ommgs = datasource.OMMG(123);

        if(ommgs==null){
            System.out.println("Can't find an ommgs");
            return;
        }

        for (OMMG ommg : ommgs){
            System.out.println(ommg.getRestaurantName() + ommg.getRestaurantCategory() + ommg.getAgvGrade() + ommg.getDistance());
        }

        datasource.close();
    }
}