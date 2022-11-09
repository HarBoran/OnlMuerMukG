package model.frame_Administrator_Collect;

import model.administrator;
import model.frame_Administrator_Data_Collect.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Set_Food_Table extends JFrame {
    public void frame_Set_Food_Table_Mathod(Connection con, String type) {

        setSize(300, 400);
        setTitle("Set_Food_Table");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel setting_mod = new JLabel("음식 추가/제거 입니다.");
        JLabel select = new JLabel("사용할 기능을 선택하세요.");
        JButton button1 = new JButton("1. 음식 추가");
        JButton button2 = new JButton("2. 음식 수정");
        JButton button3 = new JButton("3.음식 제거");
        JButton button4 = new JButton("3. 이전으로 돌아가기");

        setting_mod.setBounds(10, 00, 500, 40);
        select.setBounds(10, 20, 500, 40);
        button1.setBounds(10, 50, 150, 30);
        button2.setBounds(10, 90, 150, 30);
        button3.setBounds(10, 130, 150, 30);
        button4.setBounds(10, 170, 150, 30);

        add(setting_mod);
        add(select);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        setVisible(true);
        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Food_Add ffa = new frame_Food_Add();
                ffa.frame_Food_Add_Method(con, type);
            }
        };
        button1.addActionListener(action1);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Food_Update ffu = new frame_Food_Update();
                ffu.frame_Food_Update_Method(con, type);
            }
        };
        button2.addActionListener(action2);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Food_Delete ffd = new frame_Food_Delete();
                ffd.frame_Food_Delete_Method(con, type);
            }
        };
        button3.addActionListener(action3);

        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                administrator.administrator_Main(con,type);
            }
        };
        button4.addActionListener(action4);

    }
}



