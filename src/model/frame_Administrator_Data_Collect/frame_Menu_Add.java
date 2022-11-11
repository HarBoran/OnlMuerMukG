package model.frame_Administrator_Data_Collect;

import model.Datasource;
import model.administrator_data;
import model.frame_Owner_Collect.frame_Owner_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class frame_Menu_Add extends JFrame {
    public void frame_Menu_Add_Method(String restaurant_Name, int restaurant_Id, Connection con, String type) {
        administrator_data ad = new administrator_data();
        frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
        frame_Owner_Main fom = new frame_Owner_Main();
        Datasource data = new Datasource();

        setSize(300, 400);
        setTitle("Menu_Add");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel text = new JLabel("추가할 메뉴의 번호 혹은이름을 입력하세요.");
        TextField input = new TextField();
        JButton button = new JButton("음식 추가");

        text.setBounds(20, 80, 500, 30);
        input.setBounds(20, 110, 90, 30);
        button.setBounds(20,140,100,30);

        JButton button2 = new JButton("돌아가기");
        button2.setBounds(150,300,100,30);

        add(text);
        add(input);
        add(button);
        add(button2);
        setVisible(true);


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String food_Name = input.getText();
                ad.menu_Add(restaurant_Id,food_Name,con);
                dispose();
                if(type.equals("Admin"))
                    frs.frame_Restaurant_Setting_Method(restaurant_Name,restaurant_Id,con,type);
                else if(type.equals("Owner")) {
                    StringBuilder owner_name_check = new StringBuilder("Select ")
                            .append(data.COLUMN_OWNER_ID)
                            .append(" from ").append(data.TABLE_RESTAURANT)
                            .append(" Where ").append(data.COLUMN_RESTAURANT_ID)
                            .append(" = ").append(restaurant_Id);
                    try {
                        Statement st = con.createStatement();
                        ResultSet results = st.executeQuery(String.valueOf(owner_name_check));

                        fom.frame_Owner_Main_Mathod(results.getString(data.COLUMN_OWNER_ID), con, type);
                    }catch (SQLException ex){
                        System.out.println(data.ERROR + ex.getMessage());
                        ex.getMessage();
                    }
                }
            }
        };
        button.addActionListener(action);
        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(type.equals("Admin"))
                    frs.frame_Restaurant_Setting_Method(restaurant_Name,restaurant_Id,con,type);
                else if(type.equals("Owner")) {
                    StringBuilder owner_name_check = new StringBuilder("Select ")
                            .append(data.COLUMN_OWNER_ID)
                            .append(" from ").append(data.TABLE_RESTAURANT)
                            .append(" Where ").append(data.COLUMN_RESTAURANT_ID)
                            .append(" = ").append(restaurant_Id);
                    try {
                        Statement st = con.createStatement();
                        ResultSet results = st.executeQuery(String.valueOf(owner_name_check));

                        fom.frame_Owner_Main_Mathod(results.getString(data.COLUMN_OWNER_ID), con, type);
                    }catch (SQLException ex){
                        System.out.println(data.ERROR + ex.getMessage());
                        ex.getMessage();
                    }
                }
            }
        };
        button2.addActionListener(action2);
    }
}
