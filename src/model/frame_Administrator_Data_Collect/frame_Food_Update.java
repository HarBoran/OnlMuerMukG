package model.frame_Administrator_Data_Collect;

import model.administrator;
import model.administrator_data;
import model.frame_Administrator_Collect.frame_Set_Food_Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Food_Update extends JFrame{
    public void frame_Food_Update_Method(Connection con, String type) {
        frame_Set_Food_Table fsft = new frame_Set_Food_Table();
        administrator_data ad = new administrator_data();

        setSize(300, 400);
        setTitle("Food_Update");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel text = new JLabel("변경할 음식의 이름 혹은 번호를 입력하세요.");
        TextField food_Name_Select = new TextField();
        JButton button = new JButton("음식 변경");
        JButton go_back = new JButton("돌아가기");

        text.setBounds(20, 80, 500, 30);
        food_Name_Select.setBounds(20, 110, 90, 30);
        button.setBounds(20,140,100,30);
        go_back.setBounds(150,300,100,30);

        add(text);
        add(food_Name_Select);
        add(button);
        add(go_back);
        setVisible(true);


        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String food_Name = food_Name_Select.getText();
                    dispose();
                    ad.food_Update(food_Name, con, type);
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
        go_back.addActionListener(action2);
    }
}
