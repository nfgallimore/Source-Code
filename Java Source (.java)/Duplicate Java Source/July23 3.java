class July23
{
   public static void main (String [] args)
   {
       BankAccount henry;
       henry = new BankAccount ();

       henry.balance = 5000;

       henry.deposit (425);
       henry.withdraw (500);

       System.out.println ("current balance = "  + 
                            henry.getBalance() );

       Movie argo = new Movie (7, 9, 10);
       Movie lincoln = new Movie (9, 10, 9);
       Movie silverLinings = new Movie ();

       //argo.script = 7;
       //argo.directing = 9;
       //argo.acting = 10;

       System.out.println ("Rating of Argo = "  + argo.rating() );
       System.out.println ("Rating of Lincoln = " +
                               lincoln.rating() );
       System.out.println ("Rating of Silver Linings Playbook = " +
                              silverLinings.rating() );
   }
}
