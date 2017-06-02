package com.bit.frame.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class MemberLogin extends JFrame {
	JPanel jPan1=new JPanel();
     JTextField txtId=new JTextField(10);
     JPasswordField txtpw=new JPasswordField(10);
     
     
     public MemberLogin(){
    	 
    	 int lableAlign=JLabel.RIGHT;
    	 Color backColor=Color.LIGHT_GRAY;
    	 
    	 
    	 setTitle("Login");
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 JLabel frmTitle=new JLabel("·Î±×ÀÎ");
    	 Font font =new Font("Gulim",Font.BOLD,20);
    	 frmTitle.setFont(font);
    	 frmTitle.setHorizontalAlignment(JLabel.CENTER);
    	 add(frmTitle,"North");
    	 
    	 jPan1.setLayout(new GridLayout(5,3));
    	 jPan1.setBackground(backColor);
    	 
    	 jPan1.add(new JLabel());
     }
     
     
     public static void main(String[] args) {
    	 new MemberLogin();
     }
}
