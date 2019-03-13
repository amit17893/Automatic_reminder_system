//show all data.
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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class show1 extends JFrame implements  ActionListener,MouseMotionListener {
	JLabel dt,tk,user,img;
	JTextField dt1,tk1,user1;
	Container c;
	JButton nxt,back;
	Font f,f2;
	ResultSet rs;
	Connection con;
	PreparedStatement ps;
    String ds1,s1,s2;
    File p1;
    boolean fg;
    Color ab,ab1;
	public show1()
	{  
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/detail","root","");
		ps=con.prepareStatement("select * from detail where username =?");
		ps.setString(1, frm1.txt);
		rs=ps.executeQuery();

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
		 c.setBackground(Color.blue);
		 setTitle("all data");
		 setSize(981,731);
		 dt=new JLabel("Date");
		 f=new Font("ms serif",Font.BOLD,40);
		 dt.setForeground(Color.red);
		 dt.setFont(f);
		 dt.setBounds(30,100,400,50);
		 c.add(dt);
		 tk=new JLabel("Task");
		  tk.setFont(f);
		 tk.setBounds(240,100,300,50);
		 ab=new Color(255,0,0);	 
			tk.setForeground(ab);
		 c.add(tk);
		 user=new JLabel("USER");
		  user.setFont(f);
		 user.setBounds(570,100,300,50);
		 user.setForeground(ab);
		 c.add(user);
		 dt1=new JTextField(30);
		dt1.setBounds(42, 204, 80, 30);
		ab1=new Color(0,153,0);
		dt1.setForeground(ab1);
		c.add(dt1);
		tk1=new JTextField(30);
		tk1.setBounds(257, 204, 200, 60);
		tk1.setForeground(ab1);
		c.add(tk1);
		user1=new JTextField(30);
		user1.setBounds(567, 204, 100, 30);
		user1.setForeground(ab1);
		c.add(user1);
		nxt=new JButton("next>>");
		 f2=new Font("Ms serif",Font.BOLD,20);
		nxt.setFont(f2);
		nxt.setForeground(ab);
		nxt.setBounds(217,424,100,30);
		nxt.addActionListener(this);
		c.add(nxt);
		back=new JButton("Back");
				back.setFont(f2);
				back.setForeground(ab);
		back.setBounds(488,424,80,30);
		back.addActionListener(this);
		c.add(back);
		addMouseMotionListener(this);
		p1= new File("download-nature-wallpaper.jpg");
		ImageIcon ii=new ImageIcon(p1.getAbsolutePath());
		img=new JLabel(ii);
		img.setBounds(0,0,1480,710);
		c.add(img);
		 setVisible(true);
	}
		 int x=0,y=0;
		 public void mouseMoved(MouseEvent me)
		 {
		 	x=me.getX();
		 	y=me.getY();
		 	//tk1.setText("x="+x+",y="+y);
		 	}
		 int i=0;
		 public void mouseDragged(MouseEvent me)
		 {
		 	
		 }

		 public void actionPerformed(ActionEvent ae)
		 {  
			 			
		 if(ae.getSource()==back)
		 {
			 setVisible(false);
			 new frm1();
		 }
		
		 if(ae.getSource()==nxt)
		 {  
				try{
						fg=rs.next();
				    if(fg){
					//if(frm1.txt.equals(ds1))
					  i++;
					    ds1=rs.getString(1);
						s1=rs.getString(2);
						s2=rs.getString(3);
						dt1.setText(s1);
						tk1.setText(s2);
						user1.setText(ds1);
				    }
			if(!fg)
				{   if(i==0)
					JOptionPane.showMessageDialog(this, "no any record");
				else
					JOptionPane.showMessageDialog(this, "no more record");
                    nxt.setEnabled(false);				
				
				}
				
				}catch(SQLException sqe)
				{
					sqe.printStackTrace();
				}
		 }
			} 
			
		 public static void main(String ar[])
		 {
			 new show1();
		 }

}