package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.addAll(Arrays.asList(
				new Student[] 
				{
					new Student(12, "Matt", 9.3),
					new Student(13, "Dylan", 9.3),
					new Student(14, "Shyam", 3.2),
					new Student(15, "Alphonse", 2.4),
					new Student(16, "Mustafa", 4.0),
					new Student(17, "Ben", 3.0),
					new Student(18, "Cody", 3.3),
					new Student(19, "Nick", .8),
				}));
		System.out.println("Original List");
		for(Student s : studentList)
		{
			System.out.println(s.toString());
		}
		System.out.println("Sort by Label w/ Lambda");
		Collections.sort(studentList, (arg0, arg1)		//THIS IS AN OVERRIDE OF SORT
														//BY PUTTING IN THE SECOND ARG
				->{return arg0.getLabel().compareTo(arg1.getLabel());}
		
		
		
		);
		for(Student s : studentList)
		{
			System.out.println(s.toString());
		}
		System.out.println("Compare using normal interface convention");
		Collections.sort(studentList);
		for(Student s : studentList)
		{
			System.out.println(s.toString());
		}
	}

}
