package model.frame_Administrator_Collect;

import model.administrator;
import model.test_Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_test_Table extends JFrame {
    public void frame_test_Table_Mathod(Connection con, String type) {
        test_Table tt = new test_Table();
        setSize(300, 400);
        setTitle("test_Table");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel setting_mod = new JLabel("관리자 모드입니다");
        JLabel select = new JLabel("사용할 기능을 선택하세요.");
        JButton button1 = new JButton("1. 유저");
        JButton button2 = new JButton("2. 유저기록");
        JButton button3 = new JButton("3. 음식점");
        JButton button4 = new JButton("4. 음식점메뉴");
        JButton button5 = new JButton("5. 메뉴");
        JButton button6 = new JButton("6. 돌아가기");

        setting_mod.setBounds(10, 00, 500, 40);
        select.setBounds(10, 20, 500, 40);
        button1.setBounds(10, 50, 150, 30);
        button2.setBounds(10, 90, 150, 30);
        button3.setBounds(10, 130, 150, 30);
        button4.setBounds(10, 170, 150, 30);
        button5.setBounds(10, 210, 150, 30);
        button6.setBounds(10, 250, 150, 30);

        add(setting_mod);
        add(select);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        setVisible(true);
        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                tt.select_USER_table(con, type);
            }
        };
        button1.addActionListener(action1);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                tt.select_USER_RAP_table(con, type);
            }
        };
        button2.addActionListener(action2);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                tt.select_RESTAURANT_table(con, type);
            }
        };
        button3.addActionListener(action3);

        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                tt.select_RESTAURANT_MENU_table(con, type);
            }
        };
        button4.addActionListener(action4);

        ActionListener action5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                tt.select_MENU_table(con, type);
            }
        };
        button5.addActionListener(action5);

        ActionListener action6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                administrator.administrator_Main(con, type);
            }
        };
        button6.addActionListener(action6);
    }
}



