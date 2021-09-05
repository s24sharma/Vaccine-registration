import javax.swing.*;
import java.awt.event.*;
import java.sql.*; 
import java.sql.*; 
import java.awt.Color;
import java.awt.*;

class Registration extends JToggleButton
{
	Registration()
	{		
	JTextField tf2;
			JFrame menu= new JFrame("VACCINE REGISTRATION");
			menu.getContentPane().setBackground(Color.white);
		
		
			JButton b1=new JButton("CITIZEN REGISTRATION");
			JButton b2=new JButton("REGISTRATION STATUS");
			JButton b3=new JButton("ADMIN LOGIN/REPORT");
			
			b1.setBounds(230,550,180,50);
			b1.setBackground(Color.decode("#0009ff"));
			b1.setForeground(Color.decode("#ffffff"));
			b2.setBounds(550,550,180,50);
			b2.setBackground(Color.decode("#0009ff"));
			b2.setForeground(Color.decode("#ffffff"));			
			b3.setBounds(870,550,180,50);
			b3.setBackground(Color.decode("#0009ff"));
			b3.setForeground(Color.decode("#ffffff"));
	
		b1.addActionListener(new Action());
		b2.addActionListener(new User());
		b3.addActionListener(new Admin());
	
		JLabel background;
		ImageIcon img=new ImageIcon("largest.jpg");
		background= new JLabel(img);
		background.setBounds(-5,-230,1390,900);
	
	menu.setSize(800,1200);
	menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
	menu.add(b1);menu.add(b2);menu.add(b3);
	
	menu.add(background);		
	menu.setLayout(null);
	menu.setVisible(true);
	
		
	}
	
	
	
	static class Admin implements ActionListener{

