//Josahandi Cisneros
//CSC 401 
//Fall 2021 Term Project: Breadt-First Search (BFS) Algorithm

import java.nio.file.*; //Libraries imported to read file and user input
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.*;


public class BFSTest {

	public static void main(String[] args) 
	{	//Path to text file "startgraph"
		Path file = Paths.get("/home/josahandi/eclipse-workspace/Cisneros_BFS/startgraph"); 
		//Scanner obj to read user Input of selection of start Node [0-4]
		Scanner inputUser= new Scanner(System.in); 
		String s = ""; 		 //creates a string know its 
		String  matrix = ""; //To print out contents of Input File
		int nodes ; 		 //variable for number of nodes as indicated on Adj. Matrix from input file 
		    
		
		 try 
		 { //To read text input file
			InputStream input = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input)); 
			int index = 0 ; 		// To keep track of each line 
			s = reader.readLine();	// Each line is read as String 
			nodes = s.length();		//number of nodes 
			Graph graph = new Graph(nodes); // Initializes Empty Adj. List with 5 Nodes
			//Obtains Node information from input fill empty Adj. List
			while( s != null)
			{ matrix += s + "\n";
				for(int i = 0; i < nodes; i++ ) //loop to process contents of file line by line
			 		{	if( s.charAt(i) == '1')
			 			{	// Adds Children Nodes to Each Parent Node based on Adj Matrix
			 				graph.addEdge(index, i ); 
			 			}
			 		
			 		}
			 index++;
			 s = reader.readLine();
			}
			
			System.out.println( "Matrix Represantation of Input graph " ); 
			System.out.println(matrix); 
			System.out.println("Number of Nodes in graph: " + nodes); 
			graph.printAdj(nodes);
			
			System.out.println("Select Root Node to start BFS [0-4]  : ");
			int startNode = inputUser.nextInt();
			graph.bfs(startNode);
			
			
			reader.close();
		 	} catch(Exception e) 
		 	{ 
		 		System.out.println("Message " + e); 
		 	} 
	} 
	

}
