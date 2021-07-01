
import java.util.*;

/** 
 * A class for calling Dijkstra's algorithm.
 */

public class Dijkstras {

  /** Dijkstra's Shortest-Path algorithm.
      @param graph The weighted graph to be searched
      @param start The start vertex
      @param pred Output array to contain the predecessors
                  in the shortest path
      @param dist Output array to contain the distance
                  in the shortest path
   */
  @SuppressWarnings("deprecation")
public static void dijkstras(Graph graph, int start,int[] pred,double[] dist,char weightType,String storedType,String operator) {
    int numV = graph.getNumV();
    HashSet < Integer > vMinusS = new HashSet < Integer > (numV);
    // Initialize V-S.
    for (int i = 0; i < numV; i++) {
      if (i != start) {
        vMinusS.add(i);
      }
    }
    // Initialize pred and dist.
    for (int v : vMinusS) {
      pred[v] = start;
      dist[v] = (double) graph.getEdge(start, v).getEdgeProperties();
    }
    
    // Main loop
    while (vMinusS.size() != 0 && storedType.equals("Matrix")) {
      // Find the value u in V�S with the smallest dist[u].
    	double minDist = Double.POSITIVE_INFINITY;
        int u = -1;
        for (int v : vMinusS) {
          if (dist[v] < minDist) {
            minDist = dist[v];
            u = v;
          }
        }
      // Remove u from vMinusS.
      vMinusS.remove(u);
      
      // Update the distances.
       if( weightType=='t' || weightType=='w') {
		  for (int v : vMinusS) {
		    if (graph.isEdge(u, v)) {
		      double weight = (double) graph.getEdge(u, v).getEdgeProperties();
		      //low time and low weight routes are preferred
		      
		      //Addition operator
		      if (operator.equals("Addition") && dist[u] + weight < dist[v]) {
		        dist[v] = dist[u] + weight;
		        pred[v] = u;
		      }
		      //Multilication operator
		      else if (operator.equals("Multiplication") && dist[u] * weight < dist[v]) {
			        dist[v] = dist[u] * weight;
			        pred[v] = u;
			  }
		      // * OPERATOR
		      else if (operator.equals("*") && (dist[u] + weight) - (dist[u] * weight) < dist[v]) {
			        dist[v] = (dist[u] + weight) - (dist[u] * weight);
			        pred[v] = u;
			  }
		    }
		  }
    	}
       else if( weightType=='q') {
    	   for (int v : vMinusS) {  		 
   		    if (graph.isEdge(u, v)) {
   		      double weight = (double) graph.getEdge(u, v).getEdgeProperties();
   		      //High quality road is preferred
   		 //Addition operator
		      if (operator.equals("Addition") && dist[u] + weight < dist[v]) {
		        dist[v] = dist[u] + weight;
		        pred[v] = u;
		      }
		      //Multilication operator
		      else if (operator.equals("Multiplication") && dist[u] * weight < dist[v]) {
			        dist[v] = dist[u] * weight;
			        pred[v] = u;
			  }
		      // * OPERATOR
		      else if (operator.equals("*") && (dist[u] + weight) - (dist[u] * weight) < dist[v]) {
			        dist[v] = (dist[u] + weight) - (dist[u] * weight);
			        pred[v] = u;
			  }
   		    }
   		  }
       }
    }
    while (vMinusS.size() != 0 && storedType.equals("List")) {
        // Find the value u in V�S with the smallest dist[u].
        double minDist = Double.POSITIVE_INFINITY;
        int u = -1;
        for (int v : vMinusS) {
          if (dist[v] < minDist) {
            minDist = dist[v];
            u = v;
          }
        }
        // Remove u from vMinusS.
        vMinusS.remove(u);
        
        // Update the distances.
        Iterator<Edge> edgeIter = graph.edgeIterator(u);
         if( weightType=='t' || weightType=='w') {
  		  while (edgeIter.hasNext()) {
  			  Edge edge =edgeIter.next();
  			  int v=edge.getDest();
  		    if (vMinusS.contains(new Integer(v))) {
  		      double weight = (double) edge.getEdgeProperties();
  		      //low time and low weight routes are preferred
  		      //Addition operator
		      if (operator.equals("Addition") && dist[u] + weight < dist[v]) {
		        dist[v] = dist[u] + weight;
		        pred[v] = u;
		      }
		      //Multilication operator
		      else if (operator.equals("Multiplication") && dist[u] * weight < dist[v]) {
			        dist[v] = dist[u] * weight;
			        pred[v] = u;
			  }
		      // * OPERATOR
		      else if (operator.equals("*") && (dist[u] + weight) - (dist[u] * weight) < dist[v]) {
			        dist[v] = (dist[u] + weight) - (dist[u] * weight);
			        pred[v] = u;
			  }
  		    }
  		  }
      	}
         else if( weightType=='q') {
        	 while (edgeIter.hasNext()) {
     			  Edge edge =edgeIter.next();
     			  int v=edge.getDest();
     		    if (vMinusS.contains(new Integer(v))) {
     		      double weight = (double) edge.getEdgeProperties();
     		      //low time and low weight routes are preferred
     		   //Addition operator
    		      if (operator.equals("Addition") && dist[u] + weight < dist[v]) {
    		        dist[v] = dist[u] + weight;
    		        pred[v] = u;
    		      }
    		      //Multilication operator
    		      else if (operator.equals("Multiplication") && dist[u] * weight < dist[v]) {
    			        dist[v] = dist[u] * weight;
    			        pred[v] = u;
    			  }
    		      // * OPERATOR
    		      else if (operator.equals("*") && (dist[u] + weight) - (dist[u] * weight) < dist[v]) {
    			        dist[v] = (dist[u] + weight) - (dist[u] * weight);
    			        pred[v] = u;
    			  }
     		    }
     		  }
         }
      }
  }
}
