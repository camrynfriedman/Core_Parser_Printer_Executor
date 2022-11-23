package src;

// <loop> ::= while <cond> loop <stmt seq> end;
public class Loop {
	private Cond c;
	private StmtSeq ss;

	public Loop() {
	}

	// TODO - error checking
	public void parseLoop() {
		Main.t.skipToken(); // skips "while"
		c = new Cond();
		c.parseCond();
		Main.t.skipToken(); // skips "loop"
		ss = new StmtSeq();
		ss.parseSS();
		Main.t.skipToken(); // skips "end"
		Main.t.skipToken(); // skips ";"
	}

	public void printLoop() {
		System.out.println("while ");
		c.printCond();
		System.out.print("loop ");
		ss.printSS();
		System.out.print("end;");
	}

	public void execLoop() {
		boolean bool = c.execCond();
		while (bool) {
			ss.execSS();
			bool = c.execCond();
		}
	}

}
