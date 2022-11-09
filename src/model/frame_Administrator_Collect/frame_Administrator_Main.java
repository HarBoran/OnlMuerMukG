package model.frame_Administrator_Collect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Administrator_Main extends JFrame {
    public void frame_Administrator_Main_Mathod(Connection con, String type) {

        setSize(300, 400);
        setTitle("Administrator_Main");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel setting_mod = new JLabel("관리자 모드입니다");
        JLabel select = new JLabel("사용할 기능을 선택하세요.");
        JButton button1 = new JButton("1. 음식점 관리");
        JButton button2 = new JButton("2. 유저 및 평점 관리");
        JButton button3 = new JButton("3. 음식테이블 관리");
        JButton button4 = new JButton("4. 데이터베이스 확인");
        JButton button5 = new JButton("5. 로그아웃");

        setting_mod.setBounds(10, 00, 500, 40);
        select.setBounds(10, 20, 500, 40);
        button1.setBounds(10, 50, 150, 30);
        button2.setBounds(10, 90, 150, 30);
        button3.setBounds(10, 130, 150, 30);
        button4.setBounds(10, 170, 150, 30);
        button5.setBounds(10, 210, 150, 30);

        add(setting_mod);
        add(select);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        setVisible(true);
        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Set_Restaurant_Select fsrs = new frame_Set_Restaurant_Select();
                fsrs.frame_Set_Restaurant_Select_Method(con, type);
            }
        };
        button1.addActionListener(action1);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Set_User_Select fsus = new frame_Set_User_Select();
                fsus.fram_Set_User_Select_Mathod(con, type);
            }
        };
        button2.addActionListener(action2);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Set_Food_Table fsft = new frame_Set_Food_Table();
                fsft.frame_Set_Food_Table_Mathod(con, type);
            }
        };
        button3.addActionListener(action3);

        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_test_Table ftt = new frame_test_Table();
                ftt.frame_test_Table_Mathod(con, type);
            }
        };
        button4.addActionListener(action4);

        ActionListener action5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //메인 프레임
            }
        };
        button5.addActionListener(action5);
    }
}



