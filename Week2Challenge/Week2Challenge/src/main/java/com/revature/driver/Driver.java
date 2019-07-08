package com.revature.driver;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.daoimpl.DepartmentDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;

public class Driver {
	static public Scanner kb = new Scanner(System.in);
	static public EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static public DepartmentDAOImpl ddi = new DepartmentDAOImpl();
	
	public static void main(String[] args) {
		int inputOption = 0;
		while(inputOption < 1 || inputOption > 3)
		{
			try
			{
				System.out.println("Welcome, what would you like to do?" + "\n" +
						"1. Create new Employee" + "\n" +
						"2. Display Average salary for each department" + "\n" +
						"3. Exit");
				inputOption = kb.nextInt();
				if(inputOption < 1 || inputOption > 3)
				{
					throw new InputMismatchException();
				}
				else if(inputOption == 3)
				{
					System.exit(-1);
				}
				switch(inputOption)
				{
				case 1:
					inputOption = 0;
					while(inputOption < 1 || inputOption > 3)
					{
						try
						{
							System.out.println("What is the employees first name");
							String newFirstName = kb.next();
								
							System.out.println("What is the employees last name");
							String newLastName = kb.next();
								
							System.out.println("What department will they belong to?" + "\n" +
									"1. Trainer" + "\n" +
									"2. Human Resources" + "\n" +
									"3. Associate");
							inputOption = kb.nextInt();
							int newDepartmentID = inputOption;
							if(inputOption < 1 || inputOption > 3)
							{
								throw new InputMismatchException();
							}
							System.out.println("What is the employees salary going to be?");
							double newSalray = kb.nextDouble();
							System.out.println("What is the employees email");
							String newEmail = kb.next();
							edi.createEmployee(newFirstName, newLastName, newDepartmentID, newSalray, newEmail);
						}
						catch(InputMismatchException inputMismatch)
						{
							System.out.println("That is not a valid option.");
							inputOption = 0;
							continue;
						}
						catch(Exception e)
						{
							System.out.println("Something went wrong");
							inputOption = 0;
							continue;
						}
					}
					inputOption = 0;
					break;
				case 2:
					try {
						edi.calcAVGSalaryPerDepartment();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					inputOption = 0;
					break;
				}
				
			}
			catch(InputMismatchException inputMismatch)
			{
				System.out.println("That is not a valid option.");
			}
		}
	}
}
