package src;

// <op> ::= <int> | <id> | (<exp>)
public class Op {
	private ID id;
	private Exp exp;
	private int altNo;

	public Op() {
	}

	// TODO - finish implementing and error checking
	public void parseOp() {
		int tokNo = Main.t.getToken();
		if (tokNo == 31) {
			// TODO - parseInt is not really a method so what do I do
			// intVal in tokenizer duh
			altNo = 1;
		} else if (tokNo == 32) {
			// parseID
			id = ID.parseID(1); // 1 bc derived from stmtSeq
			altNo = 2;
		} else if (tokNo == 20) {
			Main.t.skipToken(); // skips "("
			exp = new Exp();
			exp.parseExp();
			Main.t.skipToken(); // skips ")"
		}
	}

	public void printOp() {
		if (altNo == 1) {
			System.out.print(Main.t.intVal());
		} else if (altNo == 2) {
			id.printID();
		} else if (altNo == 3) {
			exp.printExp();
		}
	}

	public int execOp() {
		int op = 0;
		if (altNo == 1) {
			op = Main.t.intVal();
		} else if (altNo == 2) {
			op = id.getIDVal();
		} else if (altNo == 3) {
			op = exp.execExp();
		}
		return op;

	}

}
