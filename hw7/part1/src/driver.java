import java.util.Iterator;

public class driver {

	public static void main(String[] args) {
		NavigableAVL<Integer> avlNavigable = new NavigableAVL<Integer>();
		NavigableSkipList<Integer> skipListNavigable=new NavigableSkipList<>();
		System.out.println("--------------------------------Navigable AVL--------------------------------");
		System.out.println("-------------Adding elements to AVL Tree and Print--------------");
		
		avlNavigable.insert(8);
		avlNavigable.insert(3);
		avlNavigable.insert(10);
		avlNavigable.insert(1);
		avlNavigable.insert(6);
		avlNavigable.insert(14);
		avlNavigable.insert(4);
		avlNavigable.insert(7);
		avlNavigable.insert(13);
		avlNavigable.print();
		
		System.out.println("-------------Pre-order Traverse with Iterator-------------");
		
		Iterator<Integer> iter=avlNavigable.iterator();
		
		System.out.println(iter.next());
		System.out.println("Has Next: "+iter.hasNext());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println("Has Next: "+iter.hasNext());

		
		System.out.println("------------Test HeadSet for 7------------- ");
		for(Integer temp:avlNavigable.headSet(7))
			System.out.println(temp);
		
		System.out.println("------------Test TailSet for 7--------------");
		for(Integer temp:avlNavigable.tailSet(7))
			System.out.println(temp);
		
		
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------------------Navigable SkipList--------------------------------\n\n");
		System.out.println("-------------Adding elements to SkipList and Print--------------\n");
		skipListNavigable.insert(8);
		skipListNavigable.insert(3);
		skipListNavigable.insert(10);
		skipListNavigable.insert(1);
		skipListNavigable.insert(6);
		skipListNavigable.insert(14);
		skipListNavigable.insert(4);
		skipListNavigable.insert(7);
		skipListNavigable.insert(13);
		System.out.println(skipListNavigable.toString());
		
		
		System.out.println("\n\n-------------Removing 8 from SkipList and Print--------------\n");
		skipListNavigable.delete(8);
		System.out.println(skipListNavigable.toString());
		
		
		System.out.println("\n\n-------------Descending Iterator-------------");
		Iterator<Integer>iterSkipList=skipListNavigable.descendingIterator();
		System.out.println(iterSkipList.next());
		System.out.println(iterSkipList.next());
		System.out.println("Has Next: "+iterSkipList.hasNext());
		System.out.println(iterSkipList.next());
		System.out.println(iterSkipList.next());
		System.out.println(iterSkipList.next());
		System.out.println(iterSkipList.next());
		System.out.println(iterSkipList.next());
		System.out.println(iterSkipList.next());
		System.out.println("Has Next: "+iterSkipList.hasNext());
		
		
	}

}
