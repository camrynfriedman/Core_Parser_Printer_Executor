package src;

// <prog> ::= program <decl seq> begin <stmt seq> end
public class Prog {

	private DeclSeq ds;
	private StmtSeq ss;

	public Prog() {
	}

	public void parseProg() {
		int tokNo = Main.t.getToken();
		if (tokNo != 1) {
			throw new RuntimeException("Error: Program does not exist.");
		} else {
			// we are at "program"
			Main.t.skipToken(); // skips "program"
			ds = new DeclSeq();
			ds.parseDS();
			tokNo = Main.t.getToken(); // expecting this to be = 2
		}
		if (tokNo != 2) {
			throw new RuntimeException("Error: Missing \"begin\" token.");
		} else {
			// we are at "begin"
			Main.t.skipToken(); // skips "begin"
			ss = new StmtSeq();
			ss.parseSS();
		}
		Main.t.skipToken(); // skips "end"
	}

	public void printProg() {
		System.out.println("program ");
		ds.printDS();
		System.out.print(" begin ");
		ss.printSS();
		System.out.print(" end");
	}

	public void execProg() {
		ss.execSS();
		ds.execDS();
	}

}
