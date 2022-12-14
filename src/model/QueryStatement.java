package model;

import model.ArrayList_Collect.Output;
import model.Datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class QueryStatement extends Datasource {

   /* public String Query() {

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
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"νμ\"");
                if (!(!pf.b13 && !pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b13) {
                if (!pf.b12) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μΌμ\"");
                if (!(!pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b14) {
                if (!pf.b12 && !pf.b13) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μμ\"");
                if (!(!pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b15) {
                if (!pf.b12 && !pf.b13 && !pf.b14) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μ€μ\"");
                if (!(!pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b16) {
                if (!pf.b12 && !pf.b13 && !pf.b14 && !pf.b15) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"κΈ°ν\"");
            }
        } else {
            sb.append(" WHERE " + COLUMN_RESTAURANT_CATEGORY + " IN (\"νμ\" , \"μΌμ\" , \"μμ\" , \"μ€μ\" , \"κΈ°ν\")");
        }

        *//*
        boolean b = true;

        if(!pf.b11) {
            if (pf.b12) {
                sb.append(" WHERE ");
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"νμ\"");
                b = false;
                if (!(!pf.b13 && !pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b13) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μΌμ\"");
                b = false;
                if (!(!pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b14) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μμ\"");
                b = false;
                if (!(!pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b15) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μ€μ\"");
                b = false;
                if (!(!pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b16) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"κΈ°ν\"");
            }
        }else {
            sb.append(" WHERE " + COLUMN_RESTAURANT_CATEGORY + " IN (\"νμ\" , \"μΌμ\" , \"μμ\" , \"μ€μ\" , \"κΈ°ν\")");
        }
        *//*

        if (!pf.b21) {
            if (pf.b22) {
                sb.append(" AND ");
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"μ/λ°₯\"");
                if (!(!pf.b23 && !pf.b24 && !pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b23) {
                if (!pf.b22) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"λ©΄μλ¦¬\"");
                if (!(!pf.b24 && !pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b24) {
                if (!pf.b22 && !pf.b23) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"κ΅­/ν\"");
                if (!(!pf.b25 && !pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b25) {
                if (!pf.b22 && !pf.b23 && !pf.b24) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"κ³ κΈ°\"");
                if (!(!pf.b26 && !pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b26) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"μ±μ\"");
                if (!(!pf.b27 && !pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b27) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25 && !pf.b26) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"λμ νΈ\"");
                if (!(!pf.b28)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b28) {
                if (!pf.b22 && !pf.b23 && !pf.b24 && !pf.b25 && !pf.b26 && !pf.b27) {
                    sb.append(" AND ");
                }
                sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"κΈ°ν\"");
            }
        } else {
            sb.append(" AND " + COLUMN_FOOD_CATEGORY + " IN (\"μ/λ°₯\" , \"λ©΄μλ¦¬\" , \"κ΅­/ν\" , \"κ³ κΈ°\" , \"μ±μ\", \"λμ νΈ\", \"κΈ°ν\")");
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
    //μΏΌλ¦¬λ*/




//#####################################################
   public String Query(Boolean[][] pf) {

       StringBuilder sb = new StringBuilder();

//      6400 * 2 * 3.14 / 360 = 111.64444444...
       sb.append("SELECT " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + ", " + COLUMN_RESTAURANT_NAME + ", " + COLUMN_RESTAURANT_CATEGORY + ", " + "AVG(" + COLUMN_GRADE + ")" + ", " + "111.64*ABS((" + COLUMN_LATITUDE + "-" + COLUMN_LATITUDE_USER + ")-(" + COLUMN_LATITUDE + "-" + COLUMN_LATITUDE_USER + ") + (" + COLUMN_HARDNESS + "-" + COLUMN_HARDNESS_USER + ")*(" + COLUMN_HARDNESS + "-" + COLUMN_HARDNESS_USER + "))" + " AS DistanceSquared");
       sb.append(" FROM " + TABLE_RESTAURANT + " LEFT JOIN " + TABLE_RESTAURANT_MENU);
       sb.append(" ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_RESTAURANT_MENU + "." + COLUMN_RESTAURANT_ID);
       sb.append(" LEFT JOIN " + TABLE_MENU + " ON " + TABLE_RESTAURANT_MENU + "." + COLUMN_MENU_ID + " = " + TABLE_MENU + "." + COLUMN_MENU_ID);
       sb.append(" LEFT JOIN " + TABLE_USER_RAP + " ON " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID + " = " + TABLE_USER_RAP + "." + COLUMN_RESTAURANT_ID);
       sb.append(" LEFT JOIN " + TABLE_USER + " ON " + TABLE_USER_RAP + "." + COLUMN_USER_ID + " = " + TABLE_USER + "." + COLUMN_USER_ID);

       if (!pf[1][1]) {
           if (pf[1][2]) {
               sb.append(" WHERE ");
               sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"νμ\"");
               if (!(!pf[1][3] && !pf[1][4] && !pf[1][5] && !pf[1][6])) {
                   sb.append(" OR ");
               }
           }
           if (pf[1][3]) {
               if (!pf[1][2]) {
                   sb.append(" WHERE ");
               }
               sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μΌμ\"");
               if (!(!pf[1][4] && !pf[1][5] && !pf[1][6])) {
                   sb.append(" OR ");
               }
           }
           if (pf[1][4]) {
               if (!pf[1][2] && !pf[1][3]) {
                   sb.append(" WHERE ");
               }
               sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μμ\"");
               if (!(!pf[1][5] && !pf[1][6])) {
                   sb.append(" OR ");
               }
           }
           if (pf[1][5]) {
               if (!pf[1][2] && !pf[1][3] && !pf[1][4]) {
                   sb.append(" WHERE ");
               }
               sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μ€μ\"");
               if (!(!pf[1][6])) {
                   sb.append(" OR ");
               }
           }
           if (pf[1][6]) {
               if (!pf[1][2] && !pf[1][3] && !pf[1][4] && !pf[1][5]) {
                   sb.append(" WHERE ");
               }
               sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"κΈ°ν\"");
           }
       } else {
           sb.append(" WHERE " + COLUMN_RESTAURANT_CATEGORY + " IN (\"νμ\" , \"μΌμ\" , \"μμ\" , \"μ€μ\" , \"κΈ°ν\")");
       }

        /*
        boolean b = true;

        if(!pf.b11) {
            if (pf.b12) {
                sb.append(" WHERE ");
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"νμ\"");
                b = false;
                if (!(!pf.b13 && !pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b13) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μΌμ\"");
                b = false;
                if (!(!pf.b14 && !pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b14) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μμ\"");
                b = false;
                if (!(!pf.b15 && !pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b15) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"μ€μ\"");
                b = false;
                if (!(!pf.b16)) {
                    sb.append(" OR ");
                }
            }
            if (pf.b16) {
                if (b) {
                    sb.append(" WHERE ");
                }
                sb.append(COLUMN_RESTAURANT_CATEGORY + " = " + "\"κΈ°ν\"");
            }
        }else {
            sb.append(" WHERE " + COLUMN_RESTAURANT_CATEGORY + " IN (\"νμ\" , \"μΌμ\" , \"μμ\" , \"μ€μ\" , \"κΈ°ν\")");
        }
        */

       if (!pf[2][1]) {
           if (pf[2][2]) {
               sb.append(" AND ");
               sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"μ/λ°₯\"");
               if (!(!pf[2][3] && !pf[2][4] && !pf[2][5] && !pf[2][6] && !pf[2][7] && !pf[2][8])) {
                   sb.append(" OR ");
               }
           }
           if (pf[2][3]) {
               if (!pf[2][2]) {
                   sb.append(" AND ");
               }
               sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"λ©΄μλ¦¬\"");
               if (!(!pf[2][4] && !pf[2][5] && !pf[2][6] && !pf[2][7] && !pf[2][8])) {
                   sb.append(" OR ");
               }
           }
           if (pf[2][4]) {
               if (!pf[2][2] && !pf[2][3]) {
                   sb.append(" AND ");
               }
               sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"κ΅­/ν\"");
               if (!(!pf[2][5] && !pf[2][6] && !pf[2][7] && !pf[2][8])) {
                   sb.append(" OR ");
               }
           }
           if (pf[2][5]) {
               if (!pf[2][2] && !pf[2][3] && !pf[2][4]) {
                   sb.append(" AND ");
               }
               sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"κ³ κΈ°\"");
               if (!(!pf[2][6] && !pf[2][7] && !pf[2][8])) {
                   sb.append(" OR ");
               }
           }
           if (pf[2][6]) {
               if (!pf[2][2] && !pf[2][3] && !pf[2][4] && !pf[2][5]) {
                   sb.append(" AND ");
               }
               sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"μ±μ\"");
               if (!(!pf[2][7] && !pf[2][8])) {
                   sb.append(" OR ");
               }
           }
           if (pf[2][7]) {
               if (!pf[2][2] && !pf[2][3] && !pf[2][4] && !pf[2][5] && !pf[2][6]) {
                   sb.append(" AND ");
               }
               sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"λμ νΈ\"");
               if (!(!pf[2][8])) {
                   sb.append(" OR ");
               }
           }
           if (pf[2][8]) {
               if (!pf[2][2] && !pf[2][3] && !pf[2][4] && !pf[2][5] && !pf[2][6] && !pf[2][7]) {
                   sb.append(" AND ");
               }
               sb.append(COLUMN_FOOD_CATEGORY + " = " + "\"κΈ°ν\"");
           }
       } else {
           sb.append(" AND " + COLUMN_FOOD_CATEGORY + " IN (\"μ/λ°₯\" , \"λ©΄μλ¦¬\" , \"κ΅­/ν\" , \"κ³ κΈ°\" , \"μ±μ\", \"λμ νΈ\", \"κΈ°ν\")");
       }

       if (pf[3][1]) {
           sb.append(" AND " + "DistanceSquared" + " < " + 0.09); //300M
       } else if (pf[3][2]) {
           sb.append(" AND " + "DistanceSquared" + " < " + 0.25); //500M
       } else if (pf[3][3]) {
           sb.append(" AND " + "DistanceSquared" + " < " + 1); // 1KM
       } else if (pf[3][4]) {
           sb.append(" AND " + "DistanceSquared" + " < " + 25); //5KM
       } else if (pf[3][5]) {
           sb.append(" AND " + "DistanceSquared" + " < " + 100); //100KM
       } else {
           sb.append(" ");
       }

       sb.append(" GROUP BY " + TABLE_RESTAURANT + "." + COLUMN_RESTAURANT_ID);

//        System.out.println(sb.toString());

       return sb.toString();

   }


//    μΏΌλ¦¬λ
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
                // κ±°λ¦¬ μ κ³±μ λ£¨νΈ μ²λ¦¬
                ommg.setDistance(Math.round(Math.sqrt(results.getFloat(5))*1000)/1000.0);
                ommgs.add(ommg);
                Collections.shuffle(ommgs);
                if (ommgs.size() > 5){
                    ommgs.remove(1);
                }
            }

            return ommgs;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

    }
}
