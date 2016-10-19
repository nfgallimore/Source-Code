class BankAccount
{
    // first define instance variables

    String owner;
    double balance;
    double interestRate;

    // second, we define instance methods
    double getBalance()
    {
       return balance;
    }

    void deposit (double amount)
    {
        balance += amount;
    }

    void withdraw (double amount)
    {
        if (balance >= amount) balance -= amount;
        else System.out.println ("You can't do that!");
    }
 }   


