package com.revature.beans;

public class Reimbursement {
	private int reimbursementID;
	private int employeeID;
	private int amount;
	private String reason;
	private String photo;
	private boolean resolved;
	
	public Reimbursement(int reimbursementID, int employeeID, int amount, String reason, String photo, int resolvedBit) {
		super();
		this.reimbursementID = reimbursementID;
		this.employeeID = employeeID;
		this.amount = amount;
		this.reason = reason;
		this.photo = photo;
		switch(resolvedBit)
		{
		case 0:
			resolved = false;
			break;
		case 1:
			resolved = true;
			break;
		}
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
	
	public int getResolvedBit() {
		if(resolved == false)
		{
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public void setBoolean(int resolvedBit)
	{
		switch(resolvedBit)
		{
		case 0:
			this.resolved = false;
			break;
		case 1:
			this.resolved = true;
			break;
		}
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", employeeID=" + employeeID + ", amount=" + amount
				+ ", reason=" + reason + ", photo=" + photo + ", resolved=" + resolved + "]";
	}
	
	
}
