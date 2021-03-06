package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MysqlDataBase 
{
	public  String conection(String n, String p) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from bank where AcctNum="+n+" and password="+p+"");   
				while(rs.next())  
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
					credentail=rs.getInt(1)+"  "+rs.getString(2);
				}
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   }
	
	public  static List Balance(String DebitorAccount) throws ClassNotFoundException, SQLException
	{
		
		List<Double> balancecheck=new ArrayList<Double>();
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from bank where AcctNum='"+DebitorAccount+"'");   
				while(rs.next())  
				{
					System.out.println(rs.getInt(13)+"  "+rs.getString(14)+" "+rs.getString(15)+" "+rs.getString(16));  
					//credentail=rs.getInt(1)+"  "+rs.getString(2);
					
					balancecheck.add((double) rs.getInt(13));
					balancecheck.add((double) rs.getInt(14));
					balancecheck.add((double) rs.getInt(15));
					balancecheck.add((double) rs.getInt(16));
				}
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return balancecheck;
	
   }
	
	public  static List withdraw(String DebitorAccount, double amount) throws ClassNotFoundException, SQLException
	{
		
		List<Double> balancecheck=new ArrayList<Double>();
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from bank where AcctNum='"+DebitorAccount+"'");   
				while(rs.next())  
				{
					System.out.println(rs.getInt(13)+"  "+rs.getString(14)+" "+rs.getString(15)+" "+rs.getString(16));  
					//credentail=rs.getInt(1)+"  "+rs.getString(2);
					
					balancecheck.add((double) rs.getInt(13));
					balancecheck.add((double) rs.getInt(14));
					balancecheck.add((double) rs.getInt(15));
					balancecheck.add((double) rs.getInt(16));
				}
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return balancecheck;
	
   }
	public static  String conection(String Account) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from bank where AcctNum="+Account+"");   
				while(rs.next())  
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
					credentail=rs.getInt(1)+"  "+rs.getString(2);
				}
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   }
	public static  String MoneyWithdraw(String Debitor, String creditor, double amount) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				int rs= rs=stmt.executeUpdate("UPDATE bank SET balance = balance -"+ amount+" where AcctNum='"+Debitor+"'");   
				int rs1= rs=stmt.executeUpdate("UPDATE bank SET balance = balance + "+ amount+" where AcctNum='"+creditor+"'");  
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   }
	public static  String Withdraw1(String Debitor, double amount) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				int rs= rs=stmt.executeUpdate("UPDATE bank SET balance = balance -"+ amount+" where AcctNum='"+Debitor+"'");   
				
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   }
	public static  String Deposit(String DepositorAccount, double amount) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				int rs= rs=stmt.executeUpdate("UPDATE bank SET balance = balance +"+ amount +"where AcctNum='"+DepositorAccount+"'");   
				//int rs1= rs=stmt.executeUpdate("UPDATE bank SET balance = balance + amount where AcctNum='"+creditor+"'");  
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   }
	
	public  String CreateCustomer(String  accountNo, String password, String firstName, String lastName, String email, String phoneNo, String NID, String address,
			String occupation, String sex, String birthdate,String AccountType, double balance, double minBalance, double minWithdrawal, double maxWithdrawal) throws ClassNotFoundException, SQLException
	{
		
		
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
		int rs;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				if(AccountType.equals("Savings"))
				{
					 System.out.println("INSERT INTO bank(AcctNum,password,firstName, lastName, email, phoneNo, NID, address, occupation, sex, birthdate,AccountType,balance,minBalance,minWithdrawal,maxWithdrawal) VALUES('"+accountNo+"','"+password+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNo+"','"+NID+"','"+address+"','"+occupation+"','"+birthdate+"','"+sex+"','"+AccountType+"',500,500,0,25000);");  
					 rs=stmt.executeUpdate("INSERT INTO bank(AcctNum,password,firstName, lastName, email, phoneNo, NID, address, occupation,birthdate, sex, AccountType,balance,minBalance,minWithdrawal,maxWithdrawal) VALUES ('"+accountNo+"','"+password+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNo+"','"+NID+"','"+address+"','"+occupation+"','"+birthdate+"','"+sex+"','"+AccountType+"',500,500,0,25000);"); 
					// System.out.println("INSERT INTO bank VALUES ("+accountNo+","+password+","+firstName+","+lastName+","+email+","+phoneNo+","+NID+","+address+","+occupation+","+sex+","+birthdate+","+AccountType+",500,500,0,25000);");  
				}
				else
				{
					 System.out.println("INSERT INTO bank(AcctNum,password,firstName, lastName, email, phoneNo, NID, address, occupation, sex, birthdate,AccountType,balance,minBalance,minWithdrawal,maxWithdrawal) VALUES('"+accountNo+"','"+password+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNo+"','"+NID+"','"+address+"','"+occupation+"','"+birthdate+"','"+sex+"','"+AccountType+"',500,500,0,25000);");  
					 rs=stmt.executeUpdate("INSERT INTO bank(AcctNum,password,firstName, lastName, email, phoneNo, NID, address, occupation,birthdate, sex, AccountType,balance,minBalance,minWithdrawal,maxWithdrawal) VALUES ('"+accountNo+"','"+password+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNo+"','"+NID+"','"+address+"','"+occupation+"','"+birthdate+"','"+sex+"','"+AccountType+"',1000,1000,100,200000);"); 
				}
				//ResultSet rs=stmt.executeQuery("INSERT INTO bank(accountNo,password,firstName, lastName, email, phoneNo, NID, address, occupation, sex, birthdate,AccountType,balance,minBalance,minWithdrawal,maxWithdrawal) VALUES ("+accountNo,password,firstName, lastName, email, phoneNo, NID, address, occupation, sex, birthdate,AccountType,balance,minBalance,minWithdrawal,maxWithdrawal+");"); 
					   
				
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
}

	public static int balance(String debitor) throws SQLException, ClassNotFoundException {

		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		int credentail = 0;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from bank where AcctNum="+debitor+"");   
				while(rs.next())  
				{
					System.out.println(rs.getInt(1));  
					credentail=rs.getInt(13);
				}
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   
	}

	public static List<String> UserDetails(String account) throws SQLException, ClassNotFoundException {
		
		List<String> user=new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from bank where AcctNum='"+account+"'");   
				while(rs.next())  
				{
					//System.out.println(rs.getInt(13)+"  "+rs.getString(14)+" "+rs.getString(15)+" "+rs.getString(16));  
					//credentail=rs.getInt(1)+"  "+rs.getString(2);
					
					user.add(rs.getString(1));
					user.add(rs.getString(2));
					user.add( rs.getString(3));
					user.add(rs.getString(4));
					user.add(rs.getString(5));
					user.add(rs.getString(6));
					user.add(rs.getString(7));
					user.add(rs.getString(8));
					user.add(rs.getString(9));
					user.add(rs.getString(10));
					user.add(rs.getString(11));
					user.add(rs.getString(12));
				}
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return user;
	
   }

	public static String password(String debitor) throws ClassNotFoundException, SQLException {


		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from bank where AcctNum="+debitor+"");   
				while(rs.next())  
				{
					//System.out.println(rs.getInt(1));  
					credentail=rs.getString(2);
				}
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   
	
	}

	public static String setpassword(String debitor, String newpin) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tarunbank","root","suman");  
		String credentail = null;
			try{  
				
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				int rs= rs=stmt.executeUpdate("UPDATE bank SET password = "+ newpin+" where AcctNum='"+debitor+"'");   
				
				
				
				
				con.close(); 
			
				}
			catch(Exception e)
				{ 
				System.out.println(e);
				
				}  
			
			
			return credentail;
	
   }  
	
}


