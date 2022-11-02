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
    boolean b36= true;
    boolean b41;

//    부모 프레임 생성 및 설정
//   > 자식 컴포넌트 생성 및 설정
//   > 자식 컴포넌트 이벤트 정의
//   > 부모 프레임에 자식 컴포넌트 추가
    public void JFrame() {

        JFrame frm = new JFrame();
        frm.setTitle("오늘 뭐 먹지");
        frm.setSize(340, 555);
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
        JButton btn31 = new JButton("300M");
        JButton btn32 = new JButton("500M");
        JButton btn33 = new JButton("1KM");
        JButton btn34 = new JButton("5KM");
        JButton btn35 = new JButton("10KM");
        JButton btn36 = new JButton("최대");
        JButton btn41 = new JButton("음식점 추천");
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
        btn24.setBounds(30, 230, 90, 30);
        btn25.setBounds(120, 230, 90, 30);
        btn26.setBounds(210, 230, 90, 30);
        btn27.setBounds(30, 260, 90, 30);
        btn28.setBounds(120, 260, 90, 30);
        btn31.setBounds(30, 310, 90, 30);
        btn32.setBounds(120, 310, 90, 30);
        btn33.setBounds(210, 310, 90, 30);
        btn34.setBounds(30, 340, 90, 30);
        btn35.setBounds(120, 340, 90, 30);
        btn36.setBounds(210, 340, 90, 30);
        btn36.setBackground(new Color(0,162,232));
        btn41.setBounds(40, 400, 250, 100);
        btn41.setHorizontalAlignment(JLabel.CENTER); //텍스트 센터 표시 설정
        txt1.setBounds(30,30,400,30);

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
                    b12 = false;
                    b13 = false;
                    b14 = false;
                    b15 = false;
                    b16 = false;
                    btn12.setBackground(null);
                    btn13.setBackground(null);
                    btn14.setBackground(null);
                    btn15.setBackground(null);
                    btn16.setBackground(null);
                }
            }
        };
        btn11.addActionListener(btn11_action);

        ActionListener btn12_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if (b11) {
                    btn11.setBackground(null);
                    b11 = false;
                }
                if(button.getBackground().equals(new Color(0,162,232))) {
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
                if (b11) {
                    btn11.setBackground(null);
                    b11 = false;
                }
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
                if (b11) {
                    btn11.setBackground(null);
                    b11 = false;
                }
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
                if (b11) {
                    btn11.setBackground(null);
                    b11 = false;
                }
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
                if (b11) {
                    btn11.setBackground(null);
                    b11 = false;
                }
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
                    b22 = false;
                    b23 = false;
                    b24 = false;
                    b25 = false;
                    b26 = false;
                    b27 = false;
                    b28 = false;
                    btn22.setBackground(null);
                    btn23.setBackground(null);
                    btn24.setBackground(null);
                    btn25.setBackground(null);
                    btn26.setBackground(null);
                    btn27.setBackground(null);
                    btn28.setBackground(null);
                }
            }
        };
        btn21.addActionListener(btn21_action);

        ActionListener btn22_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if (b21) {
                    btn21.setBackground(null);
                    b21 = false;
                }
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
                if (b21) {
                    btn21.setBackground(null);
                    b21 = false;
                }
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
                if (b21) {
                    btn21.setBackground(null);
                    b21 = false;
                }
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
                if (b21) {
                    btn21.setBackground(null);
                    b21 = false;
                }
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
                if (b21) {
                    btn21.setBackground(null);
                    b21 = false;
                }
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
                if (b21) {
                    btn21.setBackground(null);
                    b21 = false;
                }
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
                if (b21) {
                    btn21.setBackground(null);
                    b21 = false;
                }
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

        ActionListener btn31_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b32 && !b33 && !b34 && !b35 && !b36)
                        return;
                    button.setBackground(null);
                    b31 = false;
                }else {
                    b31 = true;
                    b32 = false;
                    b33 = false;
                    b34 = false;
                    b35 = false;
                    b36 = false;
                    button.setBackground(new Color(0, 162, 232));
                    btn32.setBackground(null);
                    btn33.setBackground(null);
                    btn34.setBackground(null);
                    btn35.setBackground(null);
                    btn36.setBackground(null);
                }
            }
        };
        btn31.addActionListener(btn31_action);
        ActionListener btn32_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b31 && !b33 && !b34 && !b35 && !b36)
                        return;
                    button.setBackground(null);
                    b32 = false;
                }else {
                    b31 = false;
                    b32 = true;
                    b33 = false;
                    b34 = false;
                    b35 = false;
                    b36 = false;
                    btn31.setBackground(null);
                    button.setBackground(new Color(0, 162, 232));
                    btn33.setBackground(null);
                    btn34.setBackground(null);
                    btn35.setBackground(null);
                    btn36.setBackground(null);
                }
            }
        };
        btn32.addActionListener(btn32_action);
        ActionListener btn33_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b31 && !b32 && !b34 && !b35 && !b36)
                        return;
                    button.setBackground(null);
                    b33 = false;
                }else {
                    b31 = false;
                    b32 = false;
                    b33 = true;
                    b34 = false;
                    b35 = false;
                    b36 = false;
                    btn31.setBackground(null);
                    btn32.setBackground(null);
                    button.setBackground(new Color(0, 162, 232));
                    btn34.setBackground(null);
                    btn35.setBackground(null);
                    btn36.setBackground(null);
                }
            }
        };
        btn33.addActionListener(btn33_action);
        ActionListener btn34_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b31 && !b32 && !b33 && !b35 && !b36)
                        return;
                    button.setBackground(null);
                    b34 = false;
                }else {
                    b31 = false;
                    b32 = false;
                    b33 = false;
                    b34 = true;
                    b35 = false;
                    b36 = false;
                    btn31.setBackground(null);
                    btn32.setBackground(null);
                    btn33.setBackground(null);
                    button.setBackground(new Color(0, 162, 232));
                    btn35.setBackground(null);
                    btn36.setBackground(null);
                }
            }
        };
        btn34.addActionListener(btn34_action);
        ActionListener btn35_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b31 && !b32 && !b33 && !b34 && !b36)
                        return;
                    button.setBackground(null);
                    b35 = false;
                }else {
                    b31 = false;
                    b32 = false;
                    b33 = false;
                    b34 = false;
                    b35 = true;
                    b36 = false;
                    btn31.setBackground(null);
                    btn32.setBackground(null);
                    btn33.setBackground(null);
                    btn34.setBackground(null);
                    button.setBackground(new Color(0, 162, 232));
                    btn36.setBackground(null);
                }
            }
        };
        btn35.addActionListener(btn35_action);
        ActionListener btn36_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    if(!b31 && !b32 && !b33 && !b34 && !b35)
                        return;
                    button.setBackground(null);
                    b36 = false;
                }else {
                    b31 = false;
                    b32 = false;
                    b33 = false;
                    b34 = false;
                    b35 = false;
                    b36 = true;
                    btn31.setBackground(null);
                    btn32.setBackground(null);
                    btn33.setBackground(null);
                    btn34.setBackground(null);
                    btn35.setBackground(null);
                    button.setBackground(new Color(0, 162, 232));
                }
            }
        };
        btn36.addActionListener(btn36_action);

        ActionListener btn41_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("음식점 추천"))
                    button.setText("다시 하기");
                button.setBackground(new Color(0, 81, 116));
                txt1.setText("레스트랑 목록 출력하기");
            }
        };
        btn41.addActionListener(btn41_action);



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
        frm.getContentPane().add(btn41);
        frm.getContentPane().add(txt1);

        frm.setVisible(true); //부모 프레임이 보임
    }
}