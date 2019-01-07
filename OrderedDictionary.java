
public class OrderedDictionary implements OrderedDictionaryADT {
	private Node root;

	public OrderedDictionary() {
		root = new Node();
	}

	@Override
	/**
	 * Returns the Record object with key k, or it returns null if such a record is
	 * not in the dictionary.
	 */
	public Record get(Pair k) {
		// If the desired object is not in the dictionary
		if (root.getElement() == null) {
			return null;
		} 
		
		else {
			Node current = root;
			Pair current_key = current.getElement().getKey();
			Node x = getRecursive(root.getElement().getKey(), root);
			return x.getElement();
			// If the desired node is smaller than the current node
			/*if (!(current_key.equals(k)) && (current.getLeft() != null) && (k.compareTo(current_key) < 0)) {
				current = getRecursive(k, current.getLeft());
			}
			// If the desired node is greater than the current node
			else if (!(current_key.equals(k) && (current.getRight() != null) && (k.compareTo(current_key) > 0))) {
				current = getRecursive(k, current.getRight());
			}
			return current.getElement();*/
		}
	}

	/**
	 * Recursive function for the get method to find if the desired object is
	 * smaller or greater than the current node.
	 * 
	 * @param k        Desired object to be found in the tree
	 * @param nextNode Left or right node to be chosen
	 * @return The node containing the desired object or null if not in the
	 *         dictionary
	 */
	private Node getRecursive(Pair k, Node nextNode) {
		if (nextNode.isLeaf()) {
			return nextNode;
		} 
		else {
			Node current = nextNode;
			Pair current_key = current.getElement().getKey();
			if (current_key.equals(k)){
				return current;
			}
			// If the desired node is smaller than the current node
			else if (!(current_key.equals(k)) && (current.getLeft() != null) && (k.compareTo(current_key) < 0)) {
				return current = getRecursive(k, current.getLeft());
			}
			// If the desired node is greater than the current node
			else if (!(current_key.equals(k) && (current.getRight() != null) && (k.compareTo(current_key) > 0))) {
				return current = getRecursive(k, current.getRight());
			}
			return current;
		}
	}

	@Override
	/**
	 * Inserts r into the ordered dictionary. It throws a DictionaryException if a
	 * record with the same key as r is already in the dictionary.
	 */
	public void put(Record k) throws DictionaryException {
		Node current = root;
		Node add = new Node(k);
		boolean not_added = false;
		// If its an empty tree
		if (root == null) {
			root = new Node(k);
		} else {
			while (!not_added) {
				// If the desired key is already in this tree
				if (current.getElement().getKey().compareTo(k.getKey()) == 0) {
					System.out.println("The record of (" + k.getData() + "," + k.getKey().getType()
							+ ") is already in this tree!");
					throw new DictionaryException("OrderedDictionary");
				}
				// If the desired record is smaller than the current record
				if (k.getKey().compareTo(current.getElement().getKey()) < 0) {
					if (current.getLeft().getElement() == null) {
						current.setLeft(add);
						not_added = true;
					} else {
						current = current.getLeft();
					}
				}
				// If the desired record is larger than the current record
				else if (current.getRight().getElement() == null) {
					current.setRight(add);
					not_added = true;
				} else {
					current = current.getRight();
				}
			}
		}
	}

	@Override
	/**
	 * 
	 */
	public void remove(Pair k) throws DictionaryException {
		Node current = root;
		Node parent = root;
		boolean not_found = true;
		Record temp = get(k);
		// If the tree is empty
		if (root == null || temp == null) {
			System.out.println("There is no record of that in the ordered dictioary");
			throw new DictionaryException("OrderedDictionary");
		} else {
			if (k.compareTo(current.getElement().getKey()) < 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}

			while (current != null && not_found) {
				if (k.compareTo(current.getElement().getKey()) == 0) {
					not_found = false;
				}
			}
		}

	}

	@Override
	/**
	 * 
	 */
	public Record successor(Pair k) {
		if (root.getElement() == null) {
			return null;
		} else {
			Record result = get(k);
			Node current = getRecursive(k, root);

			return result;
		}

	}

	@Override
	/**
	 * 
	 */
	public Record predecessor(Pair k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * 
	 */
	public Record smallest() {
		if (root == null) {
			System.out.printf("Empty Tree!");
			return null;
		} else {
			if (root.getLeft().getElement() == null) {
				return root.getElement();
			} else {
				Node parent = root;
				Node current = root.getLeft();
				current = root.getLeft();
				while (!(current.getLeft().isLeaf())) {
					parent = current;
					current = current.getLeft();
				}
				return current.getElement();
			}
		}
	}

	@Override
	/**
	 * 
	 */
	public Record largest() {
		if (root == null) {
			System.out.printf("Empty Tree!");
			return null;
		} else {
			if (root.getRight() == null) {
				return root.getElement();
			} else {
				Node parent = root;
				Node current = root.getRight();
				current = root.getRight();
				while (current.getRight() != null) {
					parent = current;
					current = current.getLeft();
				}
				return current.getElement();
			}
		}
	}
	
	public static void main (String[] args) {
		OrderedDictionary test = new OrderedDictionary();
		Pair x = new Pair("a", "b");
	}
}
