package model.frame_Collect;

import model.Datasource;
import model.administrator;
import model.administrator_data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Menu_Add extends JFrame {
    public void frame_Menu_Add_Method(String restaurant_Name,int restaurant_Id , Connection con) {
        administrator_data ad = new administrator_data();
        setSize(300, 400);
        setTitle("Administrator_Restaurant_Setting");
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
                frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
                frs.frame_Restaurant_Setting_Method(restaurant_Name,restaurant_Id,con);

            }
        };
        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administrator_data ad_data = new administrator_data();
                Datasource data = new Datasource();
                dispose();
                frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
                frs.frame_Restaurant_Setting_Method(restaurant_Name, restaurant_Id, con);
            }
        };
        button.addActionListener(action);
        button2.addActionListener(action2);
    }
}
