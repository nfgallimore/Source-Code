public class Bool
{
    public static void main(String[] args)
    {
        int age, height, weight;
        boolean isASmoker = false;
        boolean isGoodLooking = true;
        boolean isAbleToRelocate = true;
        age = 22;
        height = 71;
        weight = 159;
        
        if (age >= 22 && age <= 30 && !isASmoker && height < 72 && weight < 160 && isGoodLooking && isAbleToRelocate)
            System.out.println("Marry me!");
        else System.out.println("Get Lost!");
    }
}
