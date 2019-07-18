package com.revature.beans;

public class Reimbursement {
	private int reimbursementID;
	private int employeeID;
	private int amount;
	private String reason;
	private String photo;
	
	public Reimbursement(int reimbursementID, int employeeID, int amount, String reason, String photo) {
		super();
		this.reimbursementID = reimbursementID;
		this.employeeID = employeeID;
		this.amount = amount;
		this.reason = reason;
		this.photo = photo;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", employeeID=" + employeeID + ", amount=" + amount
				+ ", reason=" + reason + ", photo=" + photo + "]";
	}
	
	
}
