import java.util.Random;

public class test {
	public void runTimeBFS(int size) {
		int avgTime=0;
		Random rand = new Random();
        long startTime = 0, endTime = 0, time = 0;
        int source=0,dest=0;
        for(int j=0;j<10;j++) {
	        ListGraph listGraph = new ListGraph(size,false);
	        for(int i=0;i<size;i++) {
	        	source =rand.nextInt(1000);
	        	dest =rand.nextInt(1000);
	        	listGraph.insert(new Edge(source,dest,5));
	        }
	        startTime = System.nanoTime();
	        listGraph.breadthFirstSearch(source);
	        endTime = System.nanoTime();
	        time = endTime - startTime;
	        avgTime+=time;
        }
        System.out.println("For "+size+" Element Run Time BFS: "+avgTime/10);
	}
	public void runTimeDFS(int size) {
		int avgTime=0;
		Random rand = new Random();
        long startTime = 0, endTime = 0, time = 0;
        int source=0,dest=0;
        for(int j=0;j<10;j++) {
        	 ListGraph listGraph = new ListGraph(size,false);
	        for(int i=0;i<size;i++) {
	        	source =rand.nextInt(1000);
	        	dest =rand.nextInt(1000);
	        	listGraph.insert(new Edge(source,dest,5));
	        }
	        startTime = System.nanoTime();
	        listGraph.depthFirstSearch(source);
	        endTime = System.nanoTime();
	        time = endTime - startTime;
	        avgTime+=time;
        }
        System.out.println("For "+size+" Element Run Time DFS: "+avgTime/10);
	}
}
