package src;

// <exp> ::= <fac> | <fac> + <exp> | <fac> - <exp>
public class Exp {
	private int altNo;
	private Fac fac;
	private Exp exp;

	public Exp() {
	}

	// TODO - error checking
	public void parseExp() {
		// parse <fac>
		fac = new Fac();
		fac.parseFac();
		Main.t.skipToken(); // skips <fac>
		int tokNo = Main.t.getToken(); // can either be + or -
		if (tokNo == 22 || tokNo == 23) {
			exp = new Exp();
			exp.parseExp();
			if (tokNo == 22) {
				altNo = 2;
			} else if (tokNo == 23) {
				altNo = 3;
			}
		}
		Main.t.skipToken();
	}

	public void printExp() {
		if (altNo == 1) {
			fac.printFac();
		} else if (altNo == 2) {
			fac.printFac();
			System.out.print(" + ");
			exp.printExp();
		} else if (altNo == 3) {
			fac.printFac();
			System.out.print(" - ");
			exp.printExp();
		}
	}

	public int execExp() {
		int value = 0;
		value = fac.execFac(); // we exec the <fac> no matter which alternative
		if (altNo == 1) {
			value += exp.execExp();
		} else if (altNo == 2) {
			value -= exp.execExp();
		}
		return value;

	}
}
