public class misp
{
    public static void main(String[] args)
    {
        newline();
        M();
        I();
        S();
        S();
        I();
        S();
        S();
        I();
        P();
        P();
        I();
    }
    /******************************
    // newline                   */
    public static void newline()
    {
        System.out.println("\n");
    }
    
    /************************************
    // M character                     */
    public static void M()
    {
        m();
        System.out.println("MM   MM");
        System.out.println("M M M M");
        System.out.println("M  M  M");
        for (int i = 0; i < 3; i++)
            m();
        newline();
    }
    // m functions
    public static void m()
    { 
        System.out.println("M     M");
    }
    
    /**********************************
    // I character                   */
    public static void I()
    {
        ilong();
        for (int i = 0; i < 5; i++)
            ishort();
            ilong();
        newline();
    }
    // i functions
    public static void ilong()
    {
        System.out.println(" IIIII");
    }
    public static void ishort()
    {
        System.out.println("   I  ");
    }
    
    /********************************
    // S character                 */
    public static void S()
    {
        s();
        shortS();
        System.out.println("S");
        s();
        System.out.println("      S");
        shortS();
        s();
        newline();
    }
    // s functions
    public static void s()
    {
        System.out.println(" SSSSS ");
    }
    public static void shortS()
    {
        System.out.println("S     S");
    }
    
    /**********************************
    // P character                   */
    public static void P()
    {
        p();
        p2();
        p2();
        p();
        p3();
        newline();
    }
    
    // p functions
    public static void p()
    {
        System.out.println("PPPPPP");
    }
    public static void p2()
    {
        System.out.println("P     P");
    }
    public static void p3()
    {
        for (int i = 0; i < 3; i++)
            System.out.println("P");
    }
                               

}
                           
