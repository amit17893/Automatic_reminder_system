//new user creation code.
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class newuser extends JFrame implements  ActionListener,MouseMotionListener{
	JLabel nm,us,pwd,mb,tb,img;
	JTextField nm1,us1,pwd1,mb1;
	Container d;
	JButton ct,ex;
	Font f,f1;
	String s1,s2,s3,s4,query,ds1;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	File p1;


 public  newuser()
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
		
	 d=getContentPane();
	 d.setLayout(null);
	 d.setBackground(Color.blue);
	 setTitle("crete new");
	 setSize(981,731);
	 tb=new JLabel("Input your Details");
	 f1=new Font("ms serif",Font.BOLD,40);
	 tb.setFont(f1);
	 tb.setBounds(30,100,400,50);
	 d.add(tb);
	 nm=new JLabel("Name");
	 f=new Font("Ms serif",Font.BOLD,30);
	 nm.setFont(f);
	 nm.setBounds(59,201,300,40);
	 d.add(nm);
	 us=new JLabel("user name");
	  us.setFont(f);
	 us.setBounds(59,250,300,40);
	 d.add(us);
	 pwd=new JLabel("new Password");
	  pwd.setFont(f);
	 pwd.setBounds(59,300,300,40);
	 d.add(pwd);
	 mb=new JLabel("mobile no");
	  mb.setFont(f);
	 mb.setBounds(59,350,300,40);
	 d.add(mb);
	 nm1=new JTextField(30);
	nm1.setBounds(275, 210, 80, 30);
	d.add(nm1);
	us1=new JTextField(30);
	us1.setBounds(275, 260, 80, 30);
	d.add(us1);
	pwd1=new JTextField(30);
	pwd1.setBounds(275,310, 80, 30);
	d.add(pwd1);
	mb1=new JTextField(30);
	mb1.setBounds(275,360, 80, 30);
	addMouseMotionListener(this);
	d.add(mb1);
    ct=new JButton("CREAT");
    ct.setFont(f);
	ct.setBounds(200,420,150,30);
	d.add(ct);
	ct.addActionListener(this);
	ex=new JButton("Back");
    ex.setFont(f);
	ex.setBounds(400,420,150,30);
	d.add(ex);
	ex.addActionListener(this);
	p1= new File("1080p-HD-Wallpapers-9.jpg");
	ImageIcon ii=new ImageIcon(p1.getAbsolutePath());
	img=new JLabel(ii);
	img.setBounds(0,0,1380,710);
	d.add(img);
	setVisible(true);
	
 }
 public void mouseDragged(MouseEvent me)
	{
		
	}
 int x=0,y=0;
 public void mouseMoved(MouseEvent me)
	{
	 x=me.getX();
	y=me.getY();
	//mb1.setText("x="+x+",y="+y);
	
		
	}
	
 public void actionPerformed(ActionEvent ae)
 { int g=0;
 	if(ae.getSource()==ct)
 	{ int i,j=0,k=0;
 	 boolean l;
 		try{
 			String s=nm1.getText();
 			char c[]=s.toCharArray();
 			for(i=0;i<c.length;i++)
 			{
 				if(!(Character.isLetter(c[i])))
 				{	j=1;
 				break;
 				}
 				}
 			String s1=us1.getText();
 			char c1[]=s1.toCharArray();
 			String s2=pwd1.getText();
 			char c2[]=s2.toCharArray();
 			String s5=mb1.getText();
 			char d[]=s5.toCharArray();
 			if(c.length==0)
 				{
 				JOptionPane.showMessageDialog(this, "no text in name");
 				l=false;
 				}
 			else if(j==1)
 				{
 				JOptionPane.showMessageDialog(this, "only character in name");
 				l=false;
 				}
 			else if(c1.length==0)
 				{
 				JOptionPane.showMessageDialog(this, "no text in username");
 				l=false;
 				}
 			else if(c2.length==0)
 				{
 				JOptionPane.showMessageDialog(this, "no text in password");
 				l=false;
 				}
 			else if(d.length==0)
 				{
 				JOptionPane.showMessageDialog(this, "no text in mobile");
 				l=false;
 				}
 			else
 			{	l=true;
 			for(i=0;i<d.length;i++)
 			{
 				if(!(Character.isDigit(d[i])))
 				{	k=1;
 				break;
 				}
 				}
 			if(k==1)//j==0
 				JOptionPane.showMessageDialog(this, "only digit in mobile");
 			if(!(d.length==10)&&k==0)//j==0
 				JOptionPane.showMessageDialog(this, "only 10 digit ");
 			}
 			if(k==0&&d.length==10&&l)//j==0
 			{
 			pst=con.prepareStatement("select * from student");
 			rs=pst.executeQuery();
 			s2=us1.getText();
 			while(rs.next())
 			{	
 				ds1=rs.getString(2);
 			if(ds1.equals(s2))
 			g++;
 			}
 			if(g==0)
 			{
 			s1=nm1.getText();
 			//s2=us1.getText();
 			s3=pwd1.getText();
 			s4=mb1.getText();
 	query="insert into student values(?,?,?,?)";
 	pst=con.prepareStatement(query);
 	pst.setString(1, s1);
 	pst.setString(2, s2);
 	pst.setString(3, s3);
 	pst.setString(4, s4);
 	int fg=pst.executeUpdate();
 	if(fg==1)
 	JOptionPane.showMessageDialog(this, "record inserted");	
 			}
 	  
 			if(g!=0)
 				JOptionPane.showMessageDialog(this, "slect any other username");
 	
 			}
 		}catch(SQLException sqe)
 		{
 			sqe.printStackTrace();
 		}
		
 	}
 	if(ae.getSource()==ex)
 	{  
 		setVisible(false);
 		new frm1();
 	}
}
 public static void main(String ar[])
 {
	 new newuser();
 }
}