public class Longer
{
    public static void main (String[] args)
    {
        String[] a1 = { "star", "pie", "jelly bean", "car"};
        String[] a2 = { "cookie", "fig", "bannana", "soda" };
        longer(a1, a2);
    }
    static String[] longer (String[] a1, String[] a2)
    {
        int length1 = a1.length; int length2 = a2.length; int diff; int length;
        if (length1 > length2)
            { diff = length1 - length2; length = length1; }
        else { diff = 0; length = length1; }
        String[] a3 = new String[length];
        for (int i = 0; i < length - diff; i++) {
            int one = a1[i].length; int two = a2[i].length;
            if (one >= two) a3[i] = a1[i];
            else a3[i] = a2[i];
        }
        for (int i = 0; i < diff; i++)
            a3[length - diff + i] = "oops";
        return a3;
    }
}