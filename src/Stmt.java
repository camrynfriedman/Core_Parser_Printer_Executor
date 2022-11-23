package src;

// <stmt> ::= <assign>|<if|<loop>|<in>|<out>
public class Stmt {
	private int altNo; // alternator number, determines what is called
	private Assign s1;
	private If s2;
	private Loop s3;
	private In s4;
	private Out s5;

	public Stmt() {
	}

	public void parseStmt() {
		int tokNo = Main.t.getToken();
		if (tokNo == 7) {
			altNo = 1; // assign
			s1 = new Assign();
			s1.parseAssign();
		} else if (tokNo == 8) {
			altNo = 2; // if
			s2 = new If();
			s2.parseIf();
		} else if (tokNo == 9) {
			altNo = 3; // loop
			s3 = new Loop();
			s3.parseLoop();
		} else if (tokNo == 10) {
			altNo = 4; // in
			s4 = new In();
			s4.parseIn();
		} else if (tokNo == 11) {
			altNo = 5; // out
			s5 = new Out();
			s5.parseOut();
		} else {
			throw new RuntimeException("Error: Invalid token. Expected type <assign>, <if>, <loop>, <in>, or <out>.");
		}
	}

	public void printStmt() {
		if (altNo == 1) {
			s1.printAssign();
		} else if (altNo == 2) {
			s2.printIf();
		} else if (altNo == 3) {
			s3.printLoop();
		} else if (altNo == 4) {
			s4.printIn();
		} else if (altNo == 5) {
			s5.printOut();
		}
	}

	public void execStmt() {
		if (altNo == 1) {
			s1.execAssign();
		} else if (altNo == 2) {
			s2.execIf();
		} else if (altNo == 3) {
			s3.execLoop();
		} else if (altNo == 4) {
			s4.execIn();
		} else if (altNo == 5) {
			s5.execOut();
		}
	}

}