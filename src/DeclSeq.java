package src;

// <decl seq> ::= <decl> | <decl> <decl seq>
public class DeclSeq {
	private Decl decl;
	private DeclSeq declSeq;
	private int altNo;

	public DeclSeq() {
	}

	// TODO - error checking
	public void parseDS() {
		int tokNo;
		// parse the stmt
		decl = new Decl();
		decl.parseDecl();
		Main.t.skipToken(); // skips the decl
		/*
		 * if next token is an int, then we have another decl so we will set the altNo
		 * to 2 and recursively parse the declSeq
		 */
		tokNo = Main.t.getToken();
		if (tokNo == 31) {
			altNo = 2;
			declSeq = new DeclSeq();
			declSeq.parseDS();
		}
		Main.t.skipToken();
	}

	public void printDS() {
		decl.printDecl();
		if (altNo == 2) {
			declSeq.printDS();
		}
	}

	public void execDS() {
		decl.execDecl();
		if (altNo == 2) {
			declSeq.execDS();
		}
	}

}
