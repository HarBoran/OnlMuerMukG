package model.frame_Administrator_Data_Collect;

import model.administrator;
import model.administrator_data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Restaurant_Delete extends JFrame {
    public void frame_Restaurant_Delete_Method(String restaurant_Name,int restaurant_Id , Connection con, String type) {
        administrator_data ad = new administrator_data();
        setSize(300, 400);
        setTitle("Restaurant_Delete");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel text = new JLabel("정말로 음식점을 제거하시겠습니까?");
        JButton button = new JButton("음식점 제거");
        JButton button2 = new JButton("돌아가기");

        text.setBounds(20, 80, 500, 30);
        button.setBounds(20,140,100,30);
        button2.setBounds(80,140,100,30);

        add(text);
        add(button);
        add(button2);
        setVisible(true);


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.restaurant_Delete(restaurant_Name,con);
                dispose();
                administrator.administrator_Main(con, type);
            }
        };

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
                frs.frame_Restaurant_Setting_Method(restaurant_Name,restaurant_Id,con,type);
            }
        };
        button.addActionListener(action);
        button2.addActionListener(action2);
    }
}
