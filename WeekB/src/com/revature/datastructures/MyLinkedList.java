package com.revature.datastructures;

public class MyLinkedList<T> {

	public MyLinkedList()
	{
		
	}
	
	//root node of the list, the 'head'
	private Node<T> head;
	
	//end node of the list, 'tail'
	private Node<T> tail;
	
	//insert a node at the end of the list
	public void insert(T data)
	{
		//create a new Node for the data
		Node<T> newNode = new Node<>(null, data);
		
		//if the head is null, this new node will become the head
		if(this.head == null)
		{
			System.out.println("List is empty, adding first element");
			this.head = newNode;
			this.tail = newNode;
		}
		//otherwise, we add this as the tail
		else 
		{
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
	}
	
	//remove and return the first item in the list
	public T poll()
	{
		Node<T> firstNode = this.head;
		if(firstNode != null)
		{
			this.head = firstNode.getNextNode();
			return firstNode.getData();
			
		}
		return null;
	}
	
	//return but not remove the head
	public T peek()
	{	
		if(this.head != null)
		{
			return this.head.getData();
		}
		return null;
	}
	
	//remove specified element in the list which whose data matches provided key
	public boolean removeByKey(T key)
	{
		if(key == null)
		{
			return false;
		}
		
		//create a reference to current node
		Node<T> currentNode = this.head;
		
		//create a reference to the next node (after the current)
		Node<T> nextNode = currentNode.getNextNode();
		
		//if first node matches the key, move head to next node
		if(currentNode != null && currentNode.getData() != null && currentNode.getData().equals(key))
		{
			this.head = nextNode;
			return true;
		}
		
		//iterate through list while currentNode != null
		while(currentNode != null)
		{
			//if nextNode is not null and matches they key
			//point currentNode to the node after nextNode and return true
			if(nextNode != null && nextNode.getData().equals(key))
			{
				currentNode.setNextNode(nextNode.getNextNode());
				return true;
			}
			
			//advance currentNode to the next node in the list
			currentNode = currentNode.getNextNode();
			
			//if nextNode is not null, advance next node to the one after it
			if(nextNode != null)
			{
				nextNode =nextNode.getNextNode();
			}
		}
		
		return false;
	}
	
	//method for removing duplicates in the list
	public boolean removeDuplicate()
	{		
		//create a reference to current node
		Node<T> currentNode = this.head;
		Node<T> tempNode;
		T currentValue = null;
		
		//do we have a list in the first place?
		if(this.head != null)
		{
			currentValue = currentNode.getData();
			System.out.println("at beginning of list, initial value = " + currentValue);
			
			do
			{
				//things
				System.out.println("beginning outer loop iteration");
				tempNode = currentNode; //have "runner" start in the same spot as the current node
				//dont need to re-check earlier nodes in the list
				
				while(tempNode != null && tempNode.getNextNode() != null)
				{
					//check for matches
					T nextValue = tempNode.getNextNode().getData();
					System.out.println("Comparing values( " + currentValue + ", " + nextValue +
										")");
					if(currentValue.equals(nextValue))
					{
						System.out.println("removing first instance of the value: " + currentValue);
						this.removeByKey(currentValue);
					}
					System.out.println("moving tempNode to next node");
					tempNode = tempNode.getNextNode();
					
				}
				System.out.println("Moving to currentNode to the next node");
				if(currentNode.getNextNode() != null)
				{
					System.out.println("no more duplicates of " + currentValue + " left" + "\n" +
										"++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					this.printList();
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					currentValue = currentNode.getNextNode().getData();
					currentNode = currentNode.getNextNode();
				}
				
			}while(currentValue != null && currentNode.getNextNode() != null);
			//exit iteration if current node's value is null OR there is no nest node
			//note: a refinement would be to scrub out or skip all nodes with null valeus
			//instead of quitting as soon as we fine one
		}
		
				
		return false;
	}
	
	//convenience method for printing the list
	public void printList()
	{
		Node<T> currentNode = this.head;
		while(currentNode != null)
		{
			System.out.println("Node location: " + currentNode.hashCode() + ", Node value: " + currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}
	
	
}
