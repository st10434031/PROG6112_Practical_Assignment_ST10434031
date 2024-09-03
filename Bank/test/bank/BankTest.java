
package bank;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class BankTest 
{
    @Test
    public void TestDeposit()
    {
        SavingsAccount demo=new SavingsAccount();
        demo.balance=1000;
        demo.deposit(100);
        String result=Double.toString(demo.balance);
        String expResult="1100.0";
        
        assertEquals(expResult,result);
        
    }

    @Test 
    public void TestWithdrawal()
    {
        SavingsAccount demo=new SavingsAccount();
        demo.balance=1000;
        demo.withdraw(100);
        String result=Double.toString(demo.balance);
        String expResult="900.0";
        
        assertEquals(expResult,result);
    }
    
    @Test
    public void testSearchForAcc() 
    {
        Bank test=new Bank();
     
        SavingsAccount demo=new SavingsAccount();
        demo.accountNumber="10111";
        ArrayList<SavingsAccount> accounts=new ArrayList<>();
        accounts.add(demo);
        int expResult = 0;
        int result = test.searchForAcc(accounts,demo.accountNumber);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testSearchForAcc_NotFound() 
    {
        Bank test=new Bank();
     
        SavingsAccount demo=new SavingsAccount();
        demo.accountNumber="10111";
        ArrayList<SavingsAccount> accounts=new ArrayList<>();
        
        //SavingsAccount was not added to account array
        //accounts.add(demo);
        int expResult = -1;
        int result = test.searchForAcc(accounts,demo.accountNumber);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testCalcFutureValue()
    {
        SavingsAccount demo=new SavingsAccount();
        demo.balance=1000;
        demo.investmentPeriod=5;
        double result=demo.calcFutureValue();
        double expResult=1283.5912888620885;
        
        assertEquals(Double.toString(result),Double.toString(expResult));
    }
}
