package src;

// <decl> ::= int <id list>;
public class Decl {
	private IDList idList;

	public Decl() {
	}

	public void parseDecl() {
		int tokNo = Main.t.getToken();
		if (tokNo == 4) {
			Main.t.skipToken(); // skips "int"
		} else {
			throw new RuntimeException("Error: Invalid token. Terminating.");
		}
		tokNo = Main.t.getToken();
		if (tokNo == 5) {
			idList = new IDList();
			idList.parseIDList();
			Main.t.skipToken(); // skips <id list>
		}
		Main.t.skipToken(); // skips ";"
	}

	public void printDecl() {
		System.out.println("int ");
		idList.printIDList();
		System.out.print("; ");
	}

	// TODO - implement
	public void execDecl() {
		// update eIDs
	}
}
