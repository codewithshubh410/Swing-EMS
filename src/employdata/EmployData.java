package employdata;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmployData implements ActionListener {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	JButton btn;
	static PreparedStatement st;
	static Connection con;
	private JButton btn1;
	private JButton btn2;
	private JLabel lb4;
	private JTextField t4;
	private JButton btn4;
	private JButton btn3 ;
	
	
	public EmployData()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Employe Registration");
		l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		l1.setBounds(137, 34, 247, 27);
		frame.getContentPane().add(l1);
		
		JLabel lb1 = new JLabel("Name :");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb1.setBounds(55, 163, 56, 27);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Email :");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb2.setBounds(55, 201, 86, 27);
		frame.getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("Contact :");
		lb3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb3.setBounds(54, 239, 87, 26);
		frame.getContentPane().add(lb3);
		
		t1 = new JTextField();
		t1.setBounds(161, 163, 223, 27);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(161, 203, 223, 27);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(161, 239, 223, 27);
		frame.getContentPane().add(t3);
		t3.setColumns(10);
		
		 btn = new JButton("SUBMIT");
		btn.setBackground(new Color(224, 255, 255));
		btn.setForeground(new Color(0, 0, 0));
		btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn.setBounds(10, 296, 101, 32);
		btn.addActionListener(this);
		frame.getContentPane().add(btn);
		
		btn1 = new JButton("RESET");
		btn1.setBackground(new Color(224, 255, 255));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBounds(121, 297, 86, 30);
		btn1.addActionListener(this);
		frame.getContentPane().add(btn1);
		
		btn2 = new JButton("FETCH");
		btn2.setBackground(new Color(224, 255, 255));
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setBounds(217, 296, 101, 32);
		btn2.addActionListener(this);
		frame.getContentPane().add(btn2);
		
		lb4 = new JLabel("Id   :");
		lb4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb4.setBounds(55, 138, 66, 14);
		frame.getContentPane().add(lb4);
		
		t4 = new JTextField();
		t4.setBounds(161, 125, 223, 27);
		frame.getContentPane().add(t4);
		t4.setColumns(10);
		
		btn4 = new JButton("DELETE");
		btn4.setBackground(new Color(224, 255, 255));
		btn4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn4.setBounds(331, 297, 96, 30);
		btn4.addActionListener(this);
		frame.getContentPane().add(btn4);
		
		btn3 = new JButton("UPDATE");
		btn3.setBackground(new Color(224, 255, 255));
		btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn3.setBounds(442, 297, 96, 30);
		btn3.addActionListener(this);
		frame.getContentPane().add(btn3);
		frame.setVisible(true);
	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn)
			{
				try
				{
				st=con.prepareStatement("insert into Employe values(?,?,?,?)");
				int id=Integer.parseInt(t4.getText());
				String nm=t1.getText();
				String ml=t2.getText();
				String ct=t3.getText();
				
				st.setInt(1,id);
				st.setString(2,nm);
				st.setString(3,ml);
				st.setString(4,ct);
				
				int n=st.executeUpdate();
				if(n>0)
				{
					System.out.println("Insertion Success");	
				}
				else
				{
					System.out.println("Insertion Fail");
				}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
			else if(e.getSource()==btn1)
				{
					String s1=" ";
					String s2=" ";
					String s3=" ";
					String s4=" ";
					t1.setText(s1);
					t2.setText(s2);
					t3.setText(s3);
					t4.setText(s4);
				}
				
			else if(e.getSource()==btn2)
				{
					try
					{
					st=con.prepareStatement("select * from Employe where Id=?");
				
					String str=t4.getText();
					int id=Integer.parseInt(str);
					st.setInt(1,id);
					ResultSet rs=st.executeQuery();
					if(rs.next())
					{
					int id1=rs.getInt(1);
					String id2=String.valueOf(id1);
					String name=rs.getString(2);
					String email=rs.getString(3);
					String cont=rs.getString(4);
					
					
					t4.setText(id2);
					t1.setText(name);
					t2.setText(email);
					t3.setText(cont);
					
					}
					
					}
					catch(Exception e3)
					{
						System.out.println(e3);
					}
				}
				
				else if(e.getSource()==btn4)
					{
					try
					{
						st=con.prepareStatement("delete from Employe where Id=?");
						String de=t4.getText();
						int deleteid=Integer.parseInt(de);
						st.setInt(1, deleteid);
						
						int n=st.executeUpdate();
						if(n>0)
						{
							System.out.println("Delete Successfully");	
						}
						else
						{
							System.out.println(" Fail to delete");
						}
					}
					catch(Exception e4)
					{
						System.out.println(e4);
					}
				}

				else if(e.getSource()==btn3)
					  {
					try
					{
						st=con.prepareStatement("update Employe set Name=?,Email=?,contact=? where Id=?");
						int id=Integer.parseInt(t4.getText());
						String nm=t1.getText();
						String ml=t2.getText();
						String ct=t3.getText();
						
						st.setString(1,nm);
						st.setString(2,ml);
						st.setString(3,ct);
						st.setInt(4,id);
						int n=st.executeUpdate();
						if(n>0)
						{
							System.out.println("Update Successfully");	
						}
						else
						{
							System.out.println(" Fail to Update");
						}
					}
					catch(Exception e5)
					{
						System.out.println(e5);
					}
			}
		
	}
	}
