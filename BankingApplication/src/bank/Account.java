package bank;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account
{
	public static final int SAVINGS_ACCOUNT=1;
	public static final int CURRENT_ACCOUNT=2;
	
	public static final int INSUFFICIENT_BALANCE=1;
	public static final int WITHDRAWAL_LIMIT_UNDER=2;
	public static final int WITHDRAWAL_LIMIT_OVER=3;
	
	public static String accountNo;
	public static String password;
	
	public int balance;
	protected double minBalance;
	protected double minWithdrawal;
	protected double maxWithdrawal;
	
	protected UserInformation user;
	
	boolean isActivated;

	
	
	//abstract void setMinBalance(double a);
	//abstract void setWithdrawalLimit(double l, double h);
	//abstract int getAccountType();
	
	int getBalance(String debitor) throws ClassNotFoundException, SQLException
	{
		
		balance=MysqlDataBase.balance(debitor);
		return balance;
	}
	
	
	String getAccuntNo()
	{
		return accountNo;
	}
	void setAccountNo(String s)
	{
		accountNo=s;
	}
	String getPIN(String debitor) throws ClassNotFoundException, SQLException
	{
		
		password=MysqlDataBase.password(debitor);
		isActivated=true;
		return password;
		
		
	}
	void setPIN(String debitor,String newpin) throws ClassNotFoundException, SQLException
	{
		password=MysqlDataBase.setpassword(debitor,newpin);
	}
	
	void activateAccount(String debitor)
	{
		this.isActivated=true;
	}
	
	String generateUniqueAccountNumber()
	{
		Random r = new Random();
		//Database db = Database.getInstance();
		
		  String accountNum=String.valueOf(r.nextInt(10000000)+89999999);
		  return accountNum; 
		 
		
		
	}
	String generatePIN()
	{
		Random r = new Random();
		return String.valueOf(r.nextInt(1000)+8999);
	}
	
	boolean payBill(String debitor,double amount) throws ClassNotFoundException, SQLException
	{
		List<Double> balancecheck=new ArrayList<Double>();
		 balancecheck=MysqlDataBase.withdraw(debitor,amount);
		 
		if(balancecheck.get(0)-amount< balancecheck.get(1))  ///// balance-amount<minBalance
			return false;
		else
		{
		MysqlDataBase.Withdraw1(debitor,amount);
		return true;	
		}
	}
	
	void depositMoney(String Depositor,double amount) throws ClassNotFoundException, SQLException
	{
		MysqlDataBase.Deposit(Depositor, amount);
	}
	
	 boolean transferMoney(String Debitor,String Creditor, double amount) throws ClassNotFoundException, SQLException
	{
		 List<Double> balancecheck=new ArrayList<Double>();
		 balancecheck=MysqlDataBase.Balance(Debitor);
		 
		if(balancecheck.get(0)-amount< balancecheck.get(1))
			return false;
		else
		{
		MysqlDataBase.MoneyWithdraw(Debitor,Creditor,amount);
		
		return true;	
		}
	}
	
	int withdrawMoney(String Account, double amount) throws ClassNotFoundException, SQLException
	{
		 List<Double> balancecLimit=new ArrayList<Double>();
		 balancecLimit=MysqlDataBase.withdraw(Account,amount);
		if(amount< balancecLimit.get(2))    //if(amount< minWithdrawal)
			return WITHDRAWAL_LIMIT_UNDER;
		if(amount>balancecLimit.get(3))   // if(amount>maxWithdrawal) 
			return WITHDRAWAL_LIMIT_OVER;
		if(balancecLimit.get(0)-amount <balancecLimit.get(1))  //  if(balance-amount<minBalance)
			return INSUFFICIENT_BALANCE;
		
		
		MysqlDataBase.Withdraw1(Account, amount);
		//balance-=amount;
		return 0;
	}
	
	List<String> UserDetails(String Account) throws ClassNotFoundException, SQLException
	{
		 List<String> user=new ArrayList<String>();
		 user=MysqlDataBase.UserDetails(Account);
		
		//balance-=amount;
		return user;
	}
	
	
	
	/*
	 * public String toString() { return getAccountType()+"\n"+ accountNo + "\n" +
	 * password + "\n" + balance + "\n" + user + "\n" + isActivated + "\n"; }
	 */
}
