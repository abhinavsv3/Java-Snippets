import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class TestDB implements ActionListener
{
	Frame f;
	Label bn,au,pr,title;
	TextField tbn,tau,tpr;
	Button qu,fi,la,ex,ne,pre,ins,cl,abs,rel;

	Connection c;
	Statement s;
	ResultSet rs;

	TestDB()
	{	
		f=new Frame("DB demo");
		f.setSize(700,700);
		f.setLayout(null);
		Font f1=new Font("Times New Roman",Font.BOLD,30);
		Font f2=new Font("Times New Roman",Font.BOLD,18);
		Font f3=new Font("Courier New",Font.PLAIN,20);
		Font f4=new Font("Snap ITC",Font.PLAIN,20);

		title=new Label("LIBRARY MANAGEMENT");
		bn=new Label("Book Name :");
		au=new Label("Book Id        :");
		pr=new Label("Author            :");
	
		qu=new Button("Update");
		fi=new Button("First");
		la=new Button("Last");
		ex=new Button("Exit");
		ne=new Button("Next");
		pre=new Button("Previous");
		ins=new Button("Insert");
		cl=new Button("Delete");
		abs=new Button("Absolute");
		rel=new Button("Relative");
		
		
		title.setFont(f1);
		bn.setFont(f2);
		au.setFont(f2);
		pr.setFont(f2);
		
	
		tbn=new TextField();
		tau=new TextField();
		tpr=new TextField();
		
		title.setBounds(150,30,400,120);	
		bn.setBounds(50,160,120,60);
		au.setBounds(50,200,120,60);
		pr.setBounds(50,240,120,60);
		tbn.setBounds(180,180,270,25);
		tau.setBounds(180,220,270,25);
		tpr.setBounds(180,260,140,25);
		qu.setBounds(50,340,90,40);
		fi.setBounds(180,340,90,40);
		la.setBounds(310,340,90,40);
		ex.setBounds(440,340,90,40);
		ne.setBounds(50,420,90,40);
		pre.setBounds(180,420,90,40);
		ins.setBounds(310,420,90,40);
		cl.setBounds(440,420,90,40);
		abs.setBounds(50,500,90,40);
		rel.setBounds(180,500,90,40);
	
		tbn.setFont(f3); tau.setFont(f3); tpr.setFont(f3);
		qu.setFont(f4); fi.setFont(f4); la.setFont(f4);
		ex.setFont(f4); ne.setFont(f4); pre.setFont(f4); ins.setFont(f4); cl.setFont(f4);abs.setFont(f4);
		rel.setFont(f4);

		f.add(title);  
		f.add(bn); 	f.add(au); 	f.add(pr);
		f.add(tbn); 	f.add(tau); 	f.add(tpr);
		f.add(qu);   f.add(fi);    f.add(la);  f.add(ex); f.add(ne); f.add(pre); f.add(ins); f.add(cl);
		f.add(abs); f.add(rel);
		
		qu.addActionListener(this);
		fi.addActionListener(this);
		la.addActionListener(this);
		ex.addActionListener(this);
		ne.addActionListener(this);
		pre.addActionListener(this);
		ins.addActionListener(this);
		cl.addActionListener(this);
		abs.addActionListener(this);
		rel.addActionListener(this);		

		f.setVisible(true);		
	}
	void connec()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			c=DriverManager.getConnection("jdbc:odbc:Raghav");
			s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			execQry("select * from Books");		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void execQry(String qry)
	{
		try	
		{
			rs=s.executeQuery(qry);
			rs.next();
			System.out.println("Query executed successfully...");
			display();
		}
		catch(Exception e)
		{	
			System.out.println(e);
		}
	}
	void display()
	{
		try
		{
			tbn.setText(rs.getString(1));
			tau.setText(rs.getString(2));
			tpr.setText(rs.getString(3));
		}
		catch(Exception e)
		{	
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==qu)
		{
			try
			{
				s.execute("UPDATE Books SET book_id=123 WHERE book_name='dfg'");
				System.out.println("Successfully Updated....");
				execQry("select * from Books");		
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==ex)
		{
			System.exit(0);
		}
		else if(ae.getSource()==cl)
		{
			try
			{
				s.execute("DELETE FROM Books WHERE book_name='dfg'");
				System.out.println("Successfully deleted..");
				execQry("select * from Books");		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==fi)
		{
			try
			{
				rs.first();
				display();
			 }
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
		else if(ae.getSource()==la)
		{
			try
			{
				rs.last();
				display();
			 }
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
		else if(ae.getSource()==ne)
		{
			try
			{
				if(rs.next())
					display();
				else
				{
					System.out.println("This is last record");
					rs.first();
				}
			}
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
		else if(ae.getSource()==pre)
		{
			try
			{
				if(rs.previous())
					display();
				else
				{
					System.out.println("No previous record");
					rs.first();
				}
			}
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
		else if(ae.getSource()==ins)
		{
			try 
			{
				s.execute("INSERT INTO Books VALUES('"+tbn.getText()+"','"+Integer.parseInt(tau.getText())+"','"+tpr.getText()+"')");
				System.out.println("Successfully inserted...");
				execQry("select * from Books");						
			}
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
		else if(ae.getSource()==abs)
		{
			try
			{
				if(rs.absolute(5))
					display();
				else
					System.out.println("Invalid row number");
			}
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}
		else if(ae.getSource()==rel)
		{
			try
			{
				if(rs.relative(2))
					display();
				else
					System.out.println("Invalid Row number");
			}
			catch(Exception e)
			{	
				System.out.println(e);
			}
		}


	}
	public static void main(String ar[])
	{
		TestDB t=new TestDB();
		t.connec();
	}
}