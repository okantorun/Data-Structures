

public class BSTHeapTree<E extends Comparable<E>>  implements SearchTree<E>{
		protected final int maxHeapSize=7;
		protected boolean checkTraversal;
		protected boolean addReturn;
		protected int addReturnFrequency;
		protected int removeReturnFrequency;
		protected E removeReturn;
		protected E mode;
		protected int modeFrequency;
		
		protected Node<E> root;
		
		protected static class Node<E> {			
			protected MaxHeap<E>dataHeap =  new MaxHeap<>();
			protected Node<E> left;
			protected Node<E> right;

			public Node(E data) {
				this.dataHeap.add(data); 
				left = null;
				right = null;
			}

			public String toString() {
				return dataHeap.toString();
			}

		}
		public BSTHeapTree() {
			addReturnFrequency=0;
			removeReturnFrequency=0;
			checkTraversal=false;
			mode=null;
			modeFrequency=0;
			root = null;
		}
		/**
		 * @param target The object being sought
		 * @return The object, if found modeFrequency , otherwise -1
		 */
		public int find(E target){
			return find(root,target);
		}
		
		/**
		 * Recursive find method
		 * @param localRoot The local subtree's root
		 * @param target  target The object being sought
		 * @return The object, if found modeFrequency , otherwise -1
		 */
		private int find(Node<E> localRoot, E target){
			if(localRoot == null)
				return -1;
			
			int compResult = target.compareTo(localRoot.dataHeap.getFirst());
			if(localRoot.dataHeap.search(target) != null)
				return localRoot.dataHeap.search(target).getdataFrequency();
			
			else if(compResult < 0) return find(localRoot.left, target);
			else return find(localRoot.right, target);
		}
		
		public int add(E item){
			root = add(root, item);
			return addReturnFrequency;
		}
		
		/**
		 * Recursive add method
		 * @param localRoot The local root of the subtree
		 * @param item  The object to be inserted
		 * @return The new local root that now contains the inserted item
		 */
		@SuppressWarnings("unused")
		private Node<E> add(Node<E> localRoot, E item){
			
			 if(localRoot == null)
			{
				addReturn = true;
				checkTraversal=false;
				addReturnFrequency =1;
				return new Node<>(item);
			}
			else if(find(item) != -1) {
				 preOrderTraverseAdd(localRoot, item);
				 return localRoot;
			}
			if(localRoot.dataHeap.getSize() < maxHeapSize){
				addReturn = true;
				localRoot.dataHeap.add(item);
				addReturnFrequency=localRoot.dataHeap.search(item).getdataFrequency();
				return localRoot;
			}
			
			int compResult = item.compareTo(localRoot.dataHeap.getFirst());
			
			if(compResult < 0){
				localRoot.left = add(localRoot.left, item);
				return localRoot;
			} else{
				localRoot.right = add(localRoot.right,item);
				return localRoot;
			}

		}
		/**
		 * Finds the same element added 
		 * before with recursive and adds over 
		 * @param node localRoot The local root of the subtree
		 * @param item item  The object to be inserted
		 */
		@SuppressWarnings("unused")
		private void preOrderTraverseAdd(Node<E> node,E item) {
			
			if (node == null) {
				return;
			} else {
				if(node.dataHeap.search(item) != null) {
					node.dataHeap.add(item);				

			}
				preOrderTraverseAdd(node.left,item);
				preOrderTraverseAdd(node.right,item);
				
			}
		}
		
