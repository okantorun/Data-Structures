
import java.util.Random;
public class driver {
	
	public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {          
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
	
	public static void search(int arr[],BSTHeapTree<Integer>tempTree) {
		int temp=arr[0];
		int count =0;
		int number =1;
		int nonExisting=0;
		System.out.println();
		for(int i=0;i<3000;i++) {
			
			if(arr[i]==temp) {
				count++;
			}
			if(arr[i+1] != temp) {
				System.out.println(number+") " + "Occurrence of "+ arr[i]  +" in Array :"+count+"--- Occurrence in HeapTree "+tempTree.find(arr[i]));
				number++;
				count=0;
				temp=arr[i+1];
			}
			if((arr[i+1] - arr[i] >1)  && nonExisting<10) {
				System.out.println(number+") " + "Occurrence of "+ (arr[i]+1)  +" in Array :"+0+"--- Occurrence in HeapTree "+tempTree.find(arr[i]+1));
				nonExisting++;
				number++;
			}
			if(number>100)
				break;				
		}
	}
	
	public static void findMode(int arr[],BSTHeapTree<Integer>tempTree) {
		int temp=arr[0];
		int mode=-1;
		int modeFrequency=0;
		int countFrequency=0;
		for(int i=0;i<3000;i++) {			
			if(arr[i]==temp) {
				countFrequency++;
			}
			if((i<2999) && (arr[i+1] !=temp)) {
				if(countFrequency>modeFrequency) {
					modeFrequency=countFrequency;
					mode=arr[i];
				}
				temp=arr[i+1];		
				countFrequency=0;
			}
			
		}
		System.out.println("\n Mode in Array is : "+mode+"--- Mode in HeapTree "+tempTree.find_mode());
	}
	
	
	public static void deleting(int arr[],BSTHeapTree<Integer>tempTree) throws Exception {
		int size=3000;
		int count =0;
		int temp;
		for(int i=0;i<100;i++) {
			System.out.println("\nBefore removing "+(arr[i]) +" Occurrence in HeapTree "+tempTree.find(arr[i]));
			tempTree.remove(arr[i]);
			temp=arr[i];
			for (int index = i + 1; index < size; index++) {
				arr[index-1] = arr[index];
			}
			size--;
			
			System.out.println(i+")"+"After removing "+(temp) +" Occurrence in HeapTree "+tempTree.find(temp));
			if((arr[i+1] - arr[i] >1) && count<10) {
				System.out.println("\nNon Existing: Before removing "+(arr[i]+1) +" Occurrence in HeapTree "+tempTree.find(arr[i]+1));
				tempTree.remove(arr[i]+1);
				System.out.println("After removing "+(arr[i]+1) +" Occurrence in HeapTree "+tempTree.find(arr[i]+1));
				count++;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		try {
			Random rand = new Random();
			BSTHeapTree<Integer>tempTree=new BSTHeapTree<>();
			int[] arr=new int[3000];
			for(int i=0;i < 3000; i++)
			{
				int temp=rand.nextInt(5000);
				arr[i]=temp;
				tempTree.add(temp);
			}										//Generate and print 3000 number
			bubbleSort(arr);
		
			for(int i=0;i < 3000; i++)
			{
				System.out.print(arr[i]+",");
			}
			
						
			search(arr, tempTree);		
			findMode(arr, tempTree);	
			deleting(arr, tempTree);
						
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
