package model.frame_Administrator_Collect;

import model.administrator;
import model.frame_Administrator_Data_Collect.frame_Grade_Delete;
import model.frame_Administrator_Data_Collect.frame_User_Delete_Select;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Set_User_Select extends JFrame {
    public void fram_Set_User_Select_Mathod(Connection con, String type) {

        setSize(300, 400);
        setTitle("Set_User_Select");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel setting_mod = new JLabel("유저 관리 모드입니다");
        JLabel select = new JLabel("사용할 기능을 선택하세요.");
        JButton button1 = new JButton("1. 유저 삭제");
        JButton button2 = new JButton("2. 기록 삭제");
        JButton button3 = new JButton("3. 이전으로 돌아가기");

        setting_mod.setBounds(10, 00, 500, 40);
        select.setBounds(10, 20, 500, 40);
        button1.setBounds(10, 50, 150, 30);
        button2.setBounds(10, 90, 150, 30);
        button3.setBounds(10, 130, 150, 30);

        add(setting_mod);
        add(select);
        add(button1);
        add(button2);
        add(button3);
        setVisible(true);
        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_User_Delete_Select fuds = new frame_User_Delete_Select();
                fuds.frame_User_Delete_Select_Method(con, type);
            }
        };
        button1.addActionListener(action1);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Grade_Delete fgd = new frame_Grade_Delete();
                fgd.frame_Grade_Delete_Method(con, type);
            }
        };
        button2.addActionListener(action2);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                administrator.administrator_Main(con,type);
            }
        };
        button3.addActionListener(action3);

    }
}



