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


//##############################################################
// 프론트에서 받은 조건 대로 WHERE 조건을 설정해 래스트로랑 인덱스를 가지고와 저장함


//        ArrayList<Integer> restaurantIds = datasource.queryOMMG();
/*
        if(restaurantIds == null){
                System.out.println("Can't find a restaurantIds");
                return;
            }

        //평볌한 반복문
//      for(int i= 0; i < restaurantIds.size(); i++)
//          System.out.println(restaurantIds.get(i));

        //향샹된 반복문
        for (Integer restaurantId : restaurantIds) {
            System.out.println(restaurantId);
        }*/



//##############################################################
// queryOMMG에서 저장한 인덱스를 파라미터 값으로 넣어 레스토랑의 상세 정보를 가져옴


//        for (Integer restaurantId : restaurantIds) {

        ArrayList<Output> outputs= datasource.Output();

                if (outputs == null) {
                    System.out.println("Can't find an ommgs");
                    return;
                }

                for (Output output : outputs) {
                    System.out.println(output.getRestaurantName() +" "+ output.getRestaurantCategory() +" "+ output.getAgvGrade() +" "+ output.getDistance());

                    PrintFrame ff = new PrintFrame();

                }




//##############################################################


        datasource.close();
    }
}