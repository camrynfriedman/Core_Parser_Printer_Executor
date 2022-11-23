package src;

// <assign> ::= <id> = <exp>;
public class Assign {
	private ID id;
	private Exp e;

	public Assign() {
	}

	// TODO - implement and error checking
	public void parseAssign() { // check if ID with given name already exists
		// Assign is called by stmt, so the key for parseID would be 1
		id = ID.parseID(0);

	}

	public void printAssign() {
		id.printID();
		System.out.print(" = ");
		e.printExp();
		System.out.print(";");
	}

	// TODO - implement
	public void execAssign() {
		// update ID value

	}

}
