public class setBit(int n) // 
{
    int whichByte = n / 8;
    int whichBit = n % 8;
    byteArray[whichByte] |= (1 << whichBit);
}
public static boolean getBit (int n) // Returns the n'th bit value
{
	int whichByte = n / 8;
	int whichBit = n % 8;
	return ((byteArray[whichByte] & (| << whichBit)) != 0);
}

public static void clearBit (int n)
{
	int whichByte = n / 8;
	int whichBit = n % 8;
	byteArray[whichByte] &= ((| << whichBit) ^ 255)''
}