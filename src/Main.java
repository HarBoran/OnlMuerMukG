import model.Datasource;
import model.PrintFrame;
import model.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {

        Datasource datasource = new Datasource();

        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        PrintFrame pf = new PrintFrame();
        pf.JFrame();


//##############################################################


        // 프론트에서 받은 조건 대로 WHERE 조건을 설정해 래스트로랑 인덱스를 가지고와 저장함
        ArrayList<Integer> restaurantIds = datasource.queryOMMG();

        if(restaurantIds == null){
                System.out.println("Can't find a restaurantIds");
                return;
            }

//      for(int i= 0; i < restaurantIds.size(); i++)
//          System.out.println(restaurantIds.get(i));
        for (Integer restaurantId : restaurantIds)
            System.out.println(restaurantId);


//##############################################################


        //queryOMMG에서 저장한 인덱스를 파라미터 값으로 넣어 레스토랑의 상세 정보를 가져옴
        for (Integer restaurantId : restaurantIds) {

            List<Output> ommgs = datasource.Output(restaurantIds.get(restaurantId-1));

                if (ommgs == null) {
                    System.out.println("Can't find an ommgs");
                    return;
                }

                for (Output ommg : ommgs) {
                    System.out.println(ommg.getRestaurantName() +" "+ ommg.getRestaurantCategory() +" "+ ommg.getAgvGrade() +" "+ ommg.getDistance());

                    PrintFrame ff = new PrintFrame();


                }
        }


//##############################################################

        
        datasource.close();
    }
}