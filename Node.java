

public class Node<F>
{
	
	private Node<F> next; 			// the link to the next node
	private F childList; 			//Data at the node this case the list 
	private boolean visted;			//Not used for BFS

	public Node() 					//Node Constructor w
	{
		this(null, null, false);
	}
	

	public Node(F childList) 		//Constructor when only the data is supplied
	{
		this(childList, null, false); //To call the other constructor to create the Node
	}

	
	public Node(F childList, Node<F> next) //Constructor when only the data is supplied
	{
			this(childList, next, false); //To call the other constructor to create the Node
	}
	
	public Node(F childList, Node<F> next, boolean visited)
	{
		this.childList = childList;
		this.next = next;
		
	}
	
	
	public F getChildList() {
		return childList;
	}

	public void setChildList(F childList) {
		this.childList = childList;
	}


	public Node<F> getNext() 
	{
		return next;
	}


	public void setNext(Node<F> next) 
	{
		this.next = next;
	}


}
