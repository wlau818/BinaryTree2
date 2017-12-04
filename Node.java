
public class Node {
	/*
	 * Copy your code for the Node class from the previous project here.
	 * Then modify the code so that the record field contains a string
	 * instead of an integer.
	 */
	
	public String record;
	public Node left, right;
	
	public Node(String newRecord) {
		record = newRecord;
		left = null;
		right = null;
	}
}
