import java.util.*;
class AccountDetails
{
  double AccountNumber=1234567890;
 double PinNumber=1234;
 public int NewAmount;
}
interface Atm
{
     void AccountDetails();
     void displayMenu();
     void withdrawing();
     void depositing();
     void checkthebalance();
     void exit();
}
class AtmMachine implements Atm
{
    Scanner sc=new Scanner(System.in);
    AtmMachine()
    {
        System.out.println("atm machine is ready to use");
    }
    private double balance=100000;
    boolean userexit=false;
    public void displayMenu()
    {
    System.out.println("=========================");
    System.out.println("welcome to atm machine");
    System.out.println("=========================");
    System.out.println("please insert the card");
    while(!userexit)
    {
    System.out.println("1.AccountDetails\n2.withdrawing\n3.depositing\n4.checkthebalance\n5.exit");
    System.out.println("choose the operation you want to perform:");
    int number=sc.nextInt();
    if(number>=1 && number<=5)
    {
    switch(number)
    {
    case 1:
    AccountDetails();
    break;
    case 2:
    withdrawing();
    break;
    case 3:
    depositing();
    break;
    case 4:
    checkthebalance();
    break;
    case 5:
    exit();
    break;
    default:
    {
    System.out.println("invalid option");
    System.out.println("please choose the correct option");
    displayMenu();
    }
    }
}
    }
    }
   public void AccountDetails()//overriding
    {
        System.out.println("enter the account number:");
        double AccountNumber=sc.nextDouble();
        if(AccountNumber==1234567890)
        {
            System.out.println("account number is valid");
        }
        else
        {
            System.out.println("invalid account number");
            System.out.println("try again");
            System.exit(0);
        }
        System.out.println("account number is valid");
        System.out.println("please enter the pin number");
        double PinNumber=sc.nextDouble();
        if(PinNumber==1234)
        {
            System.out.println("pin number is valid");
        }
        else
        {
            System.out.println("invalid pin number");
            System.out.println("try again");
            System.exit(0);
        }
        System.out.println("login successful");
    }
 public void PinNumber()//overriding
{
System.out.println("enter the pin number:");
int PinNumber=sc.nextInt();
if( PinNumber==1234)
{
    System.out.println("pin number is valid");
System.out.println("login successful");
}
else
{
System.out.println("login failed");
System.out.println("try again");
System.exit(0);
}
}
public void withdrawing()
{
System.out.println("enter the amount to withdraw:");
int withdrawAmount=sc.nextInt();
if(withdrawAmount<=balance)
{
System.out.println("please collect your cash"+withdrawAmount);
 balance-=withdrawAmount;
System.out.println("your remaining balance is:"+balance);
}
else
{
System.out.println("insufficient balance");
}
if(withdrawAmount>30000)
{
System.out.println("you can withdraw only 30000 at a time");
}
}
public void depositing()
{
System.out.println("enter the amount to deposit:");
int deposit=sc.nextInt();
if(deposit>0)
{
System.out.println("your amount is successfully deposited:"+deposit);
balance+=deposit;
System.out.println("your total balance is:"+balance);
}
else
{
System.out.println("invalid amount");
}
if(deposit>50000)
{
System.out.println("you can deposit only 50000 at a time");
}
}
public void checkthebalance()
{
System.out.println("your balance is:"+balance);
}
public void exit()
{
System.out.println("collect your atm card");
System.out.println("thank you for using atm machine");
}
}
 class AtmInterfaceimplementation
{
    public static void main(String args[])
    {
        AtmMachine a=new AtmMachine();
    a.displayMenu();
    }
}

