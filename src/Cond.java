package src;

// <cond> ::= <comp> | !<cond> | [<cond> && <cond>] | [<cond> || <cond>]
public class Cond {
	private Comp comp;
	private Cond cond1;
	private Cond cond2; // only used if altNo == 3 or 4
	private int altNo;

	public Cond() {
	}

	public void parseCond() {
		int tokNo; // represents the next token in integer form, given the BNF
		tokNo = Main.t.getToken();
		// figure out which alternator it is
		if (tokNo == 20) {
			// comp -> set altNo = 1
			altNo = 1;
			comp = new Comp();
			comp.parseComp();
		} else if (tokNo == 15) {
			// negated condition -> set altNo = 2
			altNo = 2;
			cond1 = new Cond();
			cond1.parseCond(); // recursively call
		} else if (tokNo == 16) {
			// altNo = 3 or 4
			Main.t.skipToken(); // skips "["
			cond1 = new Cond();
			cond1.parseCond();
			Main.t.skipToken(); // skips cond
			tokNo = Main.t.getToken();
			if (tokNo == 18) {
				altNo = 3;
			} else if (tokNo == 19) {
				altNo = 4;
			}
			cond2 = new Cond();
			cond2.parseCond();
			Main.t.skipToken(); // skips "]"
		} else {
			throw new RuntimeException("Error: Invalid token.");
		}
	}

	public void printCond() {
		if (altNo == 1) {
			comp.printComp();
		} else if (altNo == 2) {
			System.out.println("!");
			cond1.printCond();
		} else if (altNo == 3) {
			cond1.printCond();
			System.out.print(" && ");
			cond2.printCond();
		} else if (altNo == 4) {
			cond1.printCond();
			System.out.print(" || ");
			cond2.printCond();
		}
	}

	public boolean execCond() {
		boolean bool = false;
		if (altNo == 1) {
			bool = comp.execComp();
		} else if (altNo == 2) {
			bool = !cond1.execCond();
		} else if (altNo == 3) {
			bool = cond1.execCond() && cond2.execCond();
		}
		return bool;
	}
}
