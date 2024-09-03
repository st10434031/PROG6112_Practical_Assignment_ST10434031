package bank;

// Declare the SavingsAccount class, inheriting from BankAccount

import javax.swing.JOptionPane;

public class SavingsAccount extends Account
{
    double INTEREST_RATE=0.0512;
    double futureValue;
    double investmentPeriod;
    
    SavingsAccount()
    {}
    
    // Constructor to initialize account number and balance
    public SavingsAccount(double balance)
    {
        // Call the parent class constructor
        super(balance);
        JOptionPane.showMessageDialog(null, "Savings Account "+this.accountNumber+" WAS created!");
    }

    //value add feature, calculates future value of account based on accrued interest at 5.21% over a user specified period
    public double calcFutureValue()
    {
        this.futureValue=this.balance*Math.pow((1+INTEREST_RATE),investmentPeriod);
        
        return this.futureValue;
    }
    
    // Overriden version of withdraw method
    @Override
    public void withdraw(double amount) 
    {
        String returnMessage=null;
        // Check if the withdrawal would cause the balance to drop below $100
        if (this.balance - amount < 100) 
        {
            // Print a message if the minimum balance requirement is not met
            JOptionPane.showMessageDialog(null,"Minimum balance of R100 required!");
        } 
        else
        {
            // Call the parent class withdraw method
            super.withdraw(amount);
        }
        
        
    }
}
