package model;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintFrame {
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
        JButton btn41 = new JButton("전체");
        JButton btn42 = new JButton("많이 찾는");
        JButton btn43 = new JButton("평점 좋은");
        JButton btn51 = new JButton("음식점 추천");
        JLabel txt1=new JLabel("0");

        //setBounds(가로위치, 세로위치, 가로길이, 세로길이);
        btn11.setBounds(30, 120, 90, 30);
        btn12.setBounds(120, 120, 90, 30);
        btn13.setBounds(210, 120, 90, 30);
        btn14.setBounds(30, 150, 90, 30);
        btn15.setBounds(120, 150, 90, 30);
        btn16.setBounds(210, 150, 90, 30);
        btn21.setBounds(30, 200, 90, 30);
        btn22.setBounds(120, 200, 90, 30);
        btn23.setBounds(210, 200, 90, 30);
        btn24.setBounds(300, 200, 90, 30);
        btn25.setBounds(30, 230, 90, 30);
        btn26.setBounds(120, 230, 90, 30);
        btn27.setBounds(210, 230, 90, 30);
        btn28.setBounds(300, 230, 90, 30);
        btn31.setBounds(30, 280, 90, 30);
        btn32.setBounds(120, 280, 90, 30);
        btn33.setBounds(210, 280, 90, 30);
        btn34.setBounds(300, 280, 90, 30);
        btn35.setBounds(30, 310, 90, 30);
        btn36.setBounds(120, 310, 90, 30);
        btn37.setBounds(210, 310, 90, 30);
        btn38.setBounds(300, 310, 90, 30);
        btn41.setBounds(30, 360, 90, 30);
        btn42.setBounds(120, 360, 90, 30);
        btn43.setBounds(210, 360, 90, 30);
        btn51.setBounds(20, 420, 360, 100);
        btn51.setHorizontalAlignment(JLabel.CENTER); //텍스트 센터 표시 설정

        ActionListener btn11_action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getBackground().equals(new Color(0,162,232))){
                    button.setBackground(null);
                }else button.setBackground(new Color(0,162,232));
            }
        };
        btn11.addActionListener(btn11_action);

        //TODO 자식 컴포넌트 이벤트 정의
        ActionListener btn1_action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int count = Integer.parseInt(txt1.getText());
                count += 1;
                txt1.setText(String.valueOf(count));
            }
        };
        btn11.addActionListener(btn1_action);

        ActionListener btn2_action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                txt1.setText("0");
            }
        };
        btn21.addActionListener(btn2_action);

        frm.getContentPane().add(btn11); //부모 프레임에다가 자식 컴포넌트 추가
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
        frm.getContentPane().add(btn43);
        frm.getContentPane().add(btn51);

        frm.setVisible(true); //부모 프레임이 보임
    }
}
