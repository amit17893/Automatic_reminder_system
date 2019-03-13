import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;

public class frm3 extends JFrame implements  ActionListener,MouseMotionListener{
JLabel j1,user,passwd,img;
JTextField jt1;
TextField jt2;
JButton jb1;
Font f;
JComboBox jc1;//drop down box.
JCheckBox cb1,cb2;//where only tick is enable.
List jl;
JMenuBar mbr;
JMenu file;
JMenuItem n,o,e;

Container c;
public frm3()
{
	c=getContentPane();
	c.setLayout(null);
	c.setBackground(Color.ORANGE);
	//c.set
	setTitle("demo frame");
	setSize(800,500);
	j1=new JLabel("LOGIN PAGE");
	f=new Font("Ms serif",Font.BOLD,30);
	j1.setFont(f);
	j1.setBounds(100, 100, 200, 40);
	
	user=new JLabel("Enter User");
	f=new Font("Ms serif",Font.BOLD,20);
	user.setFont(f);
	user.setBounds(50, 160, 100, 30);
	
	jt1=new JTextField(30);
	jt1.setBounds(200, 160, 70, 20);
	
	jc1=new JComboBox();
	jc1.addItem("c language");
	jc1.addItem("c++ language");
	jc1.addItem("Java language");
	jc1.setBounds(100, 190, 80, 30);
	
	cb1=new JCheckBox("operating system");
	
	cb1.setBounds(200, 190, 100, 30);
	File f1=new File("im1.jpg");
	System.out.println(f1.getAbsolutePath());
	ImageIcon ii=new ImageIcon(f1.getAbsolutePath());
	
	//ImageIcon ii=new ImageIcon("F:/frames/src/Penguins.jpg");
	
	img=new JLabel(ii);
	img.setBounds(350, 100, 200, 300);
	
	passwd=new JLabel("Password");
	passwd.setFont(f);
	passwd.setBounds(50, 250, 80, 30);
	
	jt2=new TextField(30);
	jt2.setBounds(200, 250, 80, 20);
	
	jb1=new JButton("Log In");
	jb1.setFont(f);
	jb1.setBounds(200,300,150,30);

	mbr=new JMenuBar();
	file=new JMenu("File");//first show only File & on click give option added.
	
	n=new JMenuItem("New File");//option
	n.addActionListener(this);
	o=new JMenuItem("Open File");//option
	e=new JMenuItem("Exit File");//option
	file.add(n);file.add(o);file.add(e);
	mbr.add(file);
	mbr.setBounds(0, 0, 50, 30);
	
	jl=new List();
	jl.add("windows programming");//it will show in front of check box.
	jl.add("desktop programming");
	jl.setBounds(100,350, 170, 100);
	n.setEnabled(false);//use disable key.
	o.setEnabled(false);
	e.setEnabled(false);
	c.add(j1);//add on frame.same all.
	c.add(user);
	c.add(passwd);
	c.add(jt1);
	jt2.setEchoChar('*');//will show * on password.
	c.add(jt2);
	c.add(jb1);
	c.add(img);
	c.add(jc1);
	c.add(cb1);
	c.add(mbr);
	c.add(jl);
	jb1.addActionListener(this);
	addMouseMotionListener(this);
	setVisible(true);//to activate frame.
	}
int x=0,y=0;
public void mouseMoved(MouseEvent me)
{
	x=me.getX();
	y=me.getY();
	jt1.setText("x="+x+",y="+y);
	}
public void mouseDragged(MouseEvent me)
{
	}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==jb1)
	{
		String u=jt1.getText();
		String p=jt2.getText();
		if(u.equals("rohit")&&p.equals("rohit"))
		{
		n.setEnabled(true);
		o.setEnabled(true);
		e.setEnabled(true);
		//new login();
		}
	}
	if(ae.getSource()==n)
	{
		new login();
	}
}
public static void main(String ar[])
{
	new frm3();
}
}
