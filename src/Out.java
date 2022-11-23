package src;

import java.util.ArrayList;

// <out> ::= write <id list>;
public class Out {
	private IDList idList;

	public Out() {
	}

	public void parseOut() {
		int tokNo = Main.t.getToken();
		if (tokNo != 11) {
			throw new RuntimeException("Error: invalid token. Expected  \"write\".");
		} else {
			Main.t.skipToken(); // skips "write"
			idList.parseIDList();
			Main.t.skipToken(); // skips ";"
		}
	}

	public void printOut() {
		System.out.println("write ");
		idList.printIDList();
		System.out.print(";");
	}

	public void execOut() {
		ArrayList<ID> idArr = new ArrayList<ID>();
		idArr = idList.execIDList();
		for (ID id : idArr) {
			System.out.println(id + " = " + id.getIDVal());
		}
	}
}
