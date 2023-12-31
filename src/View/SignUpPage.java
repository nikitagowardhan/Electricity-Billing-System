package View;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;

import Controller.EbsDao;
public class SignUpPage extends JFrame implements ActionListener {

	 Choice accountType;
	 JTextField meter, username, name, password;
	 JButton create, back;
	 SignUpPage(){
	        
	        setBounds(450, 150, 700, 400);
	        getContentPane().setBackground(Color.WHITE);
	        setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(30, 30, 650, 300);
	        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
	        panel.setBackground(Color.WHITE);
	        panel.setLayout(null);
	        panel.setForeground(new Color(34, 139, 34));
	        add(panel);
	        
	        JLabel heading = new JLabel("Create Account As");
	        heading.setBounds(100, 50, 140, 20);
	        heading.setForeground(Color.GRAY);
	        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
	        panel.add(heading);
	        
	        accountType = new Choice();
	        accountType.add("Admin");
	        accountType.add("Customer");
	        accountType.setBounds(260, 50, 150, 20);
	        panel.add(accountType);
	        
	        JLabel lblmeter = new JLabel("Meter Number");
	        lblmeter.setBounds(100, 90, 140, 20);
	        lblmeter.setForeground(Color.GRAY);
	        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblmeter.setVisible(false);
	        panel.add(lblmeter);
	        meter = new JTextField();
	        meter.setBounds(260, 90, 150, 20);
	        meter.setVisible(false);
	        panel.add(meter);
	        
	        JLabel lblusername = new JLabel("Username");
	        lblusername.setBounds(100, 130, 140, 20);
	        lblusername.setForeground(Color.GRAY);
	        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
	        panel.add(lblusername);
	        username = new JTextField();
	        username.setBounds(260, 130, 150, 20);
	        panel.add(username);
	        
	        JLabel lblname = new JLabel("Name");
	        lblname.setBounds(100, 170, 140, 20);
	        lblname.setForeground(Color.GRAY);
	        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
	        panel.add(lblname);
	        name = new JTextField();
	        name.setBounds(260, 170, 150, 20);
	        panel.add(name);
	        
	        JLabel lblpassword = new JLabel("Password");
	        lblpassword.setBounds(100, 210, 140, 20);
	        lblpassword.setForeground(Color.GRAY);
	        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	        panel.add(lblpassword);
	        password = new JTextField();
	        password.setBounds(260, 210, 150, 20);
	        panel.add(password);
	        
	        create = new JButton("Create");
	        create.setBackground(Color.BLACK);
	        create.setForeground(Color.WHITE);
	        create.setBounds(140, 260, 120, 25);
	        create.addActionListener(this);
	        panel.add(create);

	        back = new JButton("Back");
	        back.setBackground(Color.BLACK);
	        back.setForeground(Color.WHITE);
	        back.setBounds(300, 260, 120, 25);
	        back.addActionListener(this);
	        panel.add(back);
	        
	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
	        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(415, 30, 250, 250);
	        panel.add(image);
	        
	        setVisible(true);
	 
	 }
	
	 @Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== create)
			{
			String acctype=accountType.getSelectedItem();
			String cusername = username.getText();
			String cname= name.getText();
			String cpassword = password.getText();
			String cmeter = meter.getText();
			
			try {
			    EbsDao eb = new EbsDao();
			    
			    java.sql.Connection c = eb.getConnect();
			    Statement s = c.createStatement();
			    String q = "insert into Login values('" + cmeter + "','" + cusername + "','" + cname + "','" + cpassword + "','" + acctype + "')";
			    s.executeUpdate(q); 
			    //for popup
			    JOptionPane.showMessageDialog(this, "Account Created Succesfully");
			    setVisible(false);
			    new LoginPage();
			   //c.close(); 
			} catch (ClassNotFoundException | SQLException e1) {
			    e1.printStackTrace();
			}
			}
			else if(e.getSource()==back)
			{
				setVisible(false);
				new LoginPage();
			}
		}
	
	public static void main(String[] args) {
		 new SignUpPage();
	}

 }

