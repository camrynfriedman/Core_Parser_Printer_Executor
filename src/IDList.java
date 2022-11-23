package src;

import java.util.ArrayList;

// <id list> ::= <id> | <id>, <id list>
public class IDList {
	private ID id;
	private IDList idList;
	private int altNo;

	public IDList() {
	}

	// TODO - implement
	public void parseIDList() {
		// calls parseID repeatedly
	}

	// TODO - implement
	public void printIDList() {
	}

	public ArrayList<ID> execIDList() {
		// return id + execIDList();
		ArrayList<ID> idArr = new ArrayList<ID>();
		idArr.add(id); // add ID (guaranteed to exist)
		if (altNo == 2) {
			// add idList to idArr
			idArr.addAll(idList.execIDList());
		}
		return idArr;
	}
}
