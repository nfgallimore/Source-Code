public class math
{
    public static void main(String[] args)
    {
        int a = 2 + 2 + 3 + 4; // 11
        String b = "2 + 2" + 3 + 4; // 2 + 234
        String c = 2 + " 2 + 3 " + 4; // 2 2 + 3 4
        String d = 3 + 4 + "2 + 2"; // 72 + 2
        String e = "2 + 2 " + (3 + 4); // 2 + 2 7
        String f = "(2 + 2) " + (3 + 4); // (2 + 2) 7
        String g = "hello 34 " + 2 * 4; // hello 34 8
        String h = 2 + "(int) 2.0" + 2 * 2 + 2; // 2(int) 2.042
        String i = 4 + 1 + 9 + "." + (-3 + 10) + 11 / 3; // 14.73
        String j = 8 + 6 * -2 + 4 + "0" + (2 + 5); // 007
        String k = 1 + 1 + "8 - 2" + (8 - 2) + 1 + 1; // 28 - 2611
        String l = 5 + 2 + "(1 + 1)" + 4 + 2 * 3; // 7(1 + 1)46
        String m = "1" + 2 + 3 + "4" + 5 * 6 + "7" + (8 + 9); // 123430717
        

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);
        
        
    }
}