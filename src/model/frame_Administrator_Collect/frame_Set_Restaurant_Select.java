package model.frame_Administrator_Collect;

import model.administrator;
import model.administrator_data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Set_Restaurant_Select extends JFrame {
    public void frame_Set_Restaurant_Select_Method(Connection con, String type) {

        administrator_data adt = new administrator_data();

        setSize(300, 400);
        setTitle("Set_Restaurant_Select");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        administrator admin = new administrator();
        administrator_data ad_data = new administrator_data();


        JLabel text = new JLabel("음식점 관리모드 입니다..");
        TextField restaurant_Name_Select = new TextField();
        JButton button = new JButton("음식점 선택");
        JButton go_back = new JButton("돌아가기");

        text.setBounds(20, 80, 500, 30);
        restaurant_Name_Select.setBounds(20, 110, 90, 30);
        button.setBounds(20,140,100,30);
        go_back.setBounds(150,300,100,30);

        add(text);
        add(restaurant_Name_Select);
        add(button);
        add(go_back);
        setVisible(true);


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String restaurant_Name = restaurant_Name_Select.getText();
                try {
                    Integer.parseInt(restaurant_Name);
                    adt.restaurant_Setting((Integer.valueOf(restaurant_Name)),con ,type);

                } catch (Exception ex) {
                    adt.restaurant_Setting(restaurant_Name,con, type);

                }
            }
        };
        button.addActionListener(action);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                admin.administrator_Main(con,type);
            }
        };
        go_back.addActionListener(action2);
    }
}