		/**
		 * @param target The object to be deleted
		 * @return If the element to be deleted is not found, 
		 * it returns the frequency if -1 is found.
		 */
		public int remove(E target) throws Exception{
			root = remove(root,target);
			if(removeReturn == null) return -1;
			else return removeReturnFrequency;
		
		}
		/**
		 * With recursive, if the node is empty after the target element is deleted,
		 *  it will be filled.
		 * @param localRoot The root of the current subtree
		 * @param item  The item to be deleted
		 * @return  The modified local root that does not contain the item
		 * @throws Exception If the element to be deleted is not found in the heap
		 */
		@SuppressWarnings("unchecked")
		private Node<E> remove(Node<E> localRoot, E item) throws Exception{
			if(localRoot == null){								
				removeReturn = null;			//item is not in the tree.
				return localRoot;
			}
			
			if(localRoot.dataHeap.search(item) != null)
			{
				removeReturn =  (E) localRoot.dataHeap.search(item).getData();		
				removeReturnFrequency =localRoot.dataHeap.search(item).getdataFrequency()-1;
				localRoot.dataHeap.remove(item);				
				/*while((localRoot.left != null || localRoot.right != null) && 
									localRoot.dataHeap.getSize()<maxHeapSize ) {
					
					if(localRoot.left != null) {
						
						E lastElement = localRoot.left.dataHeap.getLast();
						localRoot.dataHeap.add(lastElement);
						localRoot.left.dataHeap.remove(lastElement);
						localRoot.left=remove(localRoot.left, item);
						//localRoot =localRoot.left;
					}
					else if(localRoot.right != null) {
						E lastElement = localRoot.right.dataHeap.getLast();
						localRoot.dataHeap.add(lastElement);
						localRoot.right.dataHeap.remove(lastElement);
						localRoot.right=remove(localRoot.right, item);
						//localRoot =localRoot.right;
					}
				}*/
						
				
				if(localRoot.dataHeap.getSize() == 0) {
					if(localRoot.left == null){
						return localRoot.right;
					}else if(localRoot.right == null){
						return localRoot.left;
					}else{
						if(localRoot.left.right == null){
							localRoot.dataHeap = localRoot.left.dataHeap;
							localRoot.left = localRoot.left.left;
							return localRoot;
						} else{
							localRoot.dataHeap = findLargestChild(localRoot.left);
							return localRoot;
						}
					}
				}
				else {
					return localRoot;
				}
			}
			else {
				int compResult = item.compareTo(localRoot.dataHeap.getFirst());
	
				if(compResult < 0){
					localRoot.left = remove(localRoot.left, item);
					return localRoot;
				}else{
					localRoot.right = remove(localRoot.right, item);
					return localRoot;
				} 
			}
			
		}
		/**
		 * 
		 * @param parent find the largest heap of parent
		 * @return data stored in largest heap.
		 */
		@SuppressWarnings("unchecked")
		private MaxHeap<E> findLargestChild(Node<E> parent){
			if(parent.right.right == null){
				MaxHeap<E> returnValue = parent.right.dataHeap;
				 parent.right = parent.right.left;
				 return  returnValue;
			} else{
				 return findLargestChild(parent.right);
			}
		}
		/**
		 * 
		 * @return heap elements
		 */
		public String toString() {
			
			return root.right.toString();
		}
		/**
		 * 
		 * @return the mode value found and saved with recursive
		 */
		public E find_mode()
		{			
			preOrderTraverseMode(root);
			return mode;
			
		}
		/**
		 * traverses the whole tree and saves the found mode value
		 * @param node node The local root of the subtree
		 */
		@SuppressWarnings("unused")
		private void preOrderTraverseMode(Node<E> node) {
			
			if (node == null) {
				return;
			} else {
				if(node.dataHeap.findMode()>addReturnFrequency) {
					mode=node.dataHeap.getMode();
					addReturnFrequency=node.dataHeap.getModeFrequency();
				}
				preOrderTraverseMode(node.left);
				preOrderTraverseMode(node.right);
			}
		}
		/**
		 *@param target searching target
		 * @return -1 if target exists in the tree; false otherwise.
		 */
		public boolean contains(E target) {
			if(find(target) == -1) return false;
			return true;
		}

		/**
		 * @param deleting target
		 * @return  true if the item was successfully removed; false otherwise.
		 */
		public boolean delete(E target) throws Exception {
			if(remove(target) == -1) return false;
			return true;
		}

}
