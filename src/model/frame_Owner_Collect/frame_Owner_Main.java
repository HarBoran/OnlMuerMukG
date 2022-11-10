package model.frame_Owner_Collect;

import model.Datasource;
import model.frame_Administrator_Data_Collect.frame_Menu_Add;
import model.frame_Administrator_Data_Collect.frame_Menu_Delete;
import model.owner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class frame_Owner_Main extends JFrame {
    public void frame_Owner_Main_Mathod(String owner_name, Connection con,String type) {
        Datasource data = new Datasource();
        owner ow =  new owner();

        StringBuilder restaurant_name_str = new StringBuilder("Select ").append(data.COLUMN_RESTAURANT_NAME)
                .append(" , ").append(data.COLUMN_RESTAURANT_ID)
                .append(" from ").append(data.TABLE_RESTAURANT)
                .append(" Where ").append(data.COLUMN_OWNER_ID).append(" = '").append(owner_name).append("'");
        String restaurant_name = null;
        int restaurant_id = 0;
        try {
            Statement st = con.createStatement();
            restaurant_name = st.executeQuery(String.valueOf(restaurant_name_str)).getString(data.COLUMN_RESTAURANT_NAME);
            restaurant_id = st.executeQuery(String.valueOf(restaurant_name_str)).getInt(data.COLUMN_RESTAURANT_ID);
        }catch (SQLException e){
            System.out.println(data.ERROR + e.getMessage());
            e.printStackTrace();
        }
            setSize(300, 400);
        setTitle("Owner_Main");
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel setting_mod = new JLabel(restaurant_name + "음식점 주인 모드입니다.");
        JButton button1 = new JButton("1. 메뉴 보기");
        JButton button2 = new JButton("2. 음식 추가");
        JButton button3 = new JButton("3. 음식 제거");
        JButton button4 = new JButton("4. 음식점 이름 바꾸기");
        JButton button5 = new JButton("5. 닫기");

        setting_mod.setBounds(10, 00, 500, 40);
        button1.setBounds(10, 50, 150, 30);
        button2.setBounds(10, 90, 150, 30);
        button3.setBounds(10, 130, 150, 30);
        button4.setBounds(10, 170, 150, 30);
        button5.setBounds(10, 210, 150, 30);

        add(setting_mod);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        setVisible(true);

        String finalRestaurant_name = restaurant_name;
        int finalRestaurant_id = restaurant_id;
        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                owner.owner_MENU_table(owner_name, finalRestaurant_id, con, type);
            }
        };
        button1.addActionListener(action1);

        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Menu_Add fma = new frame_Menu_Add();
                fma.frame_Menu_Add_Method(finalRestaurant_name, finalRestaurant_id, con, type);
            }
        };
        button2.addActionListener(action2);

        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame_Menu_Delete fmd = new frame_Menu_Delete();
                fmd.frame_Menu_Delete_Method(finalRestaurant_name, finalRestaurant_id, con, type);
            }
        };
        button3.addActionListener(action3);

        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                owner.change_RESTAURANT_NAME_CHECK(owner_name, finalRestaurant_id,con,type);

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



