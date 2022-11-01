package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PrintFrame {
    boolean b11 = true;
    boolean b12;
    boolean b13;
    boolean b14;
    boolean b15;
    boolean b16;
    boolean b21 = true;
    boolean b22;
    boolean b23;
    boolean b24;
    boolean b25;
    boolean b26;
    boolean b27;
    boolean b28;
    boolean b31 = true;
    boolean b32;
    boolean b33;
    boolean b34;
    boolean b35;
    boolean b36;
    boolean b37;
    boolean b38 = true;
    boolean b41;
    boolean b42;
    boolean b43;
    boolean b51;

//    부모 프레임 생성 및 설정
//   > 자식 컴포넌트 생성 및 설정
//   > 자식 컴포넌트 이벤트 정의
//   > 부모 프레임에 자식 컴포넌트 추가
    public void JFrame() {

        JFrame frm = new JFrame();
        frm.setTitle("오늘 뭐 먹지");
        frm.setSize(430, 600);
        frm.setLocationRelativeTo(null); //화면 가운데 배치
        frm.setResizable(false); //크기 변경 불가능
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우의 x를 누르면 종료
        frm.getContentPane().setLayout(null); //레이아웃 설정

        JButton btn11 = new JButton("전체");
        JButton btn12 = new JButton("한식");
        JButton btn13 = new JButton("일식");
        JButton btn14 = new JButton("양식");
        JButton btn15 = new JButton("중식");
        JButton btn16 = new JButton("기타");
        JButton btn21 = new JButton("전체");
        JButton btn22 = new JButton("쌀/밥");
        JButton btn23 = new JButton("면요리");
        JButton btn24 = new JButton("국/탕");
        JButton btn25 = new JButton("고기");
        JButton btn26 = new JButton("채식");
        JButton btn27 = new JButton("디저트");
        JButton btn28 = new JButton("기타");
        JButton btn31 = new JButton("최소");
        JButton btn32 = new JButton("100M");
        JButton btn33 = new JButton("300M");
        JButton btn34 = new JButton("500M");
        JButton btn35 = new JButton("1KM");
        JButton btn36 = new JButton("5KM");
        JButton btn37 = new JButton("10KM");
        JButton btn38 = new JButton("최대");
        JButton btn41 = new JButton("많이 찾는");
        JButton btn42 = new JButton("평점 좋은");
        JButton btn51 = new JButton("음식점 추천");
        JLabel txt1=new JLabel();

        //setBounds(가로위치, 세로위치, 가로길이, 세로길이);
        btn11.setBounds(30, 120, 90, 30);
        btn11.setBackground(new Color(0,162,232));
        btn12.setBounds(120, 120, 90, 30);
        btn13.setBounds(210, 120, 90, 30);
        btn14.setBounds(30, 150, 90, 30);
        btn15.setBounds(120, 150, 90, 30);
        btn16.setBounds(210, 150, 90, 30);
        btn21.setBounds(30, 200, 90, 30);
        btn21.setBackground(new Color(0,162,232));
        btn22.setBounds(120, 200, 90, 30);
        btn23.setBounds(210, 200, 90, 30);
        btn24.setBounds(300, 200, 90, 30);
        btn25.setBounds(30, 230, 90, 30);
        btn26.setBounds(120, 230, 90, 30);
        btn27.setBounds(210, 230, 90, 30);
        btn28.setBounds(300, 230, 90, 30);
        btn31.setBounds(30, 280, 90, 30);
        btn31.setBackground(new Color(0,162,232));
        btn32.setBounds(120, 280, 90, 30);
        btn33.setBounds(210, 280, 90, 30);
        btn34.setBounds(300, 280, 90, 30);
        btn35.setBounds(30, 310, 90, 30);
        btn36.setBounds(120, 310, 90, 30);
        btn37.setBounds(210, 310, 90, 30);
        btn38.setBounds(300, 310, 90, 30);
        btn38.setBackground(new Color(0,162,232));
        btn41.setBounds(30, 360, 90, 30);
        btn42.setBounds(120, 360, 90, 30);
        btn51.setBounds(20, 420, 360, 100);
        btn51.setHorizontalAlignment(JLabel.CENTER); //텍스트 센터 표시 설정
        txt1.setBounds(30,45,400,30);

        ActionListener btn11_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b12 && !b13 && !b14 && !b15 && !b16)
                        return;
                    button.setBackground(null);
                    b11 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b11 = true;
                }
            }
        };
        btn11.addActionListener(btn11_action);

        ActionListener btn12_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b11 && !b13 && !b14 && !b15 && !b16)
                        return;
                    button.setBackground(null);
                    b12 = false;

                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b12 = true;
                }
            }
        };
        btn12.addActionListener(btn12_action);

        ActionListener btn13_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b11 && !b12 && !b14 && !b15 && !b16)
                        return;
                    button.setBackground(null);
                    b13 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b13 = true;
                }
            }
        };
        btn13.addActionListener(btn13_action);

        ActionListener btn14_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b11 && !b12 && !b13 && !b15 && !b16)
                        return;
                    button.setBackground(null);
                    b14 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b14 = true;
                }
            }
        };
        btn14.addActionListener(btn14_action);

        ActionListener btn15_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b11 && !b12 && !b13 && !b14 && !b16)
                        return;
                    button.setBackground(null);
                    b15 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b15 = true;
                }
            }
        };
        btn15.addActionListener(btn15_action);

        ActionListener btn16_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b11 && !b12 && !b13 && !b14 && !b15)
                        return;
                    button.setBackground(null);
                    b16 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b16 = true;
                }
            }
        };
        btn16.addActionListener(btn16_action);

        ActionListener btn21_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b22 && !b23 && !b24 && !b25 && !b26 && !b27 && !b28)
                        return;
                    button.setBackground(null);
                    b21 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b21 = true;
                }
            }
        };
        btn21.addActionListener(btn21_action);

        ActionListener btn22_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b21 && !b23 && !b24 && !b25 && !b26 && !b27 && !b28)
                        return;
                    button.setBackground(null);
                    b22 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b22 = true;
                }
            }
        };
        btn22.addActionListener(btn22_action);

        ActionListener btn23_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b21 && !b22 && !b24 && !b25 && !b26 && !b27 && !b28)
                        return;
                    button.setBackground(null);
                    b23 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b23 = true;
                }
            }
        };
        btn23.addActionListener(btn23_action);

        ActionListener btn24_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b21 && !b22 && !b23 && !b25 && !b26 && !b27 && !b28)
                        return;
                    button.setBackground(null);
                    b24 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b24 = true;
                }
            }
        };
        btn24.addActionListener(btn24_action);

        ActionListener btn25_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b21 && !b22 && !b23 && !b24 && !b26 && !b27 && !b28)
                        return;
                    button.setBackground(null);
                    b25 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b25 = true;
                }
            }
        };
        btn25.addActionListener(btn25_action);

        ActionListener btn26_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b21 && !b22 && !b23 && !b24 && !b25 && !b27 && !b28)
                        return;
                    button.setBackground(null);
                    b26 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b26 = true;
                }
            }
        };
        btn26.addActionListener(btn26_action);

        ActionListener btn27_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b21 && !b22 && !b23 && !b24 && !b25 && !b26 && !b28)
                        return;
                    button.setBackground(null);
                    b27 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b27 = true;
                }
            }
        };
        btn27.addActionListener(btn27_action);

        ActionListener btn28_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b21 && !b22 && !b23 && !b24 && !b25 && !b26 && !b27)
                        return;
                    button.setBackground(null);
                    b28 = false;
                }else {
                    button.setBackground(new Color(0, 162, 232));
                    b28 = true;
                }
            }
        };
        btn28.addActionListener(btn28_action);

        ActionListener btn51_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("음식점 추천"))
                    button.setText("다시 하기");
                button.setBackground(new Color(0, 81, 116));
                txt1.setText("레스트랑 목록 출력하기");
            }
        };
        btn51.addActionListener(btn51_action);



        //부모 프레임에다가 자식 컴포넌트 추가
        frm.getContentPane().add(btn11);
        frm.getContentPane().add(btn12);
        frm.getContentPane().add(btn13);
        frm.getContentPane().add(btn14);
        frm.getContentPane().add(btn15);
        frm.getContentPane().add(btn16);
        frm.getContentPane().add(btn21);
        frm.getContentPane().add(btn22);
        frm.getContentPane().add(btn23);
        frm.getContentPane().add(btn24);
        frm.getContentPane().add(btn25);
        frm.getContentPane().add(btn26);
        frm.getContentPane().add(btn27);
        frm.getContentPane().add(btn28);
        frm.getContentPane().add(btn31);
        frm.getContentPane().add(btn32);
        frm.getContentPane().add(btn33);
        frm.getContentPane().add(btn34);
        frm.getContentPane().add(btn35);
        frm.getContentPane().add(btn36);
        frm.getContentPane().add(btn37);
        frm.getContentPane().add(btn38);
        frm.getContentPane().add(btn41);
        frm.getContentPane().add(btn42);
        frm.getContentPane().add(btn51);
        frm.getContentPane().add(txt1);

        frm.setVisible(true); //부모 프레임이 보임
    }
}