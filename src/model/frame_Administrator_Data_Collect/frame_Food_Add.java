package model.frame_Administrator_Data_Collect;

import model.administrator_data;
import model.frame_Administrator_Collect.frame_Set_Food_Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Food_Add extends JFrame{
    public void frame_Food_Add_Method(Connection con, String type) {
        frame_Set_Food_Table fsft = new frame_Set_Food_Table();
        administrator_data ad = new administrator_data();

        setSize(300, 400);
        setTitle("Food_Add");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel text = new JLabel("추가할 음식의 이름을 입력하세요.");
        JLabel text2 = new JLabel("추가할 음식의 카테고리를 입력하세요.");
        TextField food_Name_Select = new TextField();
        TextField food_Category_Select = new TextField();
        JButton button = new JButton("음식 추가");
        JButton button2 = new JButton("돌아가기");

        text.setBounds(20, 50, 500, 30);
        food_Name_Select.setBounds(20, 80, 90, 30);
        text2.setBounds(20, 110, 500, 30);
        food_Category_Select.setBounds(20, 140, 90, 30);
        button.setBounds(20,200,100,30);
        button2.setBounds(150,300,100,30);

        add(text);
        add(text2);
        add(food_Name_Select);
        add(food_Category_Select);
        add(button);
        add(button2);
        setVisible(true);


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(food_Name_Select == null && food_Category_Select == null){

                }else {
                    String food_Name = food_Name_Select.getText();
                    String food_Category = food_Category_Select.getText();
                    ad.food_Add(food_Name, food_Category, con);
                    dispose();
                    fsft.frame_Set_Food_Table_Mathod(con, type);
                }
            }
        };

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                fsft.frame_Set_Food_Table_Mathod(con, type);
            }
        };
        button.addActionListener(action);
        button2.addActionListener(action2);
    }
}
