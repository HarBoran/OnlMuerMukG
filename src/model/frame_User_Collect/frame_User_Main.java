//package model.frame_User_Collect;
//
//import model.Datasource;
//import model.frame_Administrator_Data_Collect.frame_Menu_Add;
//import model.frame_Administrator_Data_Collect.frame_Menu_Delete;
//import model.owner;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class frame_User_Main extends JFrame{
//    public void frame_User_Main_Mathod(String user_name, Connection con, String type) {
//
//        setSize(300, 400);
//        setTitle("User_Main");
//        setLocationRelativeTo(null);
//        setResizable(false);
//        getContentPane().setLayout(null);
//
//        JLabel setting_mod = new JLabel(user_name + "유저의 메뉴입니다.");
//        JButton button1 = new JButton("1. 유저 사용기록 보기 및 리뷰입력");
//        JButton go_back = new JButton("2. 닫기");
//
//        setting_mod.setBounds(10, 00, 500, 40);
//        button1.setBounds(10, 50, 150, 30);
//        go_back.setBounds(150,300,100,30);
//
//        add(setting_mod);
//        add(button1);
//        add(go_back);
//        setVisible(true);
//
//        ActionListener action1 = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//             }
//        };
//        button1.addActionListener(action1);
//
//        ActionListener action2 = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        };
//        go_back.addActionListener(action2);
//    }
//}
