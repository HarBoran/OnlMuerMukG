package model.frame_User_Collect;

import model.User;
import model.frame_Administrator_Collect.frame_Set_Food_Table;
import model.frame_Administrator_Collect.frame_Set_Restaurant_Select;
import model.frame_Administrator_Collect.frame_Set_User_Select;
import model.frame_Administrator_Collect.frame_test_Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_User_Grade extends JFrame {
    public void frame_User_Grade_Mathod(int grade_Id, String user_Name,Connection con, String type) {
        User us = new User();
        frame_User_Rap_Check furc = new  frame_User_Rap_Check();

        setSize(600, 800);
        setTitle("User_Grade");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel setting_mod = new JLabel(grade_Id + "번 기록의 점수를 매겨주세요.");
        JButton button1 = new JButton("1점");
        JButton button2 = new JButton("2점");
        JButton button3 = new JButton("3점");
        JButton button4 = new JButton("4점");
        JButton button5 = new JButton("5점");
        JButton go_back = new JButton("닫기");


        setting_mod.setBounds(10, 00, 500, 40);
        button1.setBounds(10, 50, 80, 30);
        button2.setBounds(80, 50, 80, 30);
        button3.setBounds(150, 50, 80, 30);
        button4.setBounds(220, 50, 80, 30);
        button5.setBounds(290, 50, 80, 30);
        go_back.setBounds(150,300,100,30);

        add(setting_mod);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(go_back);
        setVisible(true);

        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                us.User_Grade(grade_Id,1,user_Name,con);
                furc.frame_User_Rap_Check_Mathod(user_Name,con,type);
            }
        };
        button1.addActionListener(action1);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                us.User_Grade(grade_Id,2,user_Name,con);
                furc.frame_User_Rap_Check_Mathod(user_Name,con,type);
            }
        };
        button2.addActionListener(action2);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                us.User_Grade(grade_Id,3,user_Name,con);
                furc.frame_User_Rap_Check_Mathod(user_Name,con,type);
            }
        };
        button3.addActionListener(action3);

        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                us.User_Grade(grade_Id,4,user_Name,con);
                furc.frame_User_Rap_Check_Mathod(user_Name,con,type);
            }
        };
        button4.addActionListener(action4);

        ActionListener action5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                us.User_Grade(grade_Id,5,user_Name,con);
                furc.frame_User_Rap_Check_Mathod(user_Name,con,type);
            }
        };
        button5.addActionListener(action5);

        ActionListener back_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                furc.frame_User_Rap_Check_Mathod(user_Name,con,type);
            }
        };
        go_back.addActionListener(back_action);

    }
}



