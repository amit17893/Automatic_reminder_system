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
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class date extends JFrame implements  ActionListener,MouseMotionListener {
	ResultSet rs,rs1;
	Connection con,con1;
	PreparedStatement ps,ps1;
	Container c;
	JLabel tk,img;
	Font f,f2;
	JTextArea tk1;
	JButton sd,bk;
	File p1;
	boolean fg;
	String nt;
	String s1[][]=new String[10][5];
	 int i;
 static String mn1,task,user;
	public date()
	{ boolean lp;
	    long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        System.out.println(date);
        String s=""+date;
        StringTokenizer st=new StringTokenizer(s,"-");
        String dt,mn,yr;
       	 yr=st.nextToken();
       	mn=st.nextToken();
       	dt=st.nextToken();
        int dt1=Integer.parseInt(dt);
        int mn1=Integer.parseInt(mn);
        int yr1=Integer.parseInt(yr);
        if(yr1%100==0)//for leap year.
        {if(yr1%400==0)
        	lp=true;
        else
        	lp=false;
        }
        else
        {if(yr1%4==0)
        	lp=true;
        else
        	lp=false;
        }
        if(dt1<28)
        dt1++;
        else if(dt1==28)
        {if(mn1==2&&lp)
        	dt1++;
        else if(mn1==2&&!lp)
        	{dt1=1;
           mn1++;
        	}
        else
        	dt1++;
        }
        else if(dt1==29)
        {if(mn1==2&&lp)
        	{dt1=1;
        	mn1++;
        	}
        else
        	dt1++;
        }
        else if(dt1==30)
        {if(mn1==4||mn1==6||mn1==9||mn1==11)
        	{dt1=1;
        	mn1++;
        	}
        else
        	dt1++;
        }
        else
        {if(mn1==12)
        	{yr1++;
        	mn1=1;
        	}
        else
        	mn1++;
        	dt1=1;
        }
        System.out.println(dt1+" "+mn1+" "+yr1);
         s=dt1+"/"+mn1+"/"+yr1;
         System.out.println(s);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/detail","root","");
		ps=con.prepareStatement("select * from detail where dt=?");
		ps.setString(1,s);
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
		 c.setBackground(Color.red);
		 setTitle("sms panel");
		 setSize(981,731);
		 tk=new JLabel("notification");
		 f=new Font("ms serif",Font.BOLD,50);
		 tk.setFont(f);
		 tk.setForeground(Color.RED);
		 tk.setBounds(284,88,400,50);
		 c.add(tk);
		tk1=new JTextArea(10,30);
		tk1.setBounds(262,161,500,200);
		c.add(tk1);
		sd=new JButton("send");
		 f2=new Font("Ms serif",Font.BOLD,20);
		sd.setFont(f2);
		sd.setForeground(Color.red);
		sd.setBounds(217,424,100,30);
		sd.addActionListener(this);
		c.add(sd);
		bk=new JButton("Back");
		 f2=new Font("Ms serif",Font.BOLD,20);
		bk.setFont(f2);
		bk.setForeground(Color.red);
		bk.setBounds(417,424,100,30);
		bk.addActionListener(this);
		c.add(bk);
		p1= new File("Free-Wallpaper-Nature-Scenes.jpg");
		ImageIcon ii=new ImageIcon(p1.getAbsolutePath());
		img=new JLabel(ii);
		img.setBounds(-17,0,1400,710);
		c.add(img);
		addMouseMotionListener(this);
		sd.addActionListener(this);
		 setVisible(true);
		
			 try{
    	
    	String s2="";
    	i=0;
while(rs.next())		
{		
   i++;
	    nt=rs.getString(1)+"    "+rs.getString(2)+"     "+rs.getString(3)+"\n";
		s1[i][1]=rs.getString(1);
		s1[i][2]=rs.getString(2);
		s1[i][3]=rs.getString(3);
		s2=s2+nt;
    }
tk1.setText(s2);
   if(i==0)
	{JOptionPane.showMessageDialog(this, "no any record");
		 sd.setEnabled(false);
		 tk1.setText("sorry no any record for send today.");
	}
else
	JOptionPane.showMessageDialog(this, "complete  record ready to send");				    
}catch(SQLException sqe)
{
	sqe.printStackTrace();
}		

	}
		int x=0,y=0;
		 public void mouseMoved(MouseEvent me)
		 {
		 	x=me.getX();
		 	y=me.getY();
		 	//tk1.setText("x="+x+",y="+y);
		 	}
		 public void mouseDragged(MouseEvent me)
		 {
		 	
		 }
		 public void actionPerformed(ActionEvent ae)
		 {  int j;
		 if(ae.getSource()==bk)
		 {
			 setVisible(false);
			 new frm1();
		 }
		 			 if(ae.getSource()==sd)
			 {try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con1=DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
					ps1=con1.prepareStatement("select * from student where username =?");
					System.out.println("value="+i);
					for(j=1;j<=i;j++)
					{
					ps1.setString(1,s1[j][1]);
					rs1=ps1.executeQuery();
					
                   while(rs1.next())
                   {  
                	   s1[j][4]=rs1.getString(4);
                	   JOptionPane.showMessageDialog(this, "sending to "+s1[j][1]);
                	   mn1=s1[j][4];
                	   task=s1[j][3];
                	   user=s1[j][1];
                	   new SmsSender1();
                	   j++;
                	   try
           			{
           			Thread.sleep(200);
           			}
           			catch(InterruptedException fg)
           			{
           				fg.printStackTrace();
           			}
                	   JOptionPane.showMessageDialog(this, "sms send comlete");
                   
                   }}
				}catch(ClassNotFoundException ce)
					{
						ce.printStackTrace();
					}
					catch(SQLException ce)
					{
						ce.printStackTrace();
					}

			 }
			 

		 }
	
	    public static void main(String ar[]) 
	    {
	    	new date();
	    	}
}