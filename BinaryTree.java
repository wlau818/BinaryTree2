
public class BinaryTree {
	/*
	 * Copy your code for the BinaryTree class from the previous project.
	 * Then modify the code so that it handles records that are strings
	 * rather than integers.
	 *
	 * Be particularly careful of comparisons and tests for equality.
	 * Be sure to use the appropriate string methods rather than
	 * ==, <, >, etc.
	 */
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void insert(String word) {
		root = subtreeInsert(root, word);
	}
	
	private Node subtreeInsert(Node topNode, String word) {
		if (topNode == null) {
			topNode = new Node(word);
		} else if (word.compareTo(topNode.record) <= 0) {
			topNode.left = subtreeInsert(topNode.left, word);
		} else {
			topNode.right = subtreeInsert(topNode.right, word);
		}
		return topNode;
	}
	
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);			
			preOrderSubtree(topNode.right);
		}
	}
	
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.left);			
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}
	
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int i = subtreeSize(topNode.left);
			int j = subtreeSize(topNode.right);
			return i + j + 1;
		}
	}
	
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int left = subtreeMaxDepth(topNode.left);
			int right = subtreeMaxDepth(topNode.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}
	
	public int minDepth() {
		return subtreeMinDepth(root);
	}
	
	private int subtreeMinDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int left = subtreeMinDepth(topNode.left);
			int right = subtreeMinDepth(topNode.right);
			if (left < right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}
	
	public int countMatches(String key) {
		return subtreeCountMatches(root, key);
	}
	
	private int subtreeCountMatches(Node topNode, String key) {
		int num = 0;
		if (topNode == null) {
			return 0;
		} else {
			int i = subtreeCountMatches(topNode.left, key);
			int j = subtreeCountMatches(topNode.right, key);
			if(topNode.record.equalsIgnoreCase(key)) {
				num ++;
			}
			return num + i + j;
		}
	}

	public String maxRecord() {
		return subtreeMaxRecord(root);
	}
	
	private String subtreeMaxRecord(Node topNode) {
		if (topNode == null) {
			return null;
		} else {
			String i = topNode.record;
			if (topNode.right != null) {
				i = subtreeMaxRecord(topNode.right);
			} 
			return i;
		}
	}
	
	public String minRecord() {
		return subtreeMinRecord(root);
	}
	
	private String subtreeMinRecord(Node topNode) {
		if (topNode == null) {
			return null;
		} else {
			String i = topNode.record;
			if (topNode.left != null) {
				i = subtreeMinRecord(topNode.left);
			} 
			return i;
		}
	}
	
}
