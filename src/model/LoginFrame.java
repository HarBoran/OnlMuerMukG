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

        Datasource data = new Datasource();

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

                String user_id = tf.getText();
                if (user_id.equals("Admin")) {
                    //로비의 뽑기시스템
                    PrintFrame printframe = new PrintFrame();
                    printframe.OutputFrame("Admin",con, "Admin");
                    setVisible(false);
                    //어드민 메뉴버튼 추가

                }else {
                StringBuilder USER_CHECK = new StringBuilder("SELECT ").append(data.COLUMN_LOGIN_ID)
                        .append(" from ").append(data.TABLE_USER)
                        .append(" where ").append(data.COLUMN_LOGIN_ID)
                        .append(" = '").append(user_id).append("'");
                try {
                    Statement st = con.createStatement();
                    if (st.executeQuery(String.valueOf(USER_CHECK)).next()) {
                        StringBuilder OWNER_CHECK = new StringBuilder("SELECT ").append(data.COLUMN_OWNER_ID)
                                .append(" from ").append(data.TABLE_RESTAURANT)
                                .append(" where ").append(data.COLUMN_OWNER_ID)
                                .append(" = '").append(user_id).append("'");

                        try {
                            ResultSet results = st.executeQuery(String.valueOf(OWNER_CHECK));
                            if (results.next()) {
                                //로비의 뽑기시스템
                                PrintFrame printframe = new PrintFrame();
                                printframe.OutputFrame(user_id,con, "Owner");
                                setVisible(false);
                                //owner.owner_main(user_id,con);//오너 메뉴버튼 추가

                            }else{
                                //로비의 뽑기시스템
                                PrintFrame printframe = new PrintFrame();
                                printframe.OutputFrame(user_id,con, "User");
                                setVisible(false);
                                //User.USER_MAIN(user_id,con);
                            }

                        }catch(SQLException ex){
                            System.out.println(data.ERROR + ex.getMessage());
                            ex.printStackTrace();
                        }

                    }
                } catch (SQLException se) {
                    System.out.println(data.ERROR + se.getMessage());
                    se.printStackTrace();
                }
            }
            }
        };

        jb.addActionListener(jb_action);

        setVisible(true);
    }
}
