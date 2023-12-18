package View;

import java.awt.Color;

import javax.swing.*;

public class LoginPage extends JFrame {
	
	
	
	public LoginPage()
	{
		super("Login Page");
		getContentPane().setBackground(Color.white);
		setSize(640, 300);
		setLayout(null);
		
		JLabel lusername = new JLabel("Username");
		lusername.setBounds(300, 20, 100, 20);
		add(lusername);
		
		JTextField username = new JTextField();
	    username.setBounds(400, 20, 150, 20);
	    add(username);
		
	    JLabel lpassword = new JLabel("Password");
        lpassword.setBounds(300, 60, 100, 20);
        add(lpassword);
        
       
        JTextField password = new JTextField();
        password.setBounds(400, 20, 150, 20);
        add(password);
		
		
        setLocation(400, 200);
        setVisible(true);
		
	}
	public static void main(String[] args) {
 		new LoginPage();

 	}
}
