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
		if(currentNode != null && currentNode.getData().equals(key))
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
