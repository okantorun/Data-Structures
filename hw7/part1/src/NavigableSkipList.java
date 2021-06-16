import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.SortedSet;
import java.util.Stack;

/**
 * Implementation of a Skip-List data structure
 * @author Jacob / Koffman Wolfgang
 *
 *@param <E> The type of data stored. Must be a Comparable
 */
public class NavigableSkipList<E extends Comparable<E>> implements NavigableSet<E> {
    /**
     * Head of the skip-list
     */
    public SLNode<E> head;
    /**
     * Size of the skip list
     */
    private int size;
    /**
     * The maximum level of the skip-list
     */
    private int maxLevel;
    /**
     * Smallest power of 2 that is greater than the current skip-list size
     */
    private int maxCap;
    /**
     * Natural log of 2
     */
    static final double LOG2 = Math.log(2.0);
    /**
     * Minimum possible integer value for the head
     */
    static final int MIN = Integer.MIN_VALUE;
    /**
     * Random number generator
     */
    private Random rand = new Random();
    
    /**
     * I put the elements in the stack for traverse flexibility before navigating with iteratore
     * and because i have to go around in descending order
     */
    private Stack<E> storeForIter = new Stack<>();

    //Constructor

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public NavigableSkipList(){
        size = 0;
        maxLevel = 0;
        maxCap = computeMaxCap(maxLevel);
        head = new SLNode(maxLevel, MIN);
    }

    /**
     * Search for an item in the list
     * @param target The item being sought
     * @return An SLNode array which references the predecessors of the target at each level.
     */
    @SuppressWarnings("unchecked")
    private SLNode<E>[] search(E target){
        SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for(int i = current.links.length - 1; i >= 0; i--){
            while(current.links[i] != null
                    && current.links[i].data.compareTo(target) < 0){
                current = current.links[i];
            }
            pred[i] = current;
        }
        return pred;
    }

    /**
     * Find an object in the skip-list
     * @param target The item being sought
     * @return A reference to the object in the skip-list that matches
     *         the target. If not found, null is returned 
     */
    private E find(E target){
        SLNode<E>[] pred = search(target);
        if(pred[0].links != null &&
                pred[0].links[0].data.compareTo(target) == 0){
            return pred[0].links[0].data;
        } else {
            return null;
        }
    }

    /**
     * Inserts the given item
     * @param item The item to add
     * @return true as the item is added
     */
    public boolean add(E item){
        size++;
        SLNode<E>[] pred = search(item);
        if(size > maxCap){
            maxLevel++;
            maxCap = computeMaxCap(maxLevel);
            head.links = Arrays.copyOf(head.links, maxLevel);
            pred = Arrays.copyOf(pred, maxLevel);
            pred[maxLevel - 1] = head;
        }
        SLNode<E> newNode = new SLNode<E>(logRandom(), item);
        for(int i = 0; i < newNode.links.length; i++){
            newNode.links[i] = pred[i].links[i];
            pred[i].links[i] = newNode;
        }
        return true;
    }

    /**
     * Removes an instance of the given item
     * @param item The item to remove
     * @return true if the item is removed, false if the item is not in the list
     */
    private boolean remove(E item){
        SLNode<E>[] pred = search(item);
        if(pred[0].links != null &&
                pred[0].links[0].data.compareTo(item) != 0){
            return false; //item is not in the list
        } else {
            size--; //don't re-adjust maxCap and level, as we may have nodes at these levels
            SLNode<E> deleteNode = pred[0];
            for(int i = 0; i < deleteNode.links.length; i++){
                if(pred[i].links[i] != null)
                    pred[i].links[i] = pred[i].links[i].links[i];
            }
            return true;
        }
    }

    /**
     * Method to generate a logarithmic distributed integer between 1 and maxLevel.
     *  I.E. 1/2 of the values are 1, 1/4 are 2, etc.
     * @return a random logarithmic distributed int between 1 and maxLevel
     */
    private int logRandom(){
        int r = rand.nextInt(maxCap);
        int k = (int) (Math.log(r + 1) / LOG2);
        if(k > maxLevel - 1)
            k = maxLevel - 1;
        return maxLevel - k;
    }

    /**
     * Recompute the max cap
     * @param level
     * @return
     */
    private int computeMaxCap(int level){
        return (int) Math.pow(2, level) - 1;
    }

    @SuppressWarnings("rawtypes")
    public String toString(){
        if(size == 0)
            return "Empty";
        StringBuilder sc = new StringBuilder();
        SLNode itr = head;
        sc.append("Head: " + maxLevel);
        int lineMaker = 0;
        while(itr.links[0] != null){
            itr = itr.links[0];
            sc.append(" --> " + itr.toString());
            lineMaker++;
            if(lineMaker == 10){
                sc.append("\n");
                lineMaker = 0;
            }
        }
        return sc.toString();
    }

    /**
     * Static class to contain data and links
     * @author Jacob / Koffman & Wolfgang
     *
     * @param <E> The type of data stored. Must be a Comparable
     */
    private static class SLNode<E>{
        private SLNode<E>[] links;
        private E data;

        /**
         * Create a node of level m
         * @param m The level of the node
         * @param data The data to be stored
         */
        @SuppressWarnings("unchecked")
        public SLNode(int m, E data){
            links = (SLNode<E>[]) new SLNode[m];
            this.data = data;
        }

        public String toString(){
            return (data.toString() + " |" + links.length + "|");
        }
        @SuppressWarnings("unused")
		public E getData() {
        	return data;
        }
    }
    
    
    public boolean insert(E e) {
    	return (this.add(e));
    }
    public boolean delete(E e) {
    	return (this.remove(e));
    }
    @Override
	public Iterator<E> descendingIterator() {
    	storeDataForIter();
		return new SkipListIterator<>();
	}
    @SuppressWarnings({ "hiding", "unused" })
	private class SkipListIterator<E> implements Iterator<E> {
		  
        /**
         * @return has valid next element
         */
        @Override
        public boolean hasNext() {
        	return storeForIter.size()>0;
        }

        /**
         * @return  current element
         */
        @SuppressWarnings("unchecked")
		@Override
        public E next() {
        	if(!hasNext()) return null;
			else  
				return (E) storeForIter.pop();		
        }
	}
    @SuppressWarnings("unchecked")
	public void storeDataForIter() {
    	storeForIter = new Stack<>();
    	
    	SLNode itr = head;
    	
        while(itr.links[0] != null){
            itr = itr.links[0];
            storeForIter.push((E) itr.getData());

           
        }
    }
    
	@Override
	public Comparator<? super E> comparator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public E first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E lower(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E floor(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E ceiling(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E higher(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> descendingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		// TODO Auto-generated method stub
		return null;
	}
}