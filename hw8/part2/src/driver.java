
public class driver {

	public static void main(String[] args) {
		ListGraph listGraph = new ListGraph(11,false);
		test test1=new test();
		
		test1.runTimeBFS(1000);
		test1.runTimeDFS(1000);
		System.out.println("\n");
		
		test1.runTimeBFS(2000);
		test1.runTimeDFS(2000);
		System.out.println("\n");
		
		test1.runTimeBFS(5000);
		test1.runTimeDFS(5000);
		System.out.println("\n");
		
		test1.runTimeBFS(10000);
		test1.runTimeDFS(10000);
		
	}

}
