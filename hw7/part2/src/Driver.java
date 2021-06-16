
public class Driver {

	public static void main(String[] args) {
		
		BST<Integer>myAVL=new BST<Integer>();
		TreeStatus<Integer>status=new TreeStatus<>();
		
		myAVL.add(15);
		myAVL.add(10);
		myAVL.add(20);
		myAVL.add(5);
		myAVL.add(30);
		
		System.out.println(myAVL.toString());
		status.checkTreeStatusAVL(myAVL);
		System.out.println("\n\n");
		myAVL.add(30);
		myAVL.add(40);
		System.out.println(myAVL.toString());
		status.checkTreeStatusAVL(myAVL);
				
		
	}

}
