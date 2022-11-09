package model.frame_Administrator_Data_Collect;

import model.administrator;
import model.administrator_data;
import model.frame_Administrator_Collect.frame_Set_Food_Table;
import model.frame_Owner_Collect.frame_Owner_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Food_Delete extends JFrame{
    public void frame_Food_Delete_Method(Connection con, String type) {
        frame_Set_Food_Table fsft = new frame_Set_Food_Table();
        frame_Owner_Main fom = new frame_Owner_Main();
        administrator_data ad = new administrator_data();


        setSize(300, 400);
        setTitle("Food_Delete");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel text = new JLabel("제거할 음식의 이름 혹은 번호를 입력하세요.");
        TextField food_Name_Select = new TextField();
        JButton button = new JButton("음식 제거");
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
                    ad.food_Delete(food_Name, con);
                dispose();
//                    if(type.equals("Admin"))
                        fsft.frame_Set_Food_Table_Mathod(con, type);
//                    else if (type.equals("Owner"))
//                        fom.frame_Owner_Main_Mathod(,con,type);
            }
        };
        button.addActionListener(action);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                fsft.frame_Set_Food_Table_Mathod(con, type);
            }
        };
        go_back.addActionListener(action2);
    }
}
