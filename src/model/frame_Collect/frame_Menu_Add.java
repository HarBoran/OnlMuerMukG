package model.frame_Collect;

import model.Datasource;
import model.administrator;
import model.administrator_data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame_Menu_Add extends JFrame {
    public void frame_Menu_Add_Method() {

        setSize(300, 400);
        setTitle("Administrator_Restaurant_Setting");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel text = new JLabel("추가할 메뉴의 번호 혹은이름을 입력하세요.");
        TextField input = new TextField();
        text.setBounds(120, 80, 500, 30);
        input.setBounds(120, 120, 90, 30);

        add(text);
        add(input);


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String food_Name = text.getText();

                dispose();
            }
        };
        input.addActionListener(action);
    }
}
