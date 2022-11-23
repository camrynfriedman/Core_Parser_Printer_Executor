package src;

// <stmt seq> ::= <stmt> | <stmt> <stmt seq>
public class StmtSeq {
	private Stmt s1;
	private StmtSeq ss1;
	private int altNo; // alternator number, determines what is called

	public StmtSeq() {
	}

	// TODO - error checking
	public void parseSS() {
		int tokNo;
		// parse the stmt
		s1 = new Stmt();
		s1.parseStmt();
		Main.t.skipToken(); // skips the stmt
		/*
		 * if next token is an ID, "loop", "if", "read", or "write", then we have
		 * another stmt so we will set the altNo to 2 and recursively parse the stmtSeq
		 */
		tokNo = Main.t.getToken();
		if (tokNo == 32 || tokNo == 9 || tokNo == 5 || tokNo == 10 || tokNo == 11) {
			altNo = 2;
			ss1 = new StmtSeq();
			ss1.parseSS();
		}
	}

	public void printSS() {
		s1.printStmt();
		if (altNo == 2) {
			ss1.printSS();
		}
	}

	public void execSS() {
		s1.execStmt();
		if (altNo == 2) {
			ss1.execSS();
		}

	}
}
