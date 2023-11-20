//Program for ATM Interface

import java.util.*;
import java.lang.*;

class Authentication
{
    public static int balance,deposit_amount,withdraw_amount,transfer_amount;
    public static String AccountNum,user="Sravani",accN1="x1234",accN2="x5678",PinNum,pin="3456",user_id;
    
    static void login()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your user_id:");
        user_id=sc.nextLine();
        System.out.print("Enter your Pin Number:");
        PinNum=sc.nextLine();
        
    }
}

class Operation extends Authentication
{
    static void deposit()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the amount to be deposited:");
        deposit_amount=sc.nextInt();
        balance=balance+deposit_amount;
        System.out.println(deposit_amount+" has been successfully credited into Account Number "+accN1);
        System.out.println("Your updated balance is:"+balance);
    }

    static void withdraw()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the amount to  withdraw:");
        withdraw_amount=sc.nextInt();
        if(withdraw_amount>balance)
        {
            System.out.println("Insufficient balance");
        }
        else
        {
            balance=balance-withdraw_amount;
            System.out.println(withdraw_amount+" has been successfully debited from Account Number "+accN1);
            System.out.println("Your updated balance is:"+balance);
        }
    }

    static void check_balance()
    {
        System.out.println("Your current balance is:"+balance);
    }

    static void fund_transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Account Number for fund transfer:");
        AccountNum=sc.nextLine();
        System.out.print("Enter the amount to be transfered:");
        transfer_amount=sc.nextInt();
        if(transfer_amount>balance)
        {
            
            System.out.println("Insufficient balance");
        }
        else
        {
            if(AccountNum.equals(accN2))
            {
                balance=balance-transfer_amount;
                System.out.println(transfer_amount+" has been transfered from account number "+accN1+" to account number "+AccountNum);
                System.out.println("Your updated balance is:"+balance);
            }
            else
            {
                System.out.println("Invalid Account Number");
            }

        }
    }   
}

class History extends Authentication
{
    static void transactionHistory()
    {   if(balance>0)
        {
        ArrayList<String> l=new ArrayList<String>();
        l.add("Deposit:"+deposit_amount);
        l.add("Withdraw:"+withdraw_amount);
        l.add("Fund Transfer:"+transfer_amount);
        System.out.println("Transaction History:"+l);
        }
        else
        {
            System.out.println("Your account is empty");
        }
    }
}

class Execution extends Authentication
{
    static void details()
    {
        Scanner sc=new Scanner(System.in);
        Authentication.login();
        if(user_id.equals(user) && PinNum.equals(pin))
        {
            while(true)
            {
                System.out.println("\n ATM MACHINE\n");
                System.out.println("Choose 1 for Deposit\n"+"Choose 2 for Withdraw\n"+"Choose 3 for Balance\n"+"Choose 4 for Fund transfer\n"+"Choose 5 for Transaction History\n"+"Choose 6 for EXIT\n");
                System.out.print("Choose the operation:");
                int choice=sc.nextInt();
                Operation o=new Operation();
                History h=new History(); 
                switch(choice)
                {
                    case 1:o.deposit();
                           break;
                    case 2:o.withdraw();
                           break;
                    case 3:o.check_balance();
                           break;
                    case 4:o.fund_transfer();
                           break;
                    case 5:h.transactionHistory();
                           break;
                    case 6:System.exit(0);
                }
            }
        }
        else
        {
             System.out.println("Invalid User_id or Pin Number");
        }
    }
}

class AtmInterfaceTask
{
    public static void main(String args[])
    {
        Execution e=new Execution();
        e.details();
    }
}

