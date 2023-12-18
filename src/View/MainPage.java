package View;

import java.awt.Image;

import javax.swing.*;


public class MainPage extends JFrame implements Runnable {
	
	Thread t;
	
	public MainPage()
	{
		super("Main Page");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/elect.jpg"));
		Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		add(l1);
		setVisible(true);
		 int x = 1;
	        for (int i = 2; i < 600; i+=4, x+=1) {
	            setSize(i + x, i);
	            setLocation(700 - ((i + x)/2), 400 - (i/2));
	            try 
	            {
	                Thread.sleep(5);
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
	   t= new Thread();
	   t.start();
	   setVisible(true);
	       
}
	@Override
	public void run() {
		try{
			Thread.sleep(7000);
			setVisible(false);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	 public static void main(String[] args) {
 		new MainPage();

 	}
	
}