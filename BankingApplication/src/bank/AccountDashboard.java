package bank;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AccountDashboard extends JFrame implements ActionListener
{
	//Database db = Database.getInstance();
	Account ac;
	
	JLabel welcomeText = new JLabel();
	
	JTextField accountNoT = new JTextField("",20);
	JTextField amountT = new JTextField("",10);
	
	JPasswordField oldP= new JPasswordField("",20);
	JPasswordField newP= new JPasswordField("",20);
	JPasswordField reNewP= new JPasswordField("",20);
	
	JButton transferB= new JButton("Transfer Money");
	JButton withdrawB= new JButton("Withdraw Money");
	JButton depositB= new JButton("Deposit Money");
	JButton balanceB= new JButton("Balance Check");
	JButton payBillB= new JButton("Pay Bill");
	JButton userDetailB= new JButton("User Detail");
	JButton changePinB= new JButton("Change PIN");
	JButton saveB = new JButton("Save");
	JButton logoutB = new JButton("Log Out");
	
	JButton transferSB = new JButton("Transfer");
	JButton withdrawalSB = new JButton("Withdraw");
	JButton depositSB = new JButton("Deposit");
	JButton payBillSB = new JButton("Pay");
	JButton PinB = new JButton("Submit");
	
	JPanel left = new JPanel();
	JPanel right = new JPanel();
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	JPanel center = new JPanel();
	public static String debitor;
	
	public AccountDashboard(String ac)
	{
		debitor=ac.split(" ")[0];;
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				//db.saveData();
				System.exit(0);
			}
		});
		this.setTitle("Dashboard");
		this.setSize(700, 400);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //this.setLayout(new FlowLayout());
	    
        
	    transferSB.addActionListener(this);
	    withdrawalSB.addActionListener(this);
	    payBillSB.addActionListener(this);
	    depositSB.addActionListener(this);
	    saveB.addActionListener(this);
	    PinB.addActionListener(this);
	    
	    this.add(left,BorderLayout.WEST);
	    this.add(right,BorderLayout.EAST);
	    this.add(top,BorderLayout.NORTH);
	    this.add(bottom,BorderLayout.SOUTH);
	    this.add(center,BorderLayout.CENTER);
	    
	  
	    top.setBorder(new EmptyBorder(10, 0, 10, 0));
	    welcomeText.setText("Welcome, " + ac.split(" ")[0] + " " + ac.split(" ")[0]);
	    top.add(welcomeText);
	    
	    
	    left.setLayout(new GridLayout(7, 1,5,10));
	    transferB.addActionListener(this);
	    left.add(transferB);
	    withdrawB.addActionListener(this);
	    left.add(withdrawB);
	    depositB.addActionListener(this);
	    left.add(depositB);
	    balanceB.addActionListener(this);
	    left.add(balanceB);
	    payBillB.addActionListener(this);
	    left.add(payBillB);
	    
	    right.setLayout(new GridLayout(7, 1,5,10));
	    userDetailB.addActionListener(this);
	    right.add(userDetailB);
	    changePinB.addActionListener(this);
	    right.add(changePinB);
	    
	    //center.setPreferredSize(new Dimension(100, 100));
	    //center.setBackground(new Color(24, 14, 255));
	    
	    logoutB.addActionListener(this);
	    bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    bottom.add(logoutB);
	    
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Transfer Money"))
		{
			generateTransferPanel();
		}
		else if(e.getActionCommand().equals("Withdraw Money"))
		{
			generateWithdrawalPanel();
		}
		else if(e.getActionCommand().equals("Deposit Money"))
		{
			generateDepositPanel();
		}
		else if(e.getActionCommand().equals("Balance Check"))
		{
			try {
				generateBalancePanel();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Pay Bill"))
		{
			generatePayBillPanel();
		}
		else if(e.getActionCommand().equals("Transfer"))
		{
			try {
				transfer();
			} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Withdraw"))
		{
			try {
				withdraw();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Deposit"))
		{
			try {
				deposit();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getActionCommand().equals("Pay"))
		{
			try {
				payBill();
			} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("User Detail"))
		{
			try {
				generateUserDetailPanel();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Change PIN"))
		{
			generatePinPanel();
		}
		else if(e.getActionCommand().equals("Submit"))
		{
			try {
				changePIN();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Log Out"))
		{
			this.dispose();
			new LoginWindow();
		}
		
	}
	
	void generateTransferPanel()
	{
		panelClear();
		center.add(new JLabel("Enter Account no: "));
		center.add(accountNoT);
		center.add(new JLabel("Enter Amount: "));
		center.add(amountT);
		center.add(new JLabel());
		center.add(transferSB);
		this.revalidate();
	}
	
	void generateWithdrawalPanel()
	{
		panelClear();
		center.add(new JLabel("Enter Amount: "));
		center.add(amountT);
		center.add(new JLabel());
		center.add(withdrawalSB);
		this.revalidate();
	}
	
	void generateDepositPanel()
	{
		panelClear();
		center.add(new JLabel("Enter Amount: "));
		center.add(amountT);
		center.add(new JLabel());
		center.add(depositSB);
		this.revalidate();
	}
	
	void generateBalancePanel() throws ClassNotFoundException, SQLException
	{
		panelClear();
		center.add(new JLabel("Current Balance: "));
		DecimalFormat df = new DecimalFormat("0.00");
		//int amount=new Account().getBalance(debitor);
		center.add(new JLabel(""+df.format(new Account().getBalance(debitor))));
		center.add(new JLabel());
		center.add(new JLabel());
		this.revalidate();
	}
	
	void generatePayBillPanel()
	{
		panelClear();
		center.add(new JLabel("Enter ID/BillNo: "));
		center.add(accountNoT);
		center.add(new JLabel("Enter Amount: "));
		center.add(amountT);
		center.add(new JLabel());
		center.add(payBillSB);
		this.revalidate();
	}
	
	void generateUserDetailPanel() throws ClassNotFoundException, SQLException
	{
		panelClear();
		center.setBorder(new EmptyBorder(50, 50, 50,50));
		center.setLayout(new GridLayout(0, 2, 5, 10));
		 List<String> user=new ArrayList<String>();
		 user=new Account().UserDetails(debitor);
		center.add(new JLabel("Full Name:"));
		center.add(new JLabel(user.get(3) + " " + user.get(4)));
		center.add(new JLabel("Sex:"));
		center.add(new JLabel(user.get(10)));
		center.add(new JLabel("Date of Birth:"));
		center.add(new JLabel(user.get(9)));
		center.add(new JLabel("Email:"));
		center.add(new JLabel(user.get(4)));
		center.add(new JLabel("Phone No.:"));
		center.add(new JLabel(user.get(5)));
		center.add(new JLabel("NID:"));
		center.add(new JLabel(user.get(6)));
		center.add(new JLabel("Address:"));
		center.add(new JLabel(user.get(7)));
		center.add(new JLabel("Occupation:"));
		center.add(new JLabel(user.get(8)));
		this.revalidate();
		
	}
	
	void generatePinPanel()
	{
		panelClear();
		center.setBorder(new EmptyBorder(80, 50, 70,50));
		center.setLayout(new GridLayout(4, 2, 5, 10));
		center.add(new JLabel("Old PIN:"));
		center.add(oldP);
		center.add(new JLabel("Enter New PIN:"));
		center.add(newP);
		center.add(new JLabel("Re-Enter New PIN:"));
		center.add(reNewP);
		center.add(new JLabel(" "));
		center.add(PinB);
		this.revalidate();
		
	}
	
	void panelClear()
	{
		center.removeAll();
		center.setBorder(new EmptyBorder(80, 50, 110,50));
		center.setLayout(new GridLayout(3, 2, 5, 10));
		accountNoT.setText("");
		amountT.setText("");
		oldP.setText("");
		newP.setText("");
		reNewP.setText("");
	}
	
	void payBill() throws HeadlessException, ClassNotFoundException, SQLException
	{
		try
		{
			double amount=Double.parseDouble(amountT.getText());
			if(new Account().payBill(debitor,amount))
			{
				JOptionPane.showMessageDialog(this,"Bill successfully Paid!","Success",JOptionPane.OK_OPTION);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"You don't have enough Balance","Failed",JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void transfer() throws HeadlessException, ClassNotFoundException, SQLException  ///Completed
	{
		try
		{
			double amount=Double.parseDouble(amountT.getText());
			
			String otherAccount;
			if((otherAccount=MysqlDataBase.conection(accountNoT.getText()))!=null)
			{
				if(new Account().transferMoney(debitor,otherAccount, amount))
				{
					JOptionPane.showMessageDialog(this,"Successfully Transferred","Success",JOptionPane.OK_OPTION);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"You don't have enough Balance","Failed",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Sorry, Given Account not Found","Failed",JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void withdraw() throws ClassNotFoundException, SQLException   //completed
	{
		try
		{
			double amount=Double.parseDouble(amountT.getText());
			int t=new Account().withdrawMoney(debitor,amount);
			if(t==0)
				JOptionPane.showMessageDialog(this,"Successfully Withdrawn","Success",JOptionPane.OK_OPTION);
			else if(t==Account.INSUFFICIENT_BALANCE)
				JOptionPane.showMessageDialog(this,"You don't have enough Balance","Failed",JOptionPane.ERROR_MESSAGE);
			else if(t==Account.WITHDRAWAL_LIMIT_UNDER)
				JOptionPane.showMessageDialog(this,"Minimum withdrawal amount is: "+ ac.minWithdrawal,"Failed",JOptionPane.ERROR_MESSAGE);
			else if(t==Account.WITHDRAWAL_LIMIT_OVER)
				JOptionPane.showMessageDialog(this,"Maximum Withdrawal amount is: " +ac.maxWithdrawal,"Failed",JOptionPane.ERROR_MESSAGE);
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void deposit() throws ClassNotFoundException, SQLException  ////Completed
	{
		try
		{
			double amount=Double.parseDouble(amountT.getText());
			new Account().depositMoney(debitor,amount);
			JOptionPane.showMessageDialog(this,"Successfully Deposited","Success",JOptionPane.OK_OPTION);
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void changePIN() throws ClassNotFoundException, SQLException
	{
		String currentpin=new Account().getPIN(debitor);
		
		if(oldP.getText().isEmpty() || newP.getText().isEmpty() || reNewP.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Please Fill all the Fields","Failed",JOptionPane.ERROR_MESSAGE);
		}
		else if(!oldP.getText().equals(currentpin))
		{
			JOptionPane.showMessageDialog(this,"Wrong PIN Entered","Failed",JOptionPane.ERROR_MESSAGE);
		}
		else if(!newP.getText().equals(reNewP.getText()))
		{
			JOptionPane.showMessageDialog(this,"New PINs doesn't Match","Failed",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			new Account().setPIN(debitor,newP.getText());
			JOptionPane.showMessageDialog(this,"PIN successfully changed","Success",JOptionPane.OK_OPTION);
		}
	}
}
