package src;

// <fac> ::= <op> | <op> * <fac>
public class Fac {
	private Op op;
	private Fac fac;
	private int altNo;

	public Fac() {

	}

	// TODO - error checking
	public void parseFac() {
		op = new Op();
		op.parseOp();
		// skip token???
		int tokNo = Main.t.getToken();
		if (tokNo == 24) {
			// must be <op> * <fac>
			altNo = 2;
			Main.t.skipToken();
			fac = new Fac();
			fac.parseFac();
		} else {
			altNo = 1;
		}
	}

	public void printFac() {
		op.printOp();
		if (altNo == 2) {
			System.out.print(" * ");
			fac.printFac();
		}
	}

	public int execFac() {
		int result = 0;
		if (altNo == 1) {
			result = op.execOp();
		} else if (altNo == 2) {
			result = op.execOp() * fac.execFac();
		}
		return result;
	}

}
