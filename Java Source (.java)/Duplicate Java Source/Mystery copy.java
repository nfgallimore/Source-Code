class Mystery
{
    public static void main(String [] args)
    {
        String major = "fred";
        String fred = "computer";
        String computer = "department";
        String department = "student";
        String student = "major";
        
        sentence (major, fred, department);
        sentence (student, computer, fred);
        sentence ("Fred", "honor", computer);
        sentence ("foo", "bar", "baz");
        sentence (fred, computer, student);
    }
    
    public static void sentence (String major, String fred, String foo)
    {
        System.out.println("Many a " + foo + " in the " + fred + " of " + major);
    }
}
