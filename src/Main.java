import model.Datasource;
import model.PrintFrame;
import model.Output;

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
        pf.JFrame();

        ArrayList<Integer> restaurantIds = datasource.queryOMMG();;
            if(restaurantIds==null){
                System.out.println("Can't find a restaurantIds");
                return;
            }
            for(int i= 0; i < restaurantIds.size(); i++)
                System.out.println(restaurantIds.get(i));


        List<Output> ommgs = datasource.Output(1);
            if(ommgs==null){
                System.out.println("Can't find an ommgs");
                return;
            }

            for (Output ommg : ommgs){
                System.out.println(ommg.getRestaurantName() + ommg.getRestaurantCategory() + ommg.getAgvGrade() +" 식당 "+ommg.getLatitude()+ommg.getHardness()+ " 유저 "+ommg.getLatitude_user()+ommg.getHardness_user());
            }

        datasource.close();
    }
}