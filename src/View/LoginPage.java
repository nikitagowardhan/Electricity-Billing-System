package View;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import Controller.EbsDao;

public class LoginPage extends JFrame implements ActionListener  {
	
	Choice logginin;
	JButton login, cancel, signup;
	JTextField username,password;
	
	public LoginPage()
	{
		super("Login Page");
		getContentPane().setBackground(Color.white);
		setSize(640, 300);
		setLayout(null);
		
		JLabel lusername = new JLabel("Username");
		lusername.setBounds(300, 20, 100, 20);
		add(lusername);
		
		 username = new JTextField();
	    username.setBounds(400, 20, 150, 20);
	    add(username);
		
	    JLabel lpassword = new JLabel("Password");
        lpassword.setBounds(300, 60, 100, 20);
        add(lpassword);
        
       
        password = new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);
        
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(300, 100, 100, 20);
        add(loggininas);
        
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i2));
        login.setBounds(330, 160, 100, 20);
        login.setForeground(Color.BLUE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(450, 160, 100, 20);
        cancel.setForeground(Color.BLUE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i6));
        signup.setBounds(380, 200, 100, 20);
        signup.setForeground(Color.BLUE);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        
        setLocation(400, 200);
        setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if (e.getSource() == login)
		 { // Code for handling login button click
			String uname = username.getText();
			String pass = password.getText();
			String choice= logginin.getSelectedItem();
			
			try
			{
               EbsDao eb = new EbsDao();
			    
			    java.sql.Connection c = eb.getConnect();
			    Statement s = c.createStatement();
			    String q = "Select *from login where username ='"+uname+"' and password ='"+pass+"'and usertype ='"+choice+"' ";
			  //we have to store all data into ResultSet
			    ResultSet rs = s.executeQuery(q);
			    
			    if(rs.next())
			    {
			    	setVisible(false);
			    	new Project();
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(this, "Invalid Login");
			    	username.setText("");
			    	password.setText("");
			    }
			    }
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		 } 
		 else if (e.getSource() == cancel) 
		 {
	            setVisible(false);
	        } else if (e.getSource() == signup)
	        {
	            setVisible(false);
	            
	            new SignUpPage();
		 }
		
	}
	
	public static void main(String[] args) {
 		new LoginPage();

 	}

	
	
}
