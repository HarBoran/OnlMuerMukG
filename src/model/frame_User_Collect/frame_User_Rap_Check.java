package model.frame_User_Collect;

import model.ArrayList_Collect.OMMG_RAP_CHECK;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

public class frame_User_Rap_Check {
    public void frame_User_Rap_Check_Mathod(String user_name, Connection con, String type) {

        User usm = new User();
        JFrame JF = new JFrame();
        frame_User_Grade fug = new frame_User_Grade();

        JF.setSize(600, 800);
        JF.setTitle("User_Rap_Check");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        JLabel user_menu = new JLabel(user_name + "유저의 사용기록입니다.");
        JLabel text = new JLabel("평점을 입력할 리뷰 번호를 선택하세요.");
        TextField select = new TextField();
        JButton button1 = new JButton("평점 입력");
        JButton go_back = new JButton("닫기");


        ArrayList<OMMG_RAP_CHECK> URCT = usm.User_Rap_Check_Table(user_name, con);
        usm.User_Rap_Check_Table_Select(URCT,JF);

        user_menu.setBounds(10, 00, 500, 40);
        text.setBounds(10,480,800,30);
        select.setBounds(10,510,300,30);
        button1.setBounds(10, 550, 150, 30);
        go_back.setBounds(400,550,100,30);

        JF.add(user_menu);
        JF.add(text);
        JF.add(select);
        JF.add(button1);
        JF.add(go_back);
        JF.setVisible(true);

        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
                int grade_id = Integer.parseInt(select.getText());
                fug.frame_User_Grade_Mathod(grade_id, user_name, con, type);
             }
        };
        button1.addActionListener(action1);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JF.dispose();
            }
        };
        go_back.addActionListener(action2);
    }
}
