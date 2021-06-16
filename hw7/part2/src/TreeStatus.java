

@SuppressWarnings("serial")
public class TreeStatus<E extends Comparable<E>> extends BST<E> {
	
	
	public void checkTreeStatusAVL(BST<E> bst ) {
		
		if(!isAvl((BinaryTree<E>)bst))
			System.out.println("Tree is not AVL");
		else
			System.out.println("Tree is AVL");
	}
	
	/*---------------------------------------------------------FOR AVL---------------------------------------------------------------*/
	/**
	 * 
	 * @param binaryTree tree to be checked
	 * @return branch at maximum depth
	 */
	private int heightAVL(BinaryTree<E> binaryTree) {
        if (binaryTree == null)
            return 0;

        return 1 + Math.max(heightAVL(binaryTree.getLeftSubtree()),
        										heightAVL(binaryTree.getRightSubtree()));
    }
	/**
	 * 
	 * @param binaryTree tree to be checked
	 * @return AVL or not AVL
	 */
    @SuppressWarnings("unused")
	private boolean isAvl(BinaryTree<E>binaryTree) {
        Integer left = 0;
        Integer right = 0;

        if (binaryTree == null)
            return true;

        left = heightAVL(binaryTree.getLeftSubtree());
        right = heightAVL(binaryTree.getRightSubtree());

        if (Math.abs(left - right) <= 1 && isAvl( binaryTree.getLeftSubtree())
                									&& isAvl(binaryTree.getRightSubtree()))
            return true;

        return false;

    }

}
