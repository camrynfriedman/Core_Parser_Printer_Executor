package src;

// <comp op> ::= != | == | < | > | <= | >=
public class CompOp {
	private int altNo;
	public int tokNo;

	public CompOp() {
	}

	public void parseCompOp() {
		tokNo = Main.t.getToken();
		if (tokNo == 25) {
			altNo = 1;
		} else if (tokNo == 26) {
			altNo = 2;
		} else if (tokNo == 27) {
			altNo = 3;
		} else if (tokNo == 28) {
			altNo = 4;
		} else if (tokNo == 29) {
			altNo = 5;
		} else if (tokNo == 30) {
			altNo = 6;
		} else {
			throw new RuntimeException("Error: invalid token.");
		}
		Main.t.skipToken(); // skips the token
	}

	public void printCompOp() {
		if (altNo == 1) {
			System.out.print("!=");
		} else if (altNo == 2) {
			System.out.print("==");
		} else if (altNo == 3) {
			System.out.print("<");
		} else if (altNo == 4) {
			System.out.print(">");
		} else if (altNo == 5) {
			System.out.print("<=");
		} else if (altNo == 6) {
			System.out.print(">=");
		}
	}

	public int execCompOp() {
		return tokNo;
	}

}
