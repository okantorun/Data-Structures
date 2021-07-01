
public class driver {

	public static void main(String[] args) {
		ListGraph listGraph =new ListGraph(51,false);
		@SuppressWarnings("unused")
		MatrixGraph matrixGraph=new MatrixGraph(51, false);
		
		System.out.println("---------------------------------------------Edge Properties------------------------------------");
		
		System.out.println("---------------ListGraph-Quality---*----------------");
		double[] weights=new double[51];
		int[] pred=new int[51];
		for(int i=0;i<50;i++){
			listGraph.insert(new Edge<Double>(i,i+1,5.0));
		}
		Dijkstras.dijkstras(listGraph, 0, pred, weights,'q',"List","*");
		for(int i=0;i<51;i++) {
			System.out.println(weights[i]);
		}
		
		
		System.out.println("---------------ListGraph-Quality-Multiplication--------------");
		weights=new double[51];
		pred=new int[51];
		Dijkstras.dijkstras(listGraph, 0, pred, weights,'q',"List","Multiplication");
		for(int i=0;i<51;i++) {
			System.out.println(weights[i]);
		}
		
		System.out.println("---------------ListGraph-Quality-Addition--------------");
		weights=new double[51];
		pred=new int[51];
		Dijkstras.dijkstras(listGraph, 0, pred, weights,'q',"List","Addition");
		for(int i=0;i<51;i++) {
			System.out.println(weights[i]);
		}
		
		
		System.out.println("---------------MatrixGraph-Time---*----------------");
		weights=new double[51];
		pred=new int[51];
		for(int i=0;i<50;i++){
			matrixGraph.insert(new Edge<Double>(i,i+1,5.0));
		}
		Dijkstras.dijkstras(matrixGraph, 0, pred, weights,'t',"Matrix","*");
		for(int i=0;i<51;i++) {
			System.out.println(weights[i]);
		}
		
		System.out.println("---------------MatrixGraph-Time---Multiplication----------------");
		Dijkstras.dijkstras(matrixGraph, 0, pred, weights,'t',"Matrix","Multiplication");
		for(int i=0;i<51;i++) {
			System.out.println(weights[i]);
		}
		
		System.out.println("---------------MatrixGraph-Time---Addition----------------");
		Dijkstras.dijkstras(matrixGraph, 0, pred, weights,'t',"Matrix","Addition");
		for(int i=0;i<51;i++) {
			System.out.println(weights[i]);
		}
	}

}
