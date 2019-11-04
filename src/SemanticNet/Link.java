package SemanticNet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Link {
	static ArrayList<String> labels = new ArrayList<String>();
	String label;
	Node tail;
	Node head;
	boolean inheritance;

	Link(String theLabel, String theTail,
			String theHead, SemanticNet sn) {
		int i=-1;
		if((i=labels.indexOf(theLabel))!=-1)
			label=labels.get(i);
		else {
			label = theLabel;
			labels.add(label);
		}
		HashMap<String, Node> nodesNameTable = sn.getNodesNameTable();
		ArrayList<Node> nodes = sn.getNodes();

		tail = (Node) nodesNameTable.get(theTail);
		if (tail == null) {
			tail = new Node(theTail);
			nodes.add(tail);
			nodesNameTable.put(theTail, tail);
		}

		head = (Node) nodesNameTable.get(theHead);
		if (head == null) {
			head = new Node(theHead);
			nodes.add(head);
			nodesNameTable.put(theHead, head);
		}
		inheritance = false;
	}

	// For constructing query.
	Link(String theLabel, String theTail, String theHead) {
		label = theLabel;
		tail = new Node(theTail);
		head = new Node(theHead);
		inheritance = false;
	}

	public void setInheritance(boolean value) {
		inheritance = value;
	}

	public Node getTail() {
		return tail;
	}

	public Node getHead() {
		return head;
	}

	public String getLabel() {
		return label;
	}

	public String getFullName() {
		return tail.getName() + " " + label + " " + head.getName();
	}

	public String toString() {
		String result = tail.getName() + "  =" + label + "=>  " + head.getName();
		if (!inheritance) {
			return result;
		} else {
			return "( " + result + " )";
		}
	}

	public static boolean LabelContains(String label) {
		return labels.contains(label);
	}
	
	public boolean HasSameWord(List<Link> links) {
		String s1 = getHead().toString().startsWith("?")?getHead().toString():getTail().toString();
		for (Link link : links) {
			String s2 = link.getHead().toString().startsWith("?")?link.getHead().toString():link.getTail().toString();
			if(s1.equals(s2))
				return true;
		}
		return false;
	}
}
