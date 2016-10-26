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
			else if (ch != '-') {
				ls.add(ch - 48);
			}
		}
		stringReader.close();
		if (s.length() > 0 && s.charAt(0) == '-') {
			this.positive = false;
			s = s.substring(1, s.length() - 1);
		}
		this.str = s;
	}
	public String str = "";

	public String getStr() {
	    Iterator iter = this.ls.iterator();
	    String s = "";
	    if (!this.positive) {
	    	s += '-';
	    }
	    while(iter.hasNext()){
	        s += iter.next();
	    }
	    this.str = s;
	    cleanStr();
	    return this.str;
	}
	public Boolean positive = true;

	public BigInt add(BigInt b) throws IOException {
		long s = 0, c = 0;
		BigInt sum = new BigInt("");
		Iterator iterA = listReverse(this.ls).iterator();
		Iterator iterB = listReverse(b.ls).iterator();

		// if this is negative and b is positive
		if (!this.positive && b.positive) {
			// if absval of this is greater than absval of b
			if (b.lessThan(this)) {
				this.positive = true;
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
				b.positive = true;
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
		sum = sum.cleanZeroes();
		return sum;
	}

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
			diff.positive = false;
			iterA = iterB;
			iterB = listReverse(this.ls).iterator();
		} 
		else if (!this.positive && bInt.positive) {
			this.positive = true;
			diff = this.add(bInt);
			diff.positive = false;
			return diff;
		}
		else if (!this.positive && !bInt.positive) {
			bInt.positive = true;
			return this.add(bInt);
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
		if (this.lessThan(bInt)) {
			diff.positive = false;
		}
		diff.ls = listReverse(diff.ls);
		diff = diff.cleanZeroes();
		return diff;
	}
	private BigInt cleanZeroes() {
		if (this.positive) {
			while (this.ls.size() > 1 && this.ls.get(0) == 0) {
				this.ls.removeFirst();
			}
		}
		else {
			while (this.ls.size() > 2 && this.ls.get(0) == 0) {
				this.ls.removeFirst();
			}
		}
		return this;
	}
	private void cleanZeroes(LinkedList<Long> list) {
		while (list.size() > 1 && list.get(0) == 0) {
			list.removeFirst();
		}
	}
	private String cleanStr() {
		String list = this.str;
		Boolean negative = false;
		if (list.length() > 0 && list.charAt(0) == '-') {
			negative = true;
		}
		while (list.length() > 0 && (list.charAt(0) == '0' || list.charAt(0) == '-')) {
			list = list.substring(1, list.length());
		}
		if (negative) {
			list = '-' + list;
		}
		this.str = list;
		return list;
	}
	public BigInt multiply(BigInt b) throws IOException {
		BigInt product = new BigInt("");
		for (BigInt i = b; !i.equal(new BigInt("0")); i = i.subtract(new BigInt("1"))) {
			product = product.add(this);
		}
		return product;
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
	
	private LinkedList listReverse(LinkedList list) {
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
				
				if (this.ls.get(i) < b.ls.get(i)) {
					return true;
				}
				else if (this.ls.get(i) > b.ls.get(i)) {
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