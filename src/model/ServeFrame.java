package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServeFrame{

    public void menu(){

        JFrame sfrm = new JFrame();
        sfrm.setSize(300, 400);
        sfrm.setLocationRelativeTo(null); //화면 가운데 배치
        sfrm.setResizable(false); //크기 변경 불가능
        sfrm.getContentPane().setLayout(null); //레이아웃 설정

        TextField tf = new TextField("아이디 입력", 12);
        JLabel jl = new JLabel("텍스트를 출력중입니다");
        JButton jb = new JButton("매뉴닫기");

        tf.setBounds(120, 120, 90, 30);
        jl.setBounds(120, 160,90, 30);
        jb.setBounds(220,0,80,40);

        sfrm.add(tf);
        sfrm.add(jl);
        sfrm.add(jb);

        ActionListener jb_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                sfrm.setVisible(false);
            }
        };
        jb.addActionListener(jb_action);

        sfrm.setVisible(true);

    }
}
