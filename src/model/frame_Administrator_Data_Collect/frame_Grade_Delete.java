package model.frame_Administrator_Data_Collect;

import model.administrator;
import model.administrator_data;
import model.frame_Administrator_Collect.frame_Set_Food_Table;
import model.frame_Administrator_Collect.frame_Set_User_Select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Grade_Delete extends JFrame{
    public void frame_Grade_Delete_Method(Connection con, String type) {
        frame_Set_User_Select fsus = new frame_Set_User_Select();
        administrator_data ad = new administrator_data();

        setSize(300, 400);
        setTitle("Grade_Delete");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel text = new JLabel("제거할 기록의 번호를 입력하세요.");
        TextField input = new TextField();
        JButton button = new JButton("기록 제거");

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
                int grade_Num = Integer.parseInt(input.getText());
                ad.grade_Delete(grade_Num, con);
                dispose();
                fsus.fram_Set_User_Select_Mathod(con, type);
            }
        };

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                fsus.fram_Set_User_Select_Mathod(con, type);
            }
        };
        button.addActionListener(action);
        button2.addActionListener(action2);
    }
}
