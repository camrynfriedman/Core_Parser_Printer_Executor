package src;

// <if> ::= if <cond> then <stmt seq> end; | if <cond> then <stmt seq> else <stmt seq> end;
public class If {
	private Cond c;
	private StmtSeq ss1;
	private StmtSeq ss2; // only used if altNo == 2
	private int altNo;

	public If() {
	}

	// TODO - error checking
	public void parseIf() {
		int tokNo; // represents the next token in integer form, given the BNF
		Main.t.skipToken(); // skips "if"
		c = new Cond();
		c.parseCond();
		Main.t.skipToken(); // skips "then"
		ss1 = new StmtSeq();
		ss1.parseSS();

		// next token could be "end" or "else". check and set altNo accordingly
		tokNo = Main.t.getToken();
		if (tokNo == 3) {
			// "end" token found. skip token twice
			Main.t.skipToken(); // skips "end"
			Main.t.skipToken(); // skips ";"
		} else if (tokNo == 7) {
			// "else" token found. continue parsing.
			Main.t.skipToken(); // skips "else"
			ss2 = new StmtSeq();
			ss2.parseSS();
			Main.t.skipToken(); // skips "end"
			Main.t.skipToken(); // skips ";"
		}
	}

	public void printIf() {
		if (altNo == 1) {
			System.out.print("if ");
			c.printCond();
			System.out.print("then ");
			ss1.printSS();
		} else if (altNo == 2) {
			System.out.print("if ");
			c.printCond();
			System.out.print("then ");
			ss1.printSS();
			System.out.print("else ");
			ss2.printSS();
			System.out.print("end; ");
		}
	}

	public void execIf() {
		boolean bool = c.execCond();
		if (bool) {
			ss1.execSS();
		} else {
			ss2.execSS();
		}
	}
}
