package com.revature.datastructures;

import com.revature.model.User;

public class MyLinkedListDemo {

	public static void main(String[] args) {
		
		User u1 = new User("Ganalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("David", "Tennant", "doc10", "tardis");
		User u3 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u4 = new User("David", "Tennant", "doc10", "tardis");
		User u5 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u6 = new User("Ganalf", "Grey", "mithrandir", "you_shall_not");
		User u7 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		
		MyLinkedList<User> userList = new MyLinkedList<>();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++" + "\n" +
							"List before insertions");
		userList.printList();
		
		userList.insert(u1);
		userList.insert(u2);
		userList.insert(u3);
		userList.insert(u4);
		userList.insert(u5);
		userList.insert(u6);
		userList.insert(u7);
		
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
		
	/*	
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		User u4 = new User("David", "Tennant", "doc10", "tardis");
		userList.removeByKey(u4);
	*/
		userList.removeDuplicate();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++" + "\n" +
							"Printing list after removal of dups");
		userList.printList();
		
	}

}
