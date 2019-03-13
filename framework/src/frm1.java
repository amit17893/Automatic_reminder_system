// login page(activate when click on go button. 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class  frm1 extends JFrame implements ActionListener,MouseMotionListener{
JLabel j1,user,passwd,img,cse;
JTextField jt1;
TextField jt2;
JButton jb1,jb2,nw,jb3,jr;
Font f,f1,f2,f3,f4;
JMenuBar mbr;
JMenu file;
JMenuItem n,o,e;
String s1,s2,ds1,ds2;
File p1;
static String txt;
Container c;
boolean fg;
ResultSet rs;
Connection con;
PreparedStatement ps;
public frm1()
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
		
	}catch(ClassNotFoundException ce)
	{
		ce.printStackTrace();
	}
	catch(SQLException ce)
	{
		ce.printStackTrace();
	}
	
	c=getContentPane();
	c.setLayout(null);
	c.setBackground(Color.ORANGE);
	setTitle("project");
	setSize(981,731);
	j1=new JLabel("automatic reminder system");
	f=new Font("Ms serif",Font.CENTER_BASELINE,50);
	j1.setFont(f);
	j1.setForeground(Color.BLUE);
	j1.setBounds(600, 100, 600, 60);
	
	user=new JLabel("Enter User");
	f2=new Font("Ms serif",Font.BOLD,20);
	user.setFont(f2);
	user.setForeground(Color.red);
	user.setBounds(100, 300, 100, 30);
	
	jt1=new JTextField(30);
	jt1.setBounds(232,293,80, 30);
	jt1.setForeground(Color.orange);
	cse=new JLabel("(enter valid name)");
	f3=new Font("Ms serif",Font.BOLD,20);
	cse.setFont(f3);
	cse.setForeground(Color.green);
	cse.setBounds(330, 290, 180, 30);
	
	passwd=new JLabel("Password");
	passwd.setFont(f2);
	passwd.setForeground(Color.red);
	passwd.setBounds(100, 350, 80, 30);
	
	jt2=new TextField(30);
	jt2.setBounds(234,350, 80, 30);
	jt2.setEchoChar('*');
	jt2.setForeground(Color.orange);
	jt2.setBackground(Color.BLACK);
	jb1=new JButton("Log In");
	f4=new Font("Ms serif",Font.ITALIC,30);
	jb1.setFont(f4);
	jb1.setForeground(Color.red);
	jb1.setBounds(190,470, 120, 40);
	jb1.addActionListener(this);
	jb2=new JButton("Back");
	jb2.setForeground(Color.red);
	jb2.setFont(f4);
	jb2.setBounds(360, 600, 100, 30);
	jb2.addActionListener(this);
	jb3=new JButton("Log out");
	jb3.setForeground(Color.red);
	jb3.setFont(f4);
	jb3.setBounds(374, 470, 150, 40);
	jb3.addActionListener(this);
	jb3.setEnabled(false);
	c.add(jb3);
	nw=new JButton("New user");
	nw.setFont(f4);
	nw.setForeground(Color.red);
	nw.setBounds(590, 470, 180, 40);
	c.add(nw);
	nw.addActionListener(this);
	jr=new JButton("Notification");
	jr.setFont(f4);
	jr.setForeground(Color.red);
	jr.setBounds(490,600,190,30);
	jr.addActionListener(this);
	c.add(jr);
	mbr=new JMenuBar();
	mbr.setFont(f4);
	mbr.setBounds(0,0,30,10);
	//mbr.setForeground(Color.red); not work
	mbr.setBackground(Color.red);
	file=new JMenu("menu");
	file.setForeground(Color.green);
	file.setBackground(Color.yellow);
	n=new JMenuItem("Show all record");
	n.setForeground(Color.red);
	o=new JMenuItem("add new task");
	o.setForeground(Color.red);
	o.addActionListener(this);
	n.addActionListener(this);
	e=new JMenuItem("Exit");
	e.setForeground(Color.green);
	file.add(n);file.add(o);file.add(e);
	mbr.add(file);
	mbr.setBounds(0, 0, 50, 30);
	n.setEnabled(false);
	o.setEnabled(false);
	e.setEnabled(true);
	e.addActionListener(this);
	c.add(j1);
	c.add(user);
	c.add(passwd);
	c.add(jt1);
	c.add(jt2);
	c.add(jb1);
	c.add(mbr);
	c.add(cse);
	c.add(jb2);
	p1= new File("nature-wallpapers-1.jpg");
	ImageIcon ii=new ImageIcon(p1.getAbsolutePath());
	img=new JLabel(ii);
	img.setBounds(0,0,1380,710);
	c.add(img);
	
	addMouseMotionListener(this);
	setVisible(true);
	}
int x=0,y=0;
public void mouseMoved(MouseEvent me)
{
	x=me.getX();
	y=me.getY();
	//jt1.setText("x="+x+",y="+y);
	}  
public void mouseDragged(MouseEvent me)
{
	
}

public void actionPerformed(ActionEvent ae)
  {  
	if(ae.getSource()==jr)
	{
		setVisible(false);
		new date();
	}
	if(ae.getSource()==e)
	{
		setVisible(false);
	}
	if(ae.getSource()==jb3)
	{  nw.setEnabled(true);
		n.setEnabled(false);
		o.setEnabled(false);
		jb1.setEnabled(true);
		jb3.setEnabled(false);
		nw.setEnabled(true);
		JOptionPane.showMessageDialog(this, "log out successfully");
	}
	
	if(ae.getSource()==nw)
	{
		setVisible(false);
	   new newuser();
	}
	if(ae.getSource()==jb2)
		{
		setVisible(false);
			new frm2();
		}
	if(ae.getSource()==o)
		{
		setVisible(false);
		 new task1();	
		}
	if(ae.getSource()==n)
	{
		setVisible(false);
	 new show1();	
	}
	if(ae.getSource()==jb1)
	{
		int fg1=0;
		try{
		s1=jt1.getText();
		s2=jt2.getText();
		String s1=jt1.getText();
			char c1[]=s1.toCharArray();
			String s2=jt2.getText();
 			char c2[]=s2.toCharArray();
 		if(c1.length==0)	
 			JOptionPane.showMessageDialog(this, "user name field empty");
 		else if(c2.length==0)
 			JOptionPane.showMessageDialog(this, "password field empty");
 		else
 		{
		ps=con.prepareStatement("select * from student");//name 
		rs=ps.executeQuery();
		while(rs.next())
		{
			ds1=rs.getString(2);
			ds2=rs.getString(3);
			if(s1.equals(ds1)&&s2.equals(ds2))
			{
				n.setEnabled(true);
				o.setEnabled(true);
				nw.setEnabled(false);
				txt=s1;
	         			fg1=1;
	         			nw.setEnabled(false);
	         			jb3.setEnabled(true);
	         			JOptionPane.showMessageDialog(this, "login success");
	         			jb1.setEnabled(false);
				break;
			}
			else
			{
				fg1=0;
			}
			
		}
		if(fg1==0)
			JOptionPane.showMessageDialog(this, "no record found");
}
		}catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
			} 
	}
	public static void main(String ar[])
	{
	 new frm1();	
	}
 
}