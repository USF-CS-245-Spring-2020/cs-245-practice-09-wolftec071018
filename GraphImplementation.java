import java.util.*;
/**
 * code for practice assignment 09.
 */
public class GraphImplementation implements Graph {

    // the grapgh
    private int[][] list;
    //keeps tracks of teh vertices
	private int vertices;

	public GraphImplementation(int vertices) {
		list = new int[vertices][vertices];
		this.vertices = vertices;
	}

	public void addEdge(int x, int y) throws Exception{
		if( y >= vertices || x> vertices ||  y < 0 ||x < 0 ) {
			throw new Exception("add edge error");
		}
		list[v1][v2] = 1; //add a 1 in list;
	}

    //**
    //deals with topological sort here
    
	public List<Integer> topologicalSort() {
		List<Integer> tList = new ArrayList<Integer>();

		int[] sum = new int[vertices];


		//goesthrough the double array
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < vertices; j++)
				sum[j] += list[i][j];
		}

		for(int count = 0; count < vertices; count++) {
            //calls a function to find zero
            int n = zero(sum);
            //if zero isnt found
			if(n == -1) {
				System.out.println("there is no zero");
			}
            //if theres a zero add it in the list and set to -1
			tList.add(n);
            sum[n] = -1;
            
            // goes through the sum lis and sets the sum_i value
			for(int i = 0; i < vertices; i++)
				sum[i] -= list[n][i];
		}

		return tList;
	}

	public List<Integer> neighbors(int vertex) throws Exception{
//checks that vertex is greater than vertices or if the vertex is negative.
		if(vertex > vertices || vertex < 0)
			throw new Exception("neighbor error");
        //makes a new arra list
        List<Integer> neighbors = new ArrayList<Integer>();
        //goes thre the list till the end of vertices, add to the neighbor arraylist for any that = to 1, when finish return that arraylist or neighbors
		for(int i = 0; i < vertices; i++) {
			if(list[vertex][i] == 1) {
				neighbors.add(i);
			}
		}

		return neighbors;

    }
    


    //pass int an array
	private int zero(int[] arr) {
        //goes through the lenght to find all the zeros, if found return where
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0)
				return i;
        }
        //if not found
		return -1;
}
}