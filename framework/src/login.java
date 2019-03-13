import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;

public class login extends JFrame{
JLabel j1,user,passwd,img;
Container c;
public login()
{
	c=getContentPane();
	c.setLayout(null);
	c.setBackground(Color.ORANGE);
	//c.set
	setTitle("demo frame");
	setSize(800,500);
	j1=new JLabel("LOGIN SUCCESS");
	Font f=new Font("Ms serif",Font.BOLD,20);
	j1.setFont(f);
	j1.setBounds(50, 100, 150, 40);
	c.add(j1);
	setVisible(true);
	}
public static void main(String ar[])
{
	new login();
}
}
