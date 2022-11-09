package model.frame_Collect;

import model.Datasource;
import model.administrator_data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class frame_Select_This_Restaurant_menu{

    public void frame_Select_This_Restaurant_menu_method(String restaurant_Name,int restaurant_Id, Connection con){
        JFrame JF = new JFrame();
        administrator_data ad = new administrator_data();
        JF.setSize(300, 400);
        JF.setTitle("Select_This_Restaurant_menu");
        JF.setLocationRelativeTo(null);
        JF.setResizable(false);
        JF.getContentPane().setLayout(null);

        ad.select_this_restaurant_menu(restaurant_Id,con,JF);

        JButton button = new JButton("돌아가기");
        button.setBounds(150,300,100,30);

        JF.add(button);
        JF.setVisible(true);
        ActionListener ancestor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JF.dispose();
                frame_Restaurant_Setting frs = new frame_Restaurant_Setting();
                frs.frame_Restaurant_Setting_Method(restaurant_Name, restaurant_Id, con);
            }
        };
        button.addActionListener(ancestor);
    }

}
