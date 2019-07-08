package com.revature.compare;

public class Student implements Comparable<Student>
{
	private int StudentID;
	private String label;
	private double gpa;
	
	public Student() {
		super();
	}

	public Student(int studentID, String label, double gpa) {
		super();
		StudentID = studentID;
		this.label = label;
		this.gpa = gpa;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [StudentID=" + StudentID + ", label=" + label + ", gpa=" + gpa + "]";
	}

	@Override
	public int compareTo(Student arg0) 
	{
		return this.getStudentID()-arg0.getStudentID();
	}
	
	
}
