import java.util.*;

/**
 * An implementation of a graph that uses an array of lists to represent the edges
 * @author Koffman & Wolfgang
 *
 */
public class ListGraph extends AbstractGraph {
	//Data Fields
	/**
	 * An array of Lists to contain the edges that originate with each vertex
	 */
	private List<Edge>[] edges;
	
	private boolean [] visited;
	private int[] discoveryOrder;
	private int discoveryIndex=0;

	/**
	 * Construct a graph with the specified number of vertices and directionality
	 * @param numV The number of vertices
	 * @param directed The directionality flag
	 */
	@SuppressWarnings("unchecked")
	public ListGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new List[numV];
		for(int i = 0; i < numV; i++){
			edges[i] = new LinkedList<Edge>();
		}
	}
	
	public boolean isEdge(int source, int dest){
		return edges[source].contains(new Edge(source, dest));
	}
	
	public void insert(Edge edge){
		edges[edge.getSource()].add(edge);
		if(!isDirected()){
			edges[edge.getDest()].add(new Edge(edge.getDest(), 
											   edge.getSource(), 
											   edge.getWeight()));
		}
	}
	
	public Iterator<Edge> edgeIterator(int source){
		return edges[source].iterator();
	}
	
	public Edge getEdge(int source, int dest){
		Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
		for(Edge edge : edges[source]){
			if(edge.equals(target))
				return edge; //Desired edge found; return it
		}
		//Assert: All edges for source checked.
		return target; //Desired edge not found.
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		int end = edges.length;
		for(int i=0; i < end; i++){
			sb.append("Node " + i + "-->\n");
			for(Edge e : edges[i]){
				sb.append("\tnode: " + e.getDest() + ", weight: " + e.getWeight() + "\n");
			}
		}
		return sb.toString();
	}
	
	@Override
	public void loadEdgesFromFile(Scanner scan){
		//System.out.println(edges.length);
		while(scan.hasNextLine())//while there are still more edges
		{
			Edge e = parseFileString(scan.nextLine());//parse a new Edge
			edges[e.getSource()].add(e); //Add the edge to the list of its source's edges
		}
		scan.close();
	}
	 public int[] breadthFirstSearch(int start) {
        Queue<Integer> theQueue = new LinkedList<>();
        int[] parent = new int[getNumV()];
        for(int i=0; i<getNumV();i++) {
        	parent[i]=-1;
        }
        boolean [] identified = new boolean[getNumV()];
        identified[start]=true;
        theQueue.offer(start);
        while (!theQueue.isEmpty()) {
            int current  = theQueue.remove();
           // System.out.print(current + " ");
            Iterator<Edge> itr = edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbour=edge.getDest();
                if (!identified[neighbour]) {
                    identified[neighbour] = true;
                    theQueue.offer(neighbour);
                }
            }
        }
        return parent;
	}
	private void DepthFirstSearch(int current) {
		/*Marked the current index visited*/
        visited[current] = true;
        discoveryOrder[discoveryIndex++]=current;
        //System.out.print(current + " ");
        /*Examine each vertex adjacent to the current vertex*/
        Iterator<Edge> iterator = edgeIterator(current);
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            if (!visited[edge.getDest()])
                DepthFirstSearch(edge.getDest());
        }
    }
	/**
  	 * Calling function
     * @param curr initial vertex
     */
    public void depthFirstSearch(int curr) {
        visited = new boolean[getNumV()];
        discoveryOrder = new int[getNumV()];
        DepthFirstSearch(curr);
    }
	private Edge parseFileString(String input)
	{
		Edge toReturn = null;//initialize an Edge to return
		Scanner sc = new Scanner(input);//scan a line as an edge
		sc.useDelimiter(AbstractGraph.DELIM);//use only comma delimiter
		try
		{ //in case we fail to parse anything, such as format didn't work
			int source = sc.nextInt();//scan x position of point
			
			int dest = sc.nextInt();//scan y position of point
			double weight = Edge.UNWEIGHTED_EDGE;
			if(sc.hasNextDouble())
				weight = sc.nextDouble(); //parse in the weight if it's there
			toReturn = new Edge(source, dest, weight);
		}
		catch(Exception e)	
		{
			System.out.println("Failed to parse Edge: "+input);
		}		
		sc.close();//close scanner
		return toReturn;//return the scanned point
	}

}