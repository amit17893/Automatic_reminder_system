//task to add. by the add to task
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class task1 extends JFrame implements MouseMotionListener,ActionListener
{
	JLabel dt,mn,yr,tk,img;
	JTextArea tk1;
	Container c;
	JButton b,b1;
	Font f,f1,f2;
	String s1,s2,s3;
	File p1;
	Connection con;
	String query;
	PreparedStatement pst;
	boolean fg;
	JComboBox dt1,mn1,yr1;
	
  public task1()
  { int i;
	  try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/detail","root","");
			
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
	  c.setBackground(Color.GRAY);
	  setTitle("data sheet");
	 setSize(1200,600);
	 
	  dt=new JLabel("Date");
		f=new Font("Ms serif",Font.BOLD,30);
		dt.setFont(f);
		dt.setBounds(65, 155, 200, 40);
		c.add(dt);
		mn=new JLabel("Month");
		mn.setFont(f);
		mn.setBounds(65, 250, 200, 40);
		c.add(mn);
		yr=new JLabel("year");
		yr.setFont(f);
		yr.setBounds(65, 350, 200, 40);
		c.add(yr);
		dt1=new JComboBox();
		for(i=1;i<=31;i++)
		dt1.addItem(""+i);
		dt1.setBounds(222, 163, 70, 20);
		c.add(dt1);
		mn1=new JComboBox();
		for(i=1;i<=12;i++)
		mn1.addItem(""+i);
		mn1.setBounds(222, 260, 70, 20);
		c.add(mn1);
		yr1=new JComboBox();
		for(i=2017;i<=2030;i++)
		yr1.addItem(""+i);
		yr1.setBounds(222, 360, 90, 20);
		c.add(yr1);
		tk1=new JTextArea(10,30);
		tk1.setBounds(602, 240, 500, 200);
		c.add(tk1);
		tk=new JLabel("Task");
		f1=new Font("Ms serif",Font.BOLD,40);
		tk.setFont(f1);
		tk.setBounds(589, 126, 100, 40);
		c.add(tk);
		b=new JButton("Enter");
		 f2=new Font("Ms serif",Font.BOLD,20);
		b.setFont(f2);
		b.setBounds(578,539,150,30);
		b.addActionListener(this);
		c.add(b);
		b1=new JButton("Back");
		 f2=new Font("Ms serif",Font.BOLD,20);
		b1.setFont(f2);
		b1.setBounds(800,539,150,30);
		b1.addActionListener(this);
		c.add(b1);
		p1= new File("20160131_130003.jpg");
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
   //	yr1.setText("x="+x+",y="+y);
  	}
  public void mouseDragged(MouseEvent me)
 	{
 		
 	}
  public void actionPerformed(ActionEvent ae)
  {
		if(ae.getSource()==b1)
		{
			setVisible(false);
			new frm1();
		}
  	if(ae.getSource()==b)
  	{ // int i,j=0,k=0,l=0;
  		try
  	{  
  				/*String s=dt1.getText();
  		  		char c[]=s.toCharArray();
  		  		int temp=Integer.parseInt(s);
  		  		for(i=0;i<c.length;i++)
  		  		{
  		  			if(!(Character.isDigit(c[i])&&(temp>0&&temp<32)))
  		  			{j=1;
  		  				break;
  		  			}
  		  		}
  		  	if(j==1)
  		  	JOptionPane.showMessageDialog(this, "enter valid date");
  		  	String s5=mn1.getText();
  		    char c2[]=s5.toCharArray();
  		    int temp2=Integer.parseInt(s5);
  		    for(i=0;i<c2.length;i++)
  		   {
  		    if(!(Character.isDigit(c2[i])&&(temp2>0&&temp2<32)))
  		    {
  		    	k=1;
  		    	break;
  		    }
  		}
  		   if(k==1&&j==0)
  		   JOptionPane.showMessageDialog(this, "enter valid month");
  		 String s6=yr1.getText();
	  		char c3[]=s6.toCharArray();
	  		int temp3=Integer.parseInt(s6);
	  		for(i=0;i<c3.length;i++)
	  		{
	  			if(!(Character.isDigit(c3[i])&&(temp3>1000&&temp3<3000)))
	  			{l=1;
	  				break;
	  			}
	  			}
	  	if(l==1&&j==0&&k==0)
	  	JOptionPane.showMessageDialog(this, "enter valid year");
  					
  if(j==0&&k==0&&l==0)*/
  {

  			s1=frm1.txt;//main log inpage.
  			s2=dt1.getSelectedItem()+"/"+mn1.getSelectedItem()+"/"+yr1.getSelectedItem();
  			s3=tk1.getText();
  	query="insert into detail values(?,?,?)";
  	pst=con.prepareStatement(query);
  	pst.setString(1, s1);
  	pst.setString(2, s2);
  	pst.setString(3, s3);
  	int fg=pst.executeUpdate();
  	if(fg==1)
  	{
  	JOptionPane.showMessageDialog(this, "record inserted");	
  	}
  }
	  		
  }	catch(SQLException sqe)
  		{
  			sqe.printStackTrace();
  		}

  	  
  	}
  }

 public static void main(String ar[])
 {
	 new task1();
 }
  
}


