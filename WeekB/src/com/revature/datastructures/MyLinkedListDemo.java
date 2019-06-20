package com.revature.datastructures;

import com.revature.model.User;

public class MyLinkedListDemo {

	public static void main(String[] args) {
		
		User u1 = new User("Ganalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		
		MyLinkedList<User> userList = new MyLinkedList<>();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++" + "\n" +
							"List before insertions");
		userList.printList();
		
		userList.insert(u1);
		userList.insert(u2);
		userList.insert(u3);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++" + "\n" +
							"List after insertions");
		userList.printList();
	/*	System.out.println("+++++++++++++++++++++++++++++++++++++++++++" + "\n" +
							"Test peek()" + "\n" +
							"Head: " + userList.peek() + "\n" +
							"++++++++++++++++++++++++++++++++++++++++++" + "\n" +
							"Test poll()" + "\n" +
							"Head: " + userList.poll());
		userList.printList();
	*/	
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		User u4 = new User("David", "Tennant", "doc10", "tardis");
		userList.removeByKey(u4);
		userList.printList();
		
	}

}
