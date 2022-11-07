package model;

import model.ArrayList_Collect.Output;
import model.Datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryStatement extends Datasource {

    public String Query() {

        StringBuilder sb = new StringBuilder();
        PrintFrame pf = new PrintFrame();

//      6400 * 2 * 3.14 / 360 = 111.64444444...
        sb.append("SELECT " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + ", " + COLUMN_RESTAURANT_NAME + ", " + COLUMN_RESTAURANT_CATEGORY + ", " + "AVG(" + COLUMN_GRADE + ")" + ", " + "111.64*ABS((" + COLUMN_LATITUDE + "-" + COLUMN_LATITUDE_USER + ")-(" + COLUMN_LATITUDE + "-" + COLUMN_LATITUDE_USER + ") + (" + COLUMN_HARDNESS + "-" + COLUMN_HARDNESS_USER + "))" + " AS DistanceSquared");
        sb.append(" FROM " + TABLE_RESTAURANT + " LEFT JOIN " + TABLE_RESTAURANT_MENU);
        sb.append(" ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_RESTAURANT_MENU + "." + COLUMN_RESTAURANT_ID);
        sb.append(" LEFT JOIN " + TABLE_MENU + " ON " + TABLE_RESTAURANT_MENU + "." + COLUMN_MENU_ID + " = " + TABLE_MENU + "." + COLUMN_MENU_ID);
        sb.append(" LEFT JOIN " + TABLE_USER_RAP + " ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_USER_RAP + "." + COLUMN_RESTAURANT_ID);
        sb.append(" LEFT JOIN " + TABLE_USER + " ON " + TABLE_USER_RAP + "." + COLUMN_USER_ID + " = " + TABLE_USER + "." + COLUMN_USER_ID);

        if (!pf.b11) {
            if (pf.b12) {
                sb.append(" WHERE ");
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"한식\"");
                if (!(!pf.b13 && !pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b13) {
                if (!pf.b12) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"일식\"");
                if (!(!pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b14) {
                if (!pf.b12 && !pf.b13) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"양식\"");
                if (!(!pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b15) {
                if (!pf.b12 && !pf.b13 && !pf.b14) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"중식\"");
                if (!(!pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b16) {
                if (!pf.b12 && !pf.b13 && !pf.b14 && !pf.b15) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"기타\"");
            }
        } else {
            sb.append(" WHERE " + COLUMN_RESTAURANT_CATEGORY + " IN (\"한식\" , \"일식\" , \"양식\" , \"중식\" , \"기타\")");
        }

        /*
        boolean b = true;

        if(!pf.b11) {
            if (pf.b12) {
                sb.append(" WHERE ");
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"한식\"");
                b = false;
                if (!(!pf.b13 && !pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b13) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"일식\"");
                b = false;
                if (!(!pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b14) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"양식\"");
                b = false;
                if (!(!pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b15) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"중식\"");
                b = false;
                if (!(!pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b16) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"기타\"");
            }
        }else {
            sb.append(" WHERE " + COLUMN_RESTAURANT_CATEGORY + " IN (\"한식\" , \"일식\" , \"양식\" , \"중식\" , \"기타\")");
        }
        */

        if (!pf.b21) {
            if (pf.b22) {
                sb.append(" AND ");
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"쌀/밥\"");
                if (!(!pf.b23 && !pf.b24 && !pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b23) {
                if (!pf.b22) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"면요리\"");
                if (!(!pf.b24 && !pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b24) {
                if (!pf.b22 && !pf.b23) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"국/탕\"");
                if (!(!pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b25) {
                if (!pf.b22 && !pf.b23 && !pf.b24) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"고기\"");
                if (!(!pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b26) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"채식\"");
                if (!(!pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b27) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25 && !pf.b26) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"디저트\"");
                if (!(!pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b28) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25 && !pf.b26 && !pf.b27) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"기타\"");
            }
        } else {
            sb.append(" AND " + COLUMN_FOOD_CATEGORY + " IN (\"쌀/밥\" , \"면요리\" , \"국/탕\" , \"고기\" , \"채식\", \"디저트\", \"기타\")");
        }

        if (pf.b31) {
            sb.append(" AND " + "DistanceSquared" + " < " + 0.09); //300M
        } else if (pf.b32) {
            sb.append(" AND " + "DistanceSquared" + " < " + 0.25); //500M
        } else if (pf.b33) {
            sb.append(" AND " + "DistanceSquared" + " < " + 1); // 1KM
        } else if (pf.b34) {
            sb.append(" AND " + "DistanceSquared" + " < " + 25); //5KM
        } else if (pf.b35) {
            sb.append(" AND " + "DistanceSquared" + " < " + 100); //100KM
        } else {
            sb.append(" ");
        }

        sb.append(" GROUP BY " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID);

//        System.out.println(sb.toString());

        return sb.toString();

    }
    //쿼리끝


//#####################################################

    public ArrayList<Output> Output(Connection conn, String sb){
//        System.out.println(sb);
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            ArrayList<Output> ommgs = new ArrayList<Output>();

            while (results.next()) {
                Output ommg = new Output();
                ommg.setRestaurantID(results.getInt(COLUMN_RESTAURANT_ID));
                ommg.setRestaurantName(results.getString(COLUMN_RESTAURANT_NAME));
                ommg.setRestaurantCategory(results.getString(COLUMN_RESTAURANT_CATEGORY));
                ommg.setAgvGrade(results.getFloat(4));
                ommg.setDistance(Math.sqrt(results.getFloat(5))); // 거리 제곱에 루트 처리
                ommgs.add(ommg);
//                Collections.shuffle(ommgs);
//                if (ommgs.size() > 5){
//                    ommgs.remove(1);
//                }
            }

            return ommgs;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

    }
}
