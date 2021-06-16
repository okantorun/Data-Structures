public class TwoThreeTree<E extends Comparable<E>> {

	private Node root;              // The root of the tree
	
	private int size;              // Number of elements inside of the tree
	
	private static final int    ROOT_IS_BIGGER = 1;
	private static final int    ROOT_IS_SMALLER = -1;

	private boolean addition;       // A flag to know if the last element has been added correctly or not

	public TwoThreeTree() {
		
		this.root = new Node();

		size = 0;
	}

	/**
	 * Adds a new element to the tree keeping it balanced.
	 *
	 * @param element The element to add
	 *
	 * @return If the element has been added (true) or not because it already exists (false)
	 */
	public boolean add(E element) {

		size++;

		addition = false;

		if(root == null || root.leftElement == null) { // first case

			if(root == null) root = new Node();

			root.leftElement = element;

			addition = true;
		}
		else {

			Node newRoot = addElementI(root, element); // Immersion

			if(newRoot != null) root = newRoot;
		}

		if(!addition) size--;

		return addition;
	}

	/**
	 * The algorithm stores the new element ordered as the 'compareTo' method of the Object is done. So the tree can store
	 * the data in Ascending or Descending mode.
	 *
	 * During the top down of the recursive, the algorithm tries to find the deepest level of the tree, where the new element will be saved.
	 *
	 * On the bottom up, if the new element has to be added inside a node with two existing elements (3-node), then we have to
	 * create a new tree level elevating a new node with the element which should be in the middle of the three.
	 *
	 * In the code, this situation happens when the Node returned by the method is not null. If it is null, the node where
	 * the new element has been inserted was a 2-node (there was an element position still empty).
	 *
	 * Also, during the bottom up, the algorithm checks if the tree is well-balanced correcting the structure if it isn't.
	 *
	 * @param current The child where we are
	 * @param element The element to insert
	 *
	 * @return If there is a new level to add (we have tried to add a new element to a 3-node) or we don't have to do nothing (node is null)
	 */
	private Node addElementI(Node current, E element) {

		Node newParent = null;

		// We aren't in the deepest level yet
		if(!current.isLeaf()) {

		    Node sonAscended = null;

			if (current.leftElement.compareTo(element) == 0 || (current.is3Node() && current.rightElement.compareTo(element) == 0)) {

				// Already exists. This condition can be modified for the particular needs of any programmer
			}
			// The new element is smaller than the left element
			else if (current.leftElement.compareTo(element) == ROOT_IS_BIGGER) {

				sonAscended = addElementI(current.left, element);

				// Case sonAscended != null --> the element has been added on a 3-node (there were 2 elements)
				if (sonAscended != null) { // A new node comes from the left branch

					// The new element, in this case, is always less than the current.left
					if (current.is2Node()) {

						current.rightElement    = current.leftElement;  // shift the current left element to the right
						current.leftElement     = sonAscended.leftElement;
						current.right           = current.mid;
						current.mid             = sonAscended.mid;
						current.left            = sonAscended.left;
					}
					else { // In this case we have a new split, so the current element in the left will go up

						// We copy the right part of the subtree
						Node rightCopy = new Node(current.rightElement, null, current.mid, current.right);

						// Now we create the new "structure", pasting the right part
						newParent = new Node(current.leftElement, null, sonAscended, rightCopy);
					}
				}

				// Case: the ascended element is bigger than the left element and less than the right element
			} else if (current.is2Node() || (current.is3Node() && current.rightElement.compareTo(element) == ROOT_IS_BIGGER)) {

				sonAscended = addElementI(current.mid, element);

				if (sonAscended != null) { // A new split

					// The right element is empty, so we can set the ascended element in the left and the existing left element into the right
					if (current.is2Node()) {

						current.rightElement    = sonAscended.leftElement;
						current.right           = sonAscended.mid;
						current.mid             = sonAscended.left;
					}
					else { // Another case we have to split again

						Node left 	= new Node(current.leftElement, null, current.left, sonAscended.left);
						Node mid 	= new Node(current.rightElement, null, sonAscended.mid, current.right);
						newParent 	= new Node(sonAscended.leftElement, null, left, mid);
					}
				}
				// The new element is bigger than the right element
			} else if (current.is3Node() && current.rightElement.compareTo(element) == ROOT_IS_SMALLER) {

				sonAscended = addElementI(current.right, element);

				if (sonAscended != null) { // Split, the right element goes up

					Node leftCopy   = new Node(current.leftElement, null, current.left, current.mid);
					newParent       = new Node(current.rightElement, null, leftCopy, sonAscended);
				}
			}
		}
		else { // We are in the deepest level

			addition = true;

			// The element already exists
			if (current.leftElement.compareTo(element) == 0 || (current.is3Node() && current.rightElement.compareTo(element) == 0)) {

				addition = false;
			}
			else if (current.is2Node()) { // an easy case, there is not a right element

				// if the current left element is bigger than the new one --> we shift the left element to the right
				if (current.leftElement.compareTo(element) == ROOT_IS_BIGGER) {

					current.rightElement    = current.leftElement;
					current.leftElement     = element;
				}
				// if the new element is bigger, we add it in the right directly
				else if (current.leftElement.compareTo(element) == ROOT_IS_SMALLER) current.rightElement = element;
			}
			// Case 3-node: there are 2 elements in the node and we want to add another one. We have to split the node
			else newParent = split(current, element);
		}

		return newParent;
	}

    /**
     * Creates the new node structure that will be attached during the bottom up of the addElementI method.
     *
     * @param current   The node where the split takes place
     * @param element   The element we are trying to add.
     * @return          A 2-node structure with a non null left and mid node.
     */
	private Node split(Node current, E element) {
        Node newParent = null;

        // The left element is bigger, so it will go up letting the new element on the left
        if (current.leftElement.compareTo(element) == ROOT_IS_BIGGER) {

            Node left   = new Node(element, null);
            Node right  = new Node(current.rightElement, null);
            newParent   = new Node(current.leftElement, null, left, right);

        } else if (current.leftElement.compareTo(element) == ROOT_IS_SMALLER) {

            // The new element is bigger than the current on the right and less than the right element
            // The new element goes up
            if (current.rightElement.compareTo(element) == ROOT_IS_BIGGER) {

                Node left   = new Node(current.leftElement, null);
                Node right  = new Node(current.rightElement, null);
                newParent   = new Node(element, null, left, right);

            } else { // The new element is the biggest one, so the current right element goes up

                Node left   = new Node(current.leftElement, null);
                Node right  = new Node(element, null);
                newParent   = new Node(current.rightElement, null, left, right);
            }
        }

        return newParent;
    }
	

	/**
	 * @param element The element to find
	 *
	 * @return true if this tree contains the specified element, false if not
	 */
	public boolean contains(E element) {

		return find(element) != null;
	}


	/**
	 * Searches an element inside of the tree.
	 *
	 * @param element The element to find
	 *
	 * @return the element found or null if it doesn't exist
	 */
	public E find(E element) {

		return findI(root, element);
	}

	private E findI(Node current, E element) {

		E found = null;

		if(current != null) {

			// Trivial case, we have found the element
			if(current.leftElement != null && current.leftElement.equals(element)) found = current.leftElement;
			else {

				// Second trivial case, the element to find equals the right element
				if(current.rightElement != null && current.rightElement.equals(element)) found = current.rightElement;
				else {
					// Recursive cases
					if(current.leftElement.compareTo(element) == ROOT_IS_BIGGER) {

						found = findI(current.left, element);
					}
					else if(current.right == null || current.rightElement.compareTo(element) == ROOT_IS_BIGGER) {

						found = findI(current.mid, element);
					}
					else if (current.rightElement.compareTo(element) == ROOT_IS_SMALLER) {
						found = findI(current.right, element);
					}
					else return null;
				}
			}
		}

		return found;
	}

	
	private class Node {
		
		private Node left;
		private Node mid;
		private Node right;
		private E leftElement;
		private E rightElement;

        
        /**
         * Creates an empty node/child
         */
        private Node() {
			
			left = null;
			mid = null;
			right = null;
			leftElement = null;
			rightElement = null;
		}

        /**
         * Constructor of a 3 Node without the childs defined yet (null references).
         *
         * @param leftElement   the element in the left
         * @param rightElement  the element in the right
         *
         */
        // Precondition: The left element must be less than the right element
        //               This is a private class but if you want to make it externally accessible
        //               I recommend to use the IllegalArgumentException
		private Node(E leftElement, E rightElement) {
			
			this.leftElement = leftElement;
			this.rightElement = rightElement;
			left = null;
			mid = null;
			right = null;
		}

        /**
         * Constructor of a 3 Node with the left and mid nodes/childs defined.
         *
         * @param leftElement   the element in the left
         * @param rightElement  the element in the right
         * @param left          the left child
         * @param mid           the mid child
         */
        // Precondition: The left element must be less than the right element
        //               This is a private class but if you want to make it externally accessible
        //               I recommend to use the IllegalArgumentException
		private Node(E leftElement, E rightElement, Node left, Node mid) {
			
			this.leftElement = leftElement;
			this.rightElement = rightElement;			
			this.left = left;
			this.mid = mid;
		}
		
		/**
		 * @return true if we are on the deepest level of the tree (a leaf) or false if not
		 */
		private boolean isLeaf() {

			return left == null && mid == null && right == null;
		}

		private boolean is2Node() {

		    return rightElement == null; // also, right node is null but this will be always true if rightElement == null
        }

        private boolean is3Node() {

		    return rightElement != null; // also, right node is not null but this will be always true if rightElement <> null
        }
			
	}
}