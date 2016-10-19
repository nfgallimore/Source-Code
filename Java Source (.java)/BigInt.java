import java.util.*;
import java.lang.*;
import java.io.StringReader;
import java.io.*;
public class BigInt {

	public final long BASE = 10;

	public LinkedList<Long> ls = new LinkedList<Long>();

	public BigInt(String s) throws IOException {
		StringReader stringReader = new StringReader(s);
		long ch;
		while (stringReader.ready()) {
			ch = stringReader.read();
			if (ch < 0) {
				break;
			}
			else {
				ls.add(ch - 48);
			}
		}
		stringReader.close();
	}

	public String getStr() {
	    Iterator iter = this.ls.iterator();
	    String str = "";
	    while(iter.hasNext()){
	        str += iter.next();
	    }
	    return str;
	}

	public BigInt add(BigInt b) throws IOException {
		long s = 0, c = 0;
		BigInt sum = new BigInt("");
		Iterator iterA = listReverse(this.ls).iterator();
		Iterator iterB = listReverse(b.ls).iterator();
		while (iterA.hasNext() || iterB.hasNext()) {
			long j, k;
			if (iterA.hasNext()) {
				j = Long.valueOf(iterA.next().toString());
			}
			else {
				j = 0;
			}
			if (iterB.hasNext()) {
				k = Integer.valueOf((String)iterB.next().toString());
			}
			else {
				k = 0;
			}
			s = j + k + c;
			if (s < BASE) {
				c = 0;
			}
			else {
				c = 1;
				s -= BASE;
			}
			sum.ls.add(s);
		}
		sum.ls = listReverse(sum.ls);
		return sum;
	}

	public Boolean positive = true;

	public Boolean neg() {
		this.positive = !positive;
		return this.positive;
	}

	public BigInt subtract(BigInt bInt) throws IOException {
		long d = 0, b = 0;
		BigInt diff = new BigInt("");
		Iterator iterA = listReverse(this.ls).iterator();
		Iterator iterB = listReverse(bInt.ls).iterator();
		
		Boolean cBigger;

		if ((this.getStr().length() > bInt.getStr().length()) && (this.getStr().length() != bInt.getStr().length())) {
			iterA = listReverse(this.ls).iterator();
			iterB = listReverse(bInt.ls).iterator();
		}
		else if (this.getStr().length() == bInt.getStr().length()) {
			for (int i = 0; i < this.getStr().length(); i++) {
				char cDigit = this.getStr().charAt(i);
				char dDigit = bInt.getStr().charAt(i);
				if (cDigit != dDigit) {
					if (cDigit < dDigit) {
						cBigger = true;
						iterA = listReverse(this.ls).iterator();
						iterB = listReverse(bInt.ls).iterator();
					}
					else {
						iterA = listReverse(bInt.ls).iterator();
						iterB = listReverse(this.ls).iterator();
						this.neg();
					}
				}
			}
		}
		else {
			iterA = listReverse(bInt.ls).iterator();
			iterB = listReverse(this.ls).iterator();
			this.neg();
		}

		while (iterA.hasNext() || iterB.hasNext()) {
			long j, k;
			if (iterA.hasNext()) {
				j = Long.valueOf(iterA.next().toString());
			}
			else {
				j = 0;
			}
			if (iterB.hasNext()) {
				k = Integer.valueOf((String)iterB.next().toString());
			}
			else {
				k = 0;
			}
			if (j - k - b < 0) {
				d = j - k - b + BASE;
				b = 1;
			}
			else {
				d = j - k - b;
				b = 0; 
			}
			diff.ls.add(d);
		}
		diff.ls = listReverse(diff.ls);
		return diff;
	}
	
	private long longPow(long a, long b) {
		for (long i = 0; i < b; i++) {
			a *= a;
		}
		return a;
	}
	
	public BigInt pow(BigInt x) throws IOException {
		return new BigInt("");
	}
	
	public LinkedList listReverse(LinkedList list) {
		Iterator iter = list.iterator();
		LinkedList revList = new LinkedList<Long>();
		while (iter.hasNext()) {
			revList.add(0, iter.next());
		}
		return revList;
	}
}