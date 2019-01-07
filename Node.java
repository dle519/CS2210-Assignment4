/**
 * Node for storing records in OrderedDictionary
 * @author David Le
 *
 */
public class Node {
	private Node left, right;
	private Record element;
	
	public Node(){
		this.element = null;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Creates a node storing an element of type Record and 2 children with null nodes
	 * @param elem
	 */
	public Node(Record elem) {
		this.element = elem;
		this.left = new Node();
		this.right = new Node();
	}
	/**
	 * Returns the left child of this node
	 * @return the left child of this node.
	 */
	public Node getLeft() {
		return left;
	}
	/**
	 * Returns the right child of this node
	 * @return the right child of this node
	 */
	public Node getRight() {
		return right;
	}
	/**
	 * Sets the left child of this node with the given Node
	 * @param n
	 */
	public void setLeft(Node n) {
		this.left = n;
	}
	/**
	 * Sets the right child of this node with the given Node
	 * @param n
	 */
	public void setRight(Node n) {
		this.right = n;
	}
	/**
	 * Returns the element stored
	 * @return
	 */
	public Record getElement() {
		return this.element;
	}
	/**
	 * Checks if the current node is a leaf
	 * @return True for leaf, false otherwise
	 */
	public boolean isLeaf() {
		// If the children are null; then its leaf
		if (left == null && right == null) {
			return true;
		}
		return false;
	}
	
}
