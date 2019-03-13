//start page project detail.
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;
public class frm2 extends JFrame implements  ActionListener,MouseMotionListener{
	JLabel img,img1,nxt,ttl,nme;
	JComboBox jc1;
	Font f,f1,f2;
	JButton nxt1;
	Container c;
	JTextField jf;
	File p1,p2;
	public frm2 ()
	{
	 c=getContentPane();
	 c.setLayout(null);
	 c.setBackground(Color.green);
	 setTitle("page 1");
	 setSize(1300,1000);
	 ttl=new JLabel("Automatic Reminder system");
	 f=new Font("Times new roman",Font.CENTER_BASELINE,60);
	 
	 ttl.setFont(f);
	// ttl.setBackground(Color.red);
	 ttl.setForeground(Color.ORANGE);
	 ttl.setBounds(506,109,800,75);
	 c.add(ttl);
	 nxt=new JLabel("goto log in page");
	 f2=new Font("ms serif",Font.BOLD,35);
	 	 nxt.setFont(f2);
	 	nxt.setForeground(Color.green);
	 nxt.setBounds(617,493,250,50);
	 c.add(nxt);
	 nxt1=new JButton("Go");
	 
		nxt1.setFont(f2);
		nxt1.setForeground(Color.BLUE);
		nxt1.setBounds(690,575,80,40);
     c.add(nxt1);
     nxt1.addActionListener(this);
	 nme=new JLabel("By  Amit prajapati");
	 nme.setForeground(Color.white);
	 	 nme.setFont(f2);
	 nme.setBounds(200,650,300,40);
	 c.add(nme);
	 //p2= new File(""); 
	  p1= new File("20160329_083737.jpg");
	System.out.println(p1.getAbsolutePath());
	ImageIcon ii=new ImageIcon(p1.getAbsolutePath());
		
		//ImageIcon ii=new ImageIcon("F:/frames/src/Penguins.jpg");
		
		img=new JLabel(ii);
		img.setBounds(50, 337,400,300);
		c.add(img);
		ImageIcon ii1=new ImageIcon("C:/Users/lenovo/workspace/framework/2a6f830a3662d27d733fee1c231865a1_large_f6GNaGk.jpg");
		img1=new JLabel(ii1);
		img1.setBounds(0,0,1400,1000);
		c.add(img1);
		jf=new JTextField(30);
		jf.setBounds(400,100,80,30);
		c.add(jf);
		addMouseMotionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==nxt1)
		{
			setVisible(false);
         			new frm1();
		}
	}
	int x=0,y=0;
	public void mouseMoved(MouseEvent me)
	{
		x=me.getX();
		y=me.getY();
		jf.setText("x="+x+",y="+y);
		
	}
	public void mouseDragged(MouseEvent me)
	{
		
	}
	

   public static void main(String ar[])
   {
	   new frm2();
   }
}
