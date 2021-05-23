import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;



public class driver {

	public static void main(String[] args) {

		HashTableCoalesced<Integer, String>temp2=new HashTableCoalesced<>();
		HashTableChainTreeSet<Integer, Integer> treeSet=new HashTableChainTreeSet<>();
		HashTableChainBook<Integer, Integer> temp3=new HashTableChainBook<>();
		
		Test test=new Test();
		test.Small();
		test.Medium();
		test.Large();
		
		
		
	}

}