	 public void actionPerformed(ActionEvent e)
	{	
		
		JFrame f=new JFrame("ADMIN LOGIN");
		f.getContentPane().setBackground(Color.white);
		JLabel username=new JLabel("Username: ");
		username.setBounds(250,225,180,30);
		
		JTextField tff=new JTextField();
		tff.setBounds(325,225,180,30);
		
	   JPasswordField value = new JPasswordField();   
		JLabel pas=new JLabel("Password:");    
        pas.setBounds(250,290, 180,30);    
         value.setBounds(325,290,180,30); 
		 
		 JButton b1=new JButton("LOGIN");
		 b1.setBounds(300,350,120,30);
		 
		 JLabel background;
		ImageIcon img=new ImageIcon("covid19logo.jpg");
		background= new JLabel(img);
		background.setBounds(10,10,450,100);
		 
            f.add(value);  f.add(tff); f.add(username);f.add(pas);f.add(b1);f.add(background);
			f.setSize(800,1200);
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			f.setLayout(null);
				f.setVisible(true);
		 b1.addActionListener(new ActionListener(){
		 
		  public void actionPerformed(ActionEvent e1)
	{	
		
		String name=tff.getText();
		String passw=value.getText();
		if(name.equals("") && passw.equals(""))
		{
			
		
		b1.setVisible(false);
		username.setVisible(false);
		pas.setVisible(false);
		tff.setVisible(false);
		value.setVisible(false);
		
			
		JLabel l1=new JLabel("Aadhar number");
		l1.setBounds(280,130,120,30);
		f.add(l1);
		JTextField tf1=new JTextField();
		tf1.setBounds(440,130,150,30);
		f.add(tf1);
		JButton b2=new JButton("Check Status");
		 b2.setBounds(660,130,150,30);
		 f.add(b2);
		 
		 JLabel image;
		ImageIcon img=new ImageIcon("india.jpg");
		image= new JLabel(img);
		image.setBounds(850,-150,600,900);
		 
		 f.setSize(800,1200);
	     f.setExtendedState(JFrame.MAXIMIZED_BOTH);
			f.add(image);	
		f.setVisible(true);
		 b2.addActionListener(new ActionListener(){
		 
		  public void actionPerformed(ActionEvent e1)
	{
		try{	

				
		JLabel l2,l3,l4,l5,dob,address,status;
		JLabel tf2,tf3,tf4,tf5,tfdob,tfaddress;
		
		/*Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6411225","sql6411225","3wM3ePkxvv");
	*/
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3333/sonoo","root","toor");	
		
		
		l2=new JLabel("Name:");
		l2.setBounds(280,220,90,30);
		
		tf2=new JLabel();
		tf2.setBounds(350,220,170,30);
		
		l3=new JLabel("Gender: ");
		l3.setBounds(590,205,100,60);

		tf3=new JLabel();
		tf3.setBounds(680,220,170,30);

		l4=new JLabel("City:");
		l4.setBounds(280,275,90,30);
		
		tf4=new JLabel();
		tf4.setBounds(350,275,170,30);
		
		l5=new JLabel("Mobile no:");
		l5.setBounds(590,260,100,60);
		
		tf5=new JLabel();
		tf5.setBounds(680,275,140,30);
		
		dob=new JLabel("DOB:");
		dob.setBounds(280,330,90,30);
		
		tfdob=new JLabel();
		tfdob.setBounds(350,330,120,30);
		
		address=new JLabel("Address:");
		address.setBounds(590,318,100,60);
		
		tfaddress=new JLabel();
		tfaddress.setBounds(680,332,120,30);
		
		status=new JLabel("Vaccine status:");
		status.setBounds(420,400,170,25);
		
		JLabel st=new JLabel();
		st.setBounds(560,395,90,30);
		st.setForeground(Color.blue);
		
		JLabel print=new JLabel("If person has not been vaccinated, schedule it by changing date. If person is now vaccinated click complete. ");
		print.setBounds(190,460,800,60);
		print.setForeground(Color.RED);
		
		JButton b5=new JButton("complete");
		b5.setBounds(160,550,120,30);
		
		JLabel sch = new JLabel();
		sch=new JLabel("OR\t\t\t           Enter date to schedule: ");
		sch.setBounds(360,550,200,25);
		
		JButton b4=new JButton("Confirm schedule");
		b4.setBounds(700,550,170,30);
		
		JTextField sc=new JTextField("2021-10-05");
		sc.setBounds(570,550,90,30);
		
		JLabel image;
		ImageIcon img=new ImageIcon("india.jpg");
		image= new JLabel(img);
		image.setBounds(850,-100,600,900);
		
		f.getContentPane().setBackground(Color.white);
			
		f.add(image);
		f.add(b2); f.add(l3);f.add(l4);f.add(tf4);f.add(dob);f.add(tfdob);f.add(tf3);f.add(tf2);f.add(l3);
		f.add(l1); f.add(tf1);f.add(l2); f.add(tf2);f.add(l5);f.add(tf5);f.add(address);f.add(tfaddress);
		f.add(status);f.add(st);f.add(b4);f.add(b5);f.add(print);f.add(sc);
		f.setSize(800,1200);f.add(sch);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		f.setVisible(true);
		
		
		String Aadhar=tf1.getText();
		
		PreparedStatement p=con.prepareStatement("select * from registration where Aadhar=? ");
		
		p.setString(1, Aadhar);

		ResultSet r=p.executeQuery();
		
		if(r.next())
		{
			tf2.setText(r.getString("name"));
			tf3.setText(r.getString("gender"));tf4.setText(r.getString("city"));tf5.setText(r.getString("mobile"));
			tfdob.setText(r.getString("dob"));tfaddress.setText(r.getString("address"));st.setText(r.getString("status"));
			
		}
		else
		{
		
			JOptionPane.showMessageDialog(null,"aadhar number not registered");
		}
		
		 b5.addActionListener(new ActionListener(){
		 
		  public void actionPerformed(ActionEvent e1)
		  {
		try
		{
			/*Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6411225","sql6411225","3wM3ePkxvv");
	*/
	Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3333/sonoo","root","toor");
	
		String status ="complete";
		PreparedStatement p=con.prepareStatement("update registration set status='complete' where Aadhar=?");		
					JOptionPane.showMessageDialog(null,"updated");

		f.setVisible(false);
		p.setString(1,Aadhar);
		p.executeUpdate();
		
				}catch(Exception e)
		{ 
		System.out.println(e);}
	}
		 
	
	}
			 );
			 
			  b4.addActionListener(new ActionListener(){
		 
		  public void actionPerformed(ActionEvent e1)
		  {
		try
		{
			/*Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6411225","sql6411225","3wM3ePkxvv");
	*/
	Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3333/sonoo","root","toor");
	
		
		sc.setVisible(true);
		String sch=sc.getText();

		PreparedStatement p=con.prepareStatement("update registration set status=? where Aadhar=?");		
					
		p.setString(1,sch);
		p.setString(2,Aadhar);
		p.executeUpdate();
		f.add(sc);
		f.setVisible(true);
		JOptionPane.showMessageDialog(null,"Successfully scheduled");
		f.setVisible(false);
				}catch(Exception e)
		{ 
		System.out.println(e);}
	}
		 
	
	}
	
			 );
	
			}catch(Exception e)
		{ 
		System.out.println(e);}

		}
		 }
		 );
		}
		else
			JOptionPane.showMessageDialog(null,"wrong username or password");
			 
	}
	
		 }
	);
	}
	}
	
	




	
	static class User implements ActionListener{

