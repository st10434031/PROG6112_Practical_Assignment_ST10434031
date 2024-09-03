
package bank;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bank {
    
    ArrayList<SavingsAccount> accounts=new ArrayList<>();
    
    
    public static void main(String[] args)
    {
        Bank dummy=new Bank();
        dummy.Menu();
        
    }
    
    public void Menu()
    {
       int selection=0;
        
       while(selection<1||selection>6)
       {
           selection=Integer.parseInt(JOptionPane.showInputDialog("Select an option\n"+"1.Open Account\n"+"2. Deposit\n"+
                "3.Withdraw\n"+"4.Calculate Future Value\n"+"5. Print Accounts Report\n"+"6.Quit"));
       }
       
       while(selection!=6)
       {
           if(selection==1)
           {
               
               this.OpenAccount();
           }
            else 
            {
                if(selection==2)
                {
                    
                       this.Deposit();
                }
                else
                {
                    if(selection==3)
                    {
                       this.Withdraw();
                    }
                    else
                    {
                       if(selection==4)
                        {
                            this.FutureValue();
                        }
                        else
                        {
                            if(selection==5)
                            {
                                this.PrintAccounts();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Invalid input!");
                            }
                        }
                    }
                }
            }
           
           selection=Integer.parseInt(JOptionPane.showInputDialog("Select an option\n"+"1.Open Account\n"+"2. Deposit\n"+
                "3.Withdraw\n"+"4.Calculate Future Value\n"+"5. Print Accounts Report\n"+"6.Quit"));
       }
    }
       
       public int searchForAcc(String accNum)
       {
           int index=-1;
           
           boolean foundOrNot=false;
           
           Account [] accountArray=new Account[accounts.size()];
           accountArray=accounts.toArray(accountArray); 
            
            for(int i=0;i<accountArray.length;i++)
            {
                if(accNum.equals(accountArray[i].accountNumber))
                {
                    foundOrNot=true;
                    index=i;
                }
            }
            
            return index;
       }
       
       //overloaded method used for functionality demonstration in unit testing
       public int searchForAcc(ArrayList<SavingsAccount> accounts,String accNum)
       {
           int index=-1;
           
           boolean foundOrNot=false;
           
           Account [] accountArray=new Account[accounts.size()];
           accountArray=accounts.toArray(accountArray); 
            
            for(int i=0;i<accountArray.length;i++)
            {
                if(accNum.equals(accountArray[i].accountNumber))
                {
                    foundOrNot=true;
                    index=i;
                }
            }
            
            return index;
       }
       
       //prompts user for necessary info for opening account
       public void OpenAccount()
       {
           double openingBal=Double.parseDouble(JOptionPane.showInputDialog("How much would you like to deposit to open your account? (R)"));    
           SavingsAccount temp=new SavingsAccount(openingBal);
           accounts.add(temp);
       }
       
       //prompts user for info to deposit an amount
       public void Deposit()
       {
           String accNum=JOptionPane.showInputDialog("Please enter your account number: ");
                    if(searchForAcc(accNum)!=-1)
                    {
                        int index=searchForAcc(accNum);
                        SavingsAccount temp= new SavingsAccount();
                        temp=accounts.get(index);
                        int depositAmount=Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount you wish to deposit: (R) "));
                        temp.deposit(depositAmount);
                        accounts.remove(index);
                        accounts.add(temp);
                        JOptionPane.showMessageDialog(null,"Balance: R"+temp.balance);
                    }
       }
       
       //prompts user for info to withdraw an amount
       public void Withdraw()
       {    
           
            String accNum=JOptionPane.showInputDialog("Please enter your account number: ");
            if(searchForAcc(accNum)!=-1)
            {
                int index=searchForAcc(accNum);
                SavingsAccount temp= new SavingsAccount();
                temp=accounts.get(index);
                int depositAmount=Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount you wish to withdraw: (R) "));
                temp.withdraw(depositAmount);
                accounts.remove(index);
                accounts.add(temp);
                JOptionPane.showMessageDialog(null,"Balance: R"+temp.balance);
            }
       
       }
       
       //prompts user for info to calculate future value of account
       public void FutureValue()
       {
           String accNum=JOptionPane.showInputDialog("Please enter your account number: ");
                            
                            if(searchForAcc(accNum)!=-1)
                            {
                                int index=searchForAcc(accNum);
                                SavingsAccount temp= new SavingsAccount();
                                temp=accounts.get(index);
                                accounts.remove(index);
                                temp.investmentPeriod=Integer.parseInt(JOptionPane.showInputDialog("Please enter the period (in years) you will be saving this money for : "));
                                accounts.add(temp);
                                double futureVal=temp.calcFutureValue();
                                JOptionPane.showMessageDialog(null,"Future Value: R"+temp.futureValue);
                            }
       }
       
       public void PrintAccounts()
       {
           Account [] accountArray=new Account[accounts.size()];
           accountArray=accounts.toArray(accountArray);
           
           String message="";
           
           for(int i=0;i<accountArray.length;i++)
           {
               message+="Account number: "+accountArray[i].accountNumber+"\n"+"Balance: R"+accountArray[i].balance+"\n\n";
           }
           
           JOptionPane.showMessageDialog(null,message);
       }
    }
    
    