
package bank;

import javax.swing.JOptionPane;


public class Account 
{
        // Private variables to store account number and balance
        protected String accountNumber;
        protected double balance;
        //accountCounter to keep track of accounts; used in assigning account numbers
        protected static int accountCounter=0;
        
        //default constructor
        public Account()
        {
        }
        
        
        // Constructor to initialize account number and balance
        public Account(double balance) 
        {
            accNumGenerator();
            this.balance = balance;
        }
    
    
        //to add money to account
        public String deposit(double amount) 
        {
            // Increase the balance by the deposit amount
            balance += amount;
            
            return Double.toString(balance);
        }
        
        //to access money from accounr
        public void withdraw(double amount)
        {
            // Check if the balance is sufficient for the withdrawal
            if (balance >= amount) 
            {
                balance -= amount;
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Insufficient balance");
            }
        }
        
        //automatically assigns account number upon account creation
        public void accNumGenerator()
        {
            this.accountNumber="000";
            accountCounter++;
            this.accountNumber+=accountCounter;
            
        }
    
}
