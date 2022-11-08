package model;

import javax.swing.*;

public class AdminFrame extends JFrame implements FrameSize {

    public AdminFrame() {

        setTitle("어드민 플레임");
        setSize(FrameWidth, FrameHeight);
        setLocationRelativeTo(null); //화면 가운데 배치
        setResizable(false); //크기 변경 불가능
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우의 x를 누르면 종료
        getContentPane().setLayout(null); //레이아웃 설정


    }
}
