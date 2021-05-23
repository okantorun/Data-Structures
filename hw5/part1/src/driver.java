import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class driver {
	
	public static void main(String[] args) throws Exception {
		try {
			
			//ADDÝNG ELEMENT
			HashMapIter<Integer, String> obj=new HashMapIter<>();					
			obj.put(1, "Ocak");
			obj.put(2, "Subat");
			obj.put(3, "Mart");
			obj.put(4, "Nisan");
			obj.put(5, "Mayis");
			obj.put(6, "Haziran");
			obj.put(7, "Temmuz");
			obj.put(8, "Agustos");
			
			
			//START FROM GIVEN KEY
			MapIterator<Integer, String> iter=obj.iterator(3);			
			
			System.out.println("------------TEST FOR NEXT METHOD--------------");
			while(iter.hasNext())
				System.out.println("Next-->"+iter.next());
			
			System.out.println("Next-->"+iter.next());//Exception
			
			System.out.println("\n------------TEST FOR hasNext METHOD--------------");
			System.out.println("hasNext-->"+iter.hasNext());
				
			System.out.println("\n------------TEST FOR PREV METHOD--------------");	
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			System.out.println("Prev-->"+iter.prev());
			
			System.out.println("\n------------TEST FOR hasNext METHOD--------------");
			System.out.println("hasNext-->"+iter.hasNext());
		
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
