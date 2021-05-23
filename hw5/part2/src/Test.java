

public class Test {
	
	public void Small() {
		HashTableChainBook<Integer, Integer> tableBook = new HashTableChainBook<>();
		HashTableChainTreeSet<Integer, Integer> tableTreeSet = new HashTableChainTreeSet<>();
		HashTableCoalesced<Integer, Integer> tableCoalesced=new HashTableCoalesced<>();
		
		 long startTime = 0;
	     long endTime = 0;
	     long time = 0;

	     
	     for(int i=0;i<10;i++) {
	    	 tableBook.put(i, i);
	    	 tableCoalesced.put(i, i);
	    	 tableTreeSet.put(i, i);
	     }
	     System.out.println("------------------------SMALL TABLE----------------------------");
	     System.out.println("ADD----------------------------");
		for(int i=0;i<5;i++) {
			startTime = System.nanoTime();
			tableTreeSet.put(11+i, i);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the TreeSet when adding one element->>"+time);
			startTime = System.nanoTime();
			tableBook.put(11+i, i);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the LinkedList when adding one element->>"+time);
	        startTime = System.nanoTime();
			tableCoalesced.put(11+i, i);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the Coalesced when adding one element->>"+time);
	        System.out.println("----");
			
		}
		System.out.println("GET exist----------------------------");		
		for(int i=0;i<5;i++) {
			startTime = System.nanoTime();
			tableTreeSet.get(i+1);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the TreeSet when accessing element->>"+time);
			startTime = System.nanoTime();
			tableBook.get(i+1);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the LinkedList when accessing element->>"+time);
	        startTime = System.nanoTime();
			tableCoalesced.get(i+1);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the Coalesced when accessing element->>"+time);
	        System.out.println("----");
			
		}
		System.out.println("GET non-exist----------------------------");		
		for(int i=0;i<5;i++) {
			startTime = System.nanoTime();
			tableTreeSet.get(100+i);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the TreeSet when accessing non-exist element->>"+time);
			startTime = System.nanoTime();
			tableBook.get(100+i);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the LinkedList when accessing non-exist element->>"+time);
	        startTime = System.nanoTime();
			tableCoalesced.get(100+i);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the Coaledced when accessing non-exist element->>"+time);
	        System.out.println("----");
			
		}
		System.out.println("REMOVE----------------------------");
		for(int i=0;i<5;i++) {
			startTime = System.nanoTime();
			tableTreeSet.remove(i+5);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the TreeSet when removing one element->>"+time);
			startTime = System.nanoTime();
			tableBook.remove(i+5);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the LinkedList when removing one element->>"+time);
	        startTime = System.nanoTime();
			tableCoalesced.remove(i+5);
			endTime = System.nanoTime();
	        time = endTime - startTime;
	        System.out.println("Time Spent For the Coalesced when removing one element->>"+time);
	        System.out.println("----");
		}
		
	}
	public void Medium() {
		HashTableChainBook<Integer, Integer> tableBook = new HashTableChainBook<>();
		HashTableChainTreeSet<Integer, Integer> tableTreeSet = new HashTableChainTreeSet<>();
		HashTableCoalesced<Integer, Integer> tableCoalesced=new HashTableCoalesced<>();
		
		 long startTime = 0;
	     long endTime = 0;
	     long time = 0;
	     
	     for(int i=0;i<1000;i++) {
	    	 tableBook.put(i, i);
	    	 tableCoalesced.put(i, i);
	    	 tableTreeSet.put(i, i);
	     }
	     System.out.println("------------------------MEDIUM TABLE----------------------------");
	     System.out.println("ADD----------------------------");
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.put(1000+i, i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when adding one element->>"+time);
				startTime = System.nanoTime();
				tableBook.put(1000+i, i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when adding one element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.put(1000+i, i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coalesced when adding one element->>"+time);
		        System.out.println("----");
				
			}
			System.out.println("GET exist----------------------------");		
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.get(i+250);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when accessing element->>"+time);
				startTime = System.nanoTime();
				tableBook.get(i+250);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when accessing element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.get(i+250);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coalesced when accessing element->>"+time);
		        System.out.println("----");
				
			}
			System.out.println("GET non-exist----------------------------");		
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.get(2000+i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when removing one element->>"+time);
				startTime = System.nanoTime();
				tableBook.get(2000+i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when accessing non-exist element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.get(2000+i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coaledced when accessing non-exist element->>"+time);
		        System.out.println("----");
				
			}
			System.out.println("REMOVE----------------------------");
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.remove(i+200);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when removing one element->>"+time);
				startTime = System.nanoTime();
				tableBook.remove(i+200);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when removing one element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.remove(i+200);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coalesced when removing one element->>"+time);
		        System.out.println("----");
			}
			
		
	}
	public void Large() {
		HashTableChainBook<Integer, Integer> tableBook = new HashTableChainBook<>();
		HashTableChainTreeSet<Integer, Integer> tableTreeSet = new HashTableChainTreeSet<>();
		HashTableCoalesced<Integer, Integer> tableCoalesced=new HashTableCoalesced<>();
		
		 long startTime = 0;
	     long endTime = 0;
	     long time = 0;
	     
	     for(int i=0;i<10000;i++) {
	    	 tableBook.put(i, i);
	    	 tableCoalesced.put(i, i);
	    	 tableTreeSet.put(i, i);
	     }
	     System.out.println("------------------------LARGE TABLE----------------------------");
	     System.out.println("ADD----------------------------");
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.put(10000+i, i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when adding one element->>"+time);
				startTime = System.nanoTime();
				tableBook.put(10000+i, i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when adding one element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.put(10000+i, i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coalesced when adding one element->>"+time);
		        System.out.println("----");
				
			}
			System.out.println("GET exist----------------------------");		
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.get(i+5000);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when accessing element->>"+time);
				startTime = System.nanoTime();
				tableBook.get(i+5000);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when accessing element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.get(i+5000);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coalesced when accessing element->>"+time);
		        System.out.println("----");
				
			}
			System.out.println("GET non-exist----------------------------");		
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.get(15000+i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when removing one element->>"+time);
				startTime = System.nanoTime();
				tableBook.get(15000+i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when accessing non-exist element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.get(15000+i);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coaledced when accessing non-exist element->>"+time);
		        System.out.println("----");
				
			}
			System.out.println("REMOVE----------------------------");
			for(int i=0;i<5;i++) {
				startTime = System.nanoTime();
				tableTreeSet.remove(i+7000);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the TreeSet when removing one element->>"+time);
				startTime = System.nanoTime();
				tableBook.remove(i+7000);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the LinkedList when removing one element->>"+time);
		        startTime = System.nanoTime();
				tableCoalesced.remove(i+7000);
				endTime = System.nanoTime();
		        time = endTime - startTime;
		        System.out.println("Time Spent For the Coalesced when removing one element->>"+time);
		        System.out.println("----");
			}
			
		
	}
}
