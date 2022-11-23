package src;

import java.util.HashMap;
import java.util.Map;

public class ID {
	private String name;
	private int val;
	private boolean initialized;

	private static Map<String, Integer> eIDs = new HashMap<String, Integer>(); // stores the existing IDs

	private ID(String n) {
		name = n;
	}

	/*
	 * @param key - if 0 then parseID was called by declSeq, if 1 then it was called
	 * by stmtSeq
	 */
	public static ID parseID(int key) {
		String idName;
		ID idObj = null;
		int tokNo = Main.t.getToken(); // get token
		if (tokNo == 32) {
			idName = Main.t.idName(); // get string associated with ID (var name)
			// figure out the context in which parseID was called (stmtSeq vs. declSeq)
			if (key == 0) {
				// called by declSeq
				// look for double declaration error
				if (!eIDs.containsKey(idName)) {
					idObj = new ID(idName);
					idObj.initialized = false;
					eIDs.put(idName, null);
				} else {
					// throw double declaration error
					throw new RuntimeException("Error: Doubly-declared variable.");
				}
			} else if (key == 1) {
				// called by stmtSeq
				// check uninitialized ID
				if (eIDs.containsKey(idName)) {
					idObj = new ID(idName);
				} else {
					// throw undeclared error
					throw new RuntimeException("Error: Undeclared variable.");
				}
			}
		}
		return idObj;
	}

	public int getIDVal() {
		// check if initialized
		return val;
	}

	public void setIDVal(int value) {
		val = value;
	}

	public void setIDName(String idName) {
		name = idName;
	}

	// TODO - implement
	public void printID() {

	}

}
