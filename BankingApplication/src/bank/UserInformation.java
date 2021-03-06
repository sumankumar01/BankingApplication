package bank;
import java.sql.SQLException;
import java.util.Date;

public class UserInformation
{
	String firstName;
	String lastName;
	String email;
	String phoneNo;
	String NID;
	String address;
	String occupation;
	String sex;
	
	String birthdate;
	
	protected double balance;
	protected double minBalance;
	protected double minWithdrawal;
	protected double maxWithdrawal;

	public UserInformation(String firstName, String lastName, String email, String phoneNo, String NID, String address,
			String occupation, String sex, String birthdate,String AccountType) throws ClassNotFoundException, SQLException
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.NID = NID;
		this.address = address;
		this.occupation = occupation;
		this.sex = sex;
		this.birthdate = birthdate;
		
		String accountNo=new Account().generateUniqueAccountNumber();
		String password=new Account().generatePIN();
		//new Account().setAccountNo(accountNo);
		//new Account().setPIN(password);
		
		if(AccountType.equals("Savings Account"))
		{
			
			 balance=500;
			 minBalance=500;
			minWithdrawal=0;
			 maxWithdrawal=25000;
			 new MysqlDataBase().CreateCustomer(accountNo,password,firstName, lastName, email, phoneNo, NID, address, occupation, sex, birthdate,"Savings",balance,minBalance,minWithdrawal,maxWithdrawal);
		}
		else
		{
			 balance=1000;;
		    minBalance=1000;;
			 minWithdrawal=100;
			 maxWithdrawal=200000;
			 new MysqlDataBase().CreateCustomer(accountNo,password,firstName, lastName, email, phoneNo, NID, address, occupation, sex, birthdate,"Current",balance,minBalance,minWithdrawal,maxWithdrawal);
		}
		
		
		
	}

	public String toString()
	{
		return  firstName + "\n" + lastName + "\n" + email + "\n"
				+ phoneNo + "\n" + NID + "\n" + address + "\n" + occupation + "\n" + sex
				+ "\n" + birthdate;
	}
	
	
	
}
