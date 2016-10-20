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
	    if (!this.positive) {
	    	str += '-';
	    }
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

		if (!this.positive && b.positive) {
			if (this.greaterThan(b)) {
				sum = this.subtract(new BigInt(b.getStr()));
				sum.positive = false;
				return sum;
			}
			else {
				return b.subtract(this);
			}

		}
		else if (this.positive && !b.positive) {
			if (this.lessThan(b)) {
				sum = b.subtract(this);
				sum.positive = false;
				return sum;
			}
			else {
				sum = this.subtract(b);
				return sum;
			}
		}
		else {
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
			if (c != 0) {
				sum.ls.add(c);
			}
			sum.ls = listReverse(sum.ls);
		}
		if (!this.positive && !b.positive) {
			sum.positive = false;
		}
		return sum;
	}

	public Boolean positive = true;
	public Boolean neg() {
		positive = !positive;
		return positive;
	}

	public BigInt subtract(BigInt bInt) throws IOException {
		long d = 0, b = 0;
		BigInt diff = new BigInt("");
		Iterator iterA = listReverse(this.ls).iterator();
		Iterator iterB = listReverse(bInt.ls).iterator();
		if (this.lessThan(bInt)) {
			diff.neg();
			iterA = iterB;
			iterB = listReverse(this.ls).iterator();
		} 
		else {
			diff.positive = true;
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
		cleanZeroes(diff.ls);
		return diff;
	}
	private void cleanZeroes() {
		while (this.ls.get(0) == 0) {
			this.ls.removeFirst();
		}
	}
	private void cleanZeroes(LinkedList<Long> list) {
		while (list.get(0) == 0) {
			list.removeFirst();
		}
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

	public Boolean equal(BigInt b) {
		return Objects.equals(this.getStr(), b.getStr());
	}
	// absolute value!
	public Boolean lessThan(BigInt b) {
		if (this.ls.size() < b.ls.size()) {
			return true;
		}
		else if (this.ls.size() == b.ls.size()) {
			for (int i = 0; i < this.ls.size(); i++) {
				if (this.getStr().charAt(i) < b.getStr().charAt(i)) {
					return true;
				}
				else if (this.getStr().charAt(i) > b.getStr().charAt(i)) {
					return false;
				}
			}
			return false;
		}
		else {
			return false;
		}
	}

	public boolean greaterThan(BigInt b) {
		return (!lessThan(b) && !equal(b));
	}
}