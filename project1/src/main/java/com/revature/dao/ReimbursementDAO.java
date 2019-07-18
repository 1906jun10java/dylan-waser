package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

	//create reimbursement
	public abstract void createReimbursement(int EMPLOYEEID, int AMOUNT, String REASON, String PHOTO)
		throws SQLException;
	
	//readAll reimbursement
	public abstract ArrayList<Reimbursement> readAllReimbursement()
		throws SQLException;
	
	//read reimbursement
	public abstract Reimbursement readReimbursement(Reimbursement r)
		throws SQLException;
	
	//update reimbursement
	public abstract void updateReimbursement(Reimbursement r)
		throws SQLException;
	
	//delete reimbursement
	public abstract void deleteReimbursement(Reimbursement r)
		throws SQLException;
}
