import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


/**
 * This is a graph and Dijkstra and Prim program
 * @author Jason Chen
 *
 */
public class MyGraph{

	protected Vector vertices;
	protected Vector edges;
	protected Map<Integer, Vertex> graph;
/** Construct a new graph. */
	public MyGraph(){
		vertices = new Vector();
		edges = new Vector();
		graph = new HashMap<>();
		
	}
	
	/** Add a new vertex into the graph. If the new vertex already
	exists in the graph then return false.
	* @param int newNode: the vertex number of the new node.
	* @return true if the vertex number >=0 and is not used; otherwise
	false.
	*/
	public boolean addVertex(int newNode) {
		if(!vertices.contains(newNode) && newNode>=0){
			Vertex v = new Vertex(newNode);
			vertices.addElement(v);
			return true;
		}
		return false;
	}
	/** Add a new edge into the graph.
	* @param int source: the vertex number of the source node.
	* @param int destination: the vertex number of the destination
	node.
	* @param int weight: the weight of the edge.
	* @return true if the edge satisfies the following criteria: 1.
	valid source node. 2. valid destination node. 3. weight > 0. 4.
	No existing edge sharing the same source and destination;
	otherwise false.
	*/
	public boolean addEdge(int source, int destination, int weight) {
		Edge e = new Edge(source, destination, weight);
		if(source>=0 && destination>=0 && weight>=0 && (!edges.contains(e))){
			edges.addElement(e);
			return true;
		}
		return false;
	}
	/** Print the shortest distances and shortest paths of the graph.
	* @param int source: the vertex number of the source node.
	* @return true if the source node is valid; otherwise false.
	*/
	public boolean dijkstra(int source){
		
		final Vector<Integer> distance = new Vector<Integer>();
		final Vector<Integer> previous = new Vector<Integer>();
		final Vector<Boolean> visited = new Vector<Boolean>();
		
		for (int i=0; i<distance.size(); i++){
			distance.set(i, Integer.MAX_VALUE);
		}
		//distance.set(source, 0);
		
		for(Object e: edges){
			System.out.print(e.toString() + " ");
		}
		System.out.println();
		return true;
	
	/** print the shortest distances to all other nodes. For example:
	(<destination node 1>, <shortest_distance_to1>) (<destination
	node 2>, <shortest_distance_to2>) ...
	
	 print the shortest paths to all other nodes. For example:
	(<source node>, <intermediate node 1>, ..., <intermediate
	node k>, <destination node>) ...
	*/
	}
	
	/** Find the minimum spanning tree of the graph using Prime-Jarnik
	algorithm.
	* @param int source: the vertex number of the source node.
	* @return the result graph which contains .
	4
	*/
	public boolean prim(int source){
	// print all involved edges in the minimum spanning tree. For
	//example: (0, 1, 1) (1, 2, 1) (2, 3, 2)
		final Vector<Integer> distance = new Vector<Integer>();
		final Vector<Integer> previous = new Vector<Integer>();
		final Vector<Boolean> visited = new Vector<Boolean>();
		
		for (int i=0; i<distance.size(); i++){
			distance.set(i, Integer.MAX_VALUE);
		}
		//distance.set(source, 0);
		
		for(Object e: edges){
			System.out.print(e.toString() + " ");
		}
		System.out.println();
		return true;
	}
	
	public static int min (Vector<Integer> dis, Vector<Boolean> v){
		int x = Integer.MAX_VALUE;
		int y = -1;
		for(int i=0; i<dis.size(); i++){
			if (v.get(i)==false && dis.get(i)<x){
				y=i; x=dis.get(i);
			}
		}
		return y;
	}
	public class Vertex{
		private int element;
		
		public Vertex(int e){
			this.element = e;
		}
		public int getVertexElement(){
			return element;
		}
		
	}
	public class Edge{
		protected int source, destination;
		protected int weight;
		
		public Edge(int s, int d, int w){
			this.source = s;
			this.destination = d;
			this.weight = w;
		}
		public int getWeight(){
			return weight;
		}
		public int getSource(){
			return source;
		}
		public int getDestination(){
			return destination;
		}
		
	}
}