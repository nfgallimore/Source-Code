class Duck
{
    int size;
    
    // Now define Duck constructor
    Duck (int theSize)
    {
        size = theSize;
        System.out.println("A duck of size " + size + "has been born!");
    }
    
    // now define the Duck's behavior
    void quack()
    {
        System.out.println("Quack, quack!" + (char)7 + (char)7);
    }
}
