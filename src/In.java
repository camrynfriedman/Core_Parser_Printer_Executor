package src;

// <in> ::= read <id list>;
public class In {
	private IDList idList;
	// need input stream

	public In() {
	}

	public void parseIn() {
		// make sure it's a read token
		// create new id list
		// parse id list
		int tokNo = Main.t.getToken();
		if (tokNo != 10) {
			throw new RuntimeException("Error: invalid token.");
		} else {
			idList = new IDList();
			idList.parseIDList();
		}

	}

	public void printIn() {
		System.out.println("read ");
		idList.printIDList();
		System.out.print(";");
	}

	// d
	public void execIn() {
		// read from data file (2nd input file)
		// if the value changes then we need tochange the value

		// must have access to data file
	}

}
