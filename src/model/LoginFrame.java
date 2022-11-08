package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginFrame extends JFrame implements FrameSize {

    String id;

    public LoginFrame(Connection con) {

        Datasource datasource = new Datasource();

        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        setTitle("오늘 뭐 먹지");
        setSize(FrameWidth, FrameHeight);
        setLocationRelativeTo(null); //화면 가운데 배치
        setResizable(false); //크기 변경 불가능
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우의 x를 누르면 종료
        getContentPane().setLayout(null); //레이아웃 설정

        JLabel jl = new JLabel("아이디를 입력하세요");
        TextField tf = new TextField(12);
        JButton jb = new JButton("Login");

        jl.setBounds(120, 350,400, 30);
        tf.setBounds(120, 400, 400, 30);
        jb.setBounds(220,500,200,40);

        add(tf);
        add(jl);
        add(jb);

        ActionListener jb_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();

                String UserId = tf.getText();
                if (UserId.equals("Admin")) {

                    PrintFrame printframe = new PrintFrame();
                    printframe.OutputFrame(datasource.getConn(), UserId);
                    setVisible(false);
                }
            }
        };

        jb.addActionListener(jb_action);

        setVisible(true);
    }
}
