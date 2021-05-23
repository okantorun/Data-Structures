
public class driver {

	public static void main(String[] args) throws Exception {
		{
			try {
				
				MinHeap<Integer>tempHeap=new MinHeap<>();
				MinHeap<Integer>tempHeap2=new MinHeap<>();
				System.out.print("*******Adding Heap1*******\n");
				tempHeap.add(8);
				tempHeap.add(3);
				tempHeap.add(5);
				tempHeap.add(10);
				tempHeap.add(15);
				tempHeap.add(9);				
				System.out.println(tempHeap.toString());
				
				System.out.println("******REMOVING******\n");
				tempHeap.remove(3);
				System.out.print("\n\nHeap1 Again\n"+tempHeap.toString());
				
				tempHeap2.add(2);
				tempHeap2.add(4);
				tempHeap2.add(6);
				tempHeap.add(35);
				tempHeap.add(40);
				tempHeap.add(1);	
				System.out.print("\n\nAdding Heap2\n"+tempHeap.toString());
				
				
				
				tempHeap.remove(6);
				System.out.print("\n\nHeap2 Again\n"+tempHeap.toString());
				
				
				
				System.out.println("\nSearched Element 10 : "+tempHeap.search(10)+" found");
				System.out.println("\nSearched Element 4 : "+tempHeap.search(4));
				
				
				
				tempHeap.merge(tempHeap2);
				System.out.println("\n**********MERGING****************");
				System.out.println("\nMerged Completed");
				System.out.print("Merge Heap\n"+tempHeap.toString());
				
				tempHeap.remove(6);
				System.out.print("\n\nMerged Heap print again \n"+tempHeap.toString());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		}
	}

}
