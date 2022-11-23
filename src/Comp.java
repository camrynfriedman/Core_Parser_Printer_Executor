package src;

// <comp> ::= (<op> <comp op> <op>)
public class Comp {
	private Op op1;
	private CompOp compOp;
	private Op op2;

	public Comp() {
	}

	// TODO - error checking
	public void parseComp() {
		op1 = new Op();
		op2 = new Op();
		compOp = new CompOp();
		Main.t.skipToken(); // skips "("
		op1.parseOp();
		compOp.parseCompOp();
		op2.parseOp();
		Main.t.skipToken(); // skips ")"
	}

	public void printComp() {
		System.out.println("(");
		op1.printOp();
		compOp.printCompOp();
		op2.printOp();
		System.out.print(")");
	}

	public boolean execComp() {
		int op1_val = op1.execOp();
		int op2_val = op2.execOp();
		boolean result = false;
		int compOp_tokNo = compOp.execCompOp();
		// this assumes that the token number is one that represents an compOp symbol
		if (compOp_tokNo == 25) {
			result = op1_val != op2_val;
		} else if (compOp_tokNo == 26) {
			result = op1_val == op2_val;
		} else if (compOp_tokNo == 27) {
			result = op1_val < op2_val;
		} else if (compOp_tokNo == 28) {
			result = op1_val > op2_val;
		} else if (compOp_tokNo == 29) {
			result = op1_val <= op2_val;
		} else if (compOp_tokNo == 30) {
			result = op1_val >= op2_val;
		}
		return result;
	}

}