	 public void actionPerformed(ActionEvent e)
	{
		
		JFrame f=new JFrame("VACCINE REGISTERATION");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel l2=new JLabel("Aadhar number");
		l2.setBounds(250,125,150,30);
		
		JLabel image;
		ImageIcon img=new ImageIcon("india.jpg");
		image= new JLabel(img);
		image.setBounds(650,-200,600,900);
		
		JTextField tf=new JTextField("");
		tf.setBounds(375,125,180,30);
		
	   JTextField value = new JTextField("yyyy-mm-dd");   
		JLabel l1=new JLabel("Password (DOB)");    
        l1.setBounds(250,175, 150,30);    
         value.setBounds(375,175,180,30); 
		 
		
		 
		 JButton b1=new JButton("Check Status");
		 b1.setBounds(290,240,120,30);
		 
		 f.getContentPane().setBackground(Color.white);
            f.add(value);  f.add(l1); f.add(tf);f.add(l2);f.add(b1);f.add(image);
			
			
				
			f.setLayout(null);
			f.setVisible(true);
			
			
	 b1.addActionListener(new ActionListener(){
		 
		  public void actionPerformed(ActionEvent e1)
	{	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3333/sonoo","root","toor");
	
		
		String aadhar=tf.getText();
	
		String dob=value.getText();
		
		PreparedStatement p=con.prepareStatement("select * from registration where Aadhar=? and dob=?");
		
		p.setString(1, aadhar);
		p.setString(2,dob);
		ResultSet r=p.executeQuery();
		
		if(r.next())
		{
			
			String s1=r.getString("name");
			String s2=r.getString("status");
			JOptionPane.showMessageDialog(null,"\nName:  "+s1+"\n\nVaccine status:  "+s2+"\n\n\n");
			

		}
		else
		{	JOptionPane.showMessageDialog(null,"Invalid aadhar or dob");
			value.setText("");
			tf.setText("");
				}
				
		}catch(Exception e)
		{ 
		System.out.println(e);}
	}
		 
	
	}
	);
	}}
		
	
	static class Action implements ActionListener{

	 public void actionPerformed(ActionEvent e)
	{		
		
	JLabel l1,l2,l3,l4,l5,dob,address;
		JTextField tf1,tf2,tf3,tf4,tf5,tfdob,tfaddress;
		JButton b1,b2;

		
		JFrame f=new JFrame("VACCINE REGISTRATION");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JLabel background;
		ImageIcon img=new ImageIcon("covid19logo.jpg");
		background= new JLabel(img);
		background.setBounds(10,10,450,100);
		
		l1=new JLabel("Aadhar number*");
		l1.setBounds(490,70,120,30);
		
		tf1=new JTextField();
		tf1.setBounds(640,70,170,30);
		
		l2=new JLabel("Full name*");
		l2.setBounds(490,122,90,30);
		
		tf2=new JTextField();
		tf2.setBounds(640,122,170,30);
		
		l3=new JLabel("Gender ");
		l3.setBounds(490,165,100,60);


		JRadioButton r1=new JRadioButton("A) Male");    
		JRadioButton r2=new JRadioButton("B) Female");    
		r1.setBounds(640,170,100,30);    
		r2.setBounds(640,190,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2); 


		l4=new JLabel("Enter city");
		l4.setBounds(490,235,170,30);
		
		tf4=new JTextField();
		tf4.setBounds(640,235,170,30);
		
		l5=new JLabel("Enter mobile no.*");
		l5.setBounds(490,280,170,30);
		
		tf5=new JTextField();
		tf5.setBounds(640,280,170,30);
		
		dob=new JLabel("Enter DOB*");
		dob.setBounds(490,330,170,30);
		
		tfdob=new JTextField("yyyy-mm-dd");
		tfdob.setBounds(640,330,170,30);
		
		address=new JLabel("Enter Address");
		address.setBounds(490,380,190,30);
		
		tfaddress=new JTextField();
		tfaddress.setBounds(640,380,170,45);
		
		b1=new JButton("SUBMIT");
		b1.setBounds(590,470,80,30);				

		f.getContentPane().setBackground(Color.white);
		f.add(r1);f.add(r2); f.add(l3);f.add(l4);f.add(tf4);f.add(dob);f.add(tfdob);f.add(b1);
		f.add(l1); f.add(tf1);f.add(l2); f.add(tf2);f.add(l5);f.add(tf5);f.add(address);f.add(tfaddress);
		f.add(background);
		
		f.setLayout(null);
		f.setVisible(true);
		
	 b1.addActionListener(new ActionListener(){
		 
		  public void actionPerformed(ActionEvent e1)
	{	
		try
		{
			/*Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6411225","sql6411225","3wM3ePkxvv");
	*/
	Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3333/sonoo","root","toor");
		
		String aadhar=tf1.getText();
		String name=tf2.getText();
		String gender="Male";
		if(r1.isSelected()) 
         gender="Male";
		else if(r2.isSelected()) 
         gender="Female";
	
		String city=tf4.getText();
		String mobile=tf5.getText();
		String dob=tfdob.getText();
		String address=tfaddress.getText();
		String status ="in process";
		PreparedStatement p=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?)");
		
		p.setString(1, aadhar);
		p.setString(2,name);p.setString(3,gender);p.setString(4,city);p.setString(5,mobile);p.setString(6,dob);p.setString(7,address);p.setString(8,status);
		p.executeUpdate();
		
		
		JOptionPane.showMessageDialog(null,"Successfully Registered");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(false);
		
		}catch(Exception e)
		{ 
				JOptionPane.showMessageDialog(null,"wrong credentials "+ e);

		System.out.println(e);}
	}
		 
	
	}
	);
	}}
	
	
	public static void main(String a[])
	{
		new Registration();
	}

}