
public class LinkedList<E>
{
	private Node<E> head;  
	private int size = 0 ; //How many nodes in List
	
//Constructor of Linked list 
	public LinkedList()
	{
		this.head = new Node<E>(null); //Head is set to Null for initilization of LL 
		this.size = 0;                 //When the LL is created size = 0;
	}


	public void add(int index, E item)
	{
	//This method adds an element to the LL
	//Depending on the index, it adds to the first location using addFirst()
	//or adds after a node using addAfter()
	if(index < 0 || index > size) { //Checking for valid index
		System.out.println("Invalid Index!");
		return;
		}
	else if(index == 0)
		{addFirst(item);
		}else
		{
	//If adding after some node, we need the reference of that node (Helper method)
		Node<E> node = getNode(index);
		addAfter(node,item);
		}
	}

	public void insert(E item) //This function adds node to the rear of list only
	{
		Node<E> node = new Node<>(item);
		if(head == null)
		{
			head.setNext(node); //If list is empty added node becomes the head
		}
		else {
			Node<E> h = head;
			while(h.getNext() != null)
			{
				h = h.getNext();
			}
			h.setNext(node);
		}
		size++;
	}
	

	private void addFirst(E item)
	{
	// We create a node, with item as data, and head.next as the next
	//The we update the head.next to point this newly created node and increment size
		head.setNext(new Node<E> (item, head.getNext()));
		size++;
	}

	public Node<E> getNode(int index) 
	{
		if(index < 0|| index > size) 
		{ //Checking for valid index
			System.out.println("Invalid Index!");
			return null;
		}
	// To get Node at index, it must loop over the LL, & return the reference
		Node<E> node = head; //Reference copy of the head
		if(index == 0) 
		{
			node = head.getNext();
			return node;
		}
		for(int i = 0; i < index && node != null; i++)
		{
			node = node.getNext();
		}
		
	return node; //return the references
	}


	private void addAfter(Node<E> node, E item)
	{	// Add the item after the reference "node"
		node.setNext(new Node<E>(item, null));
		size++;
	}

	public E remove(int index) 
	{
	// This met6hod removes and element from the LL at a given index
		if(index < 0|| index > size) {   //Checking for valid index
			System.out.println("Invalid Index!");
			return null;}
		else if(index == 0 )
		{
			return removeFirst();
		}
		else {
			Node<E> node = getNode(index);
			return removeAfter(node);
		}
	}

	private E removeFirst()
	{ // Deletes the first Node
		Node<E> temp = head; //Reference to head of list
		if(temp != null) //if not Empty return data at Head Node
		{ size--;
			return temp.getChildList();
		}
		else {
			return null; //If list is empty return null
		}}
	
	private E removeAfter(Node<E> node)
	{
		Node<E> temp = node.getNext(); 		//Temp reference to next node
		if(temp != null) 			    	//if this next node is not the end of the list
		{  
			node.setNext(temp.getNext()); 	//node references the node after temp
			size--;
			return temp.getChildList();
					
		}
	else
		{	return null;  }					//if next node is null, it returns null
	}


	public E get(int index)
	{
		if(index < 0|| index >= size) { 	//Checking for valid index
			System.out.println("Invalid Index!");
			return null;
		}
		
		Node<E> temp ; //To add Child List of each Node in the Adjency List
		if(index == 0)
		{
			temp = getNode(index);
			//System.out.println(" adding Nodes to list of each item");
			//System.out.println("data at index :::: " + index  + " = " + temp.getChildList());
			return temp.getChildList();
		}
		else 
		{
			temp = getNode(index + 1); 
		}
		
	    
	    return temp.getChildList();//returns data at given index
	   
	}


	public E set(int index, E newValue)
	{
		if(index < 0|| index > size) 	//Checking for valid index
	{
			System.out.println("Invalid Index!");
			return null;
	}
		remove(index); //removes existent Node at place
		add(index, newValue);
		return null;

	}

	public int size()  //returns size of LL
	{
		return this.size;
	}
	
	//Implements toString() to print the LL data
	public String toString()
	{
		String s = "[";
		Node<E> p = head; //This reference will be used to iterate over the LL
		if(p != null)
	{ //When there is no head, check the error
			while(p.getNext() != null)
			{
				s += p.getNext().getChildList() + " -> ";  //Adds the data to the String
				p = p.getNext(); //Go to the next Node
			}
	}
		s += "]";
		return s;
	}

	//Print the L.L in reverse using recursion
	public void printReverse(Node<E> head)
	{
		if(head.getNext() == null)
		{
			return; //base case
		}
	printReverse(head.getNext());
	System.out.print(head.getNext().getChildList() + " <-"); //cant directly call this metod from main
	}

	//Wrapper method to call printReverse
	public void printReverse()
	{
		this.printReverse(head);
	}

	public boolean isEmpty()
	{
	return(this.size == 0);
	}

	public Node<E> getHead() 
	{
		return head;
	}

	public void setHead(Node<E> head)
	{
			this.head = head;
	}
}//End of LinkedList Implementation

class Queue<E> 
{

	//Data
	private E[] Q; //Array reference for the actual queue
	private int front; //front of the queue
	private int rear; //rear of the queue
	private int size; //numbers of elements in the  queue
	private int capacity; //how many elements allowed in q
	private final int DEFAULT_CAPACITY = 10; //default capacity

	//Default constructor (created but empty)
	public Queue() {
	this.Q = (E[]) new Object[this.DEFAULT_CAPACITY]; //Queue is created here (cast it) 
	this.front = 0;
	this.rear =  0; //front and rear = 0 no element to begin with
	this.size = 0;
	this.capacity = this.DEFAULT_CAPACITY;

	}
	
	//overloaded constructor when user gives capacity
	public Queue(int capacity) 
	{
	this.capacity = capacity; //given by the user
	Q = (E[]) new Object[this.capacity]; //object created here
	this.front = 0;
	this.rear = 0;
	this.size = 0;
	}


	public void offer(E obj) 
	{  // Adds elements at rear, first check if there is space to add
	if(isFull())
	{
	System.out.println("Queue out of space ; calling reallocate");
	reallocate();
	this.offer(obj); //Once space avaliable, this method is called again (calls itself).
	}
	else { //So we have space to add element at the rear of the queue
	Q[rear] = obj; //inserts the elements at rear
	rear =(rear + 1)%this.capacity; //update the rear pointer circular array
	size++; //updates number of elements in queue
	}
	}


	private void reallocate()
	{//copy elements from front to rear
		int newCapacity = 2 * this.capacity;
		E[] newQ = (E[]) new Object[newCapacity];
		int newfront = front;
		for (int i = 0; i < size; i++) 
		{
			newQ[i] = Q[newfront];
			newfront = (newfront + 1) % capacity;
		}
			front = 0;
			rear = size;
			capacity = newCapacity;
			Q = newQ;
	}

	
	public E poll() 
	{ // Removes an element from the front of the queue , if there is one
		if(isEmpty()) //if empty nothing to remove
		{
			System.out.println("Queue underFlow!");
			return null;
		}
		//If  Q is not empty will remove the data from the front , and return it
		E temp = Q[front]; 					//Store data to be returned
		front = (front + 1) %this.capacity; //updates front
		size--; 							//updates size
		return temp;
	}

	public boolean isEmpty()
	{
		return(this.size == 0);
	}


	public boolean isFull() 
	{
		return (this.size == this.capacity);
	}

	public E peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue underFlow!");
			return null;
		}
		return Q[front];
	}

	//implement the toString method to display the contenets of the queue
	public String toString()
	{
		String s = "Q : "; //create initial string
	//loop over the elements in the  Q, from the front to the rear(not zero)
		for(int i= front; i < front + size; i++)
		 {
			s += Q[i %this.capacity] + " | " ;  //add to the string the element at i %5(capacity)
		 }
		return s;
	}

}//End of Circular Queue implementation 
	

