
public class Graph<E> 
{
		//Declares graph as a list, containing lists of nodes of type integer
		LinkedList<LinkedList<Integer>> graph;
		//Bool Array to keep track of "Visited" List
		boolean visited[] = null;
			 
		 	
	//Graph Constructor 		 	
	 Graph(int nodes) 									// Initializes when given a number of Nodes 
	{
			graph = new LinkedList<>(); 
			visited = new boolean[nodes]; 				//Creates a boolean array size # nodes 
			for (int index = 0; index < nodes; index++) // Fills each Node of graph List with an empty linkedList
		{
				graph.add(index, new LinkedList<>());  
		 
		}
	} 

	//Adds each Child node to the ChildList of Parent Node
	public void addEdge(int parentIndex,  Integer child) 
	 {
		graph.get(parentIndex).insert(child);
			    	       
	 }
	
	public void printAdj( int nodes)
	{  int num = 0;
		System.out.println("---- Adjecency List-----");
		while(nodes != 0)
		{
			LinkedList<Integer> childList = graph.get(num);
			System.out.println( "Node :"+ num +" -> " + childList  );
			num++;
			nodes--;
		}
	}
	public void bfs(int startIndex) 
	 {
		Queue<Integer> queue = new Queue<>(); 		//Queue to keep track of BFS trace
		queue.offer(startIndex);  					//First node (user selected) added to BFS trace
		System.out.println( "Root Node Selected " + startIndex + "\n");	
		
		visited[startIndex] = true; 				//use to check If Node has already been visited 
		String Q ="";								//String to Print final BFS trace
		while (!queue.isEmpty()) 					//BFS will continue until Queue is empty
		{
			Integer node = queue.poll(); 			//First Node is selected for expansion
	    
	    Q += node + " -> ";							
	    
	    LinkedList<Integer> childList = graph.get(node); //Pointer to child list of Node
	   
	    for(int child = 0; child < (childList.size()); child ++ )
	     {  
	    	Integer nodee = childList.get(child);
	    	
	    	if (!visited[nodee]) 		//if child has not been visited its added to the queue
	    	{ 
	    		queue.offer(nodee);
	    		//System.out.println( "      -> added to queue " +  nodee + " " );
	    		visited[nodee] = true;  // Child is then marked as visited
	        }
	  	 }
	    	
	    	
		}
		
		System.out.println("BFS Treee [ " + Q +" ]");
		
		
	} 
}
	


