package com.revature.beans;

public class MCard {
		
	private int mCardID;
	private String mCardName;
	
	public MCard()
	{
			
	}
	
	public MCard(int mCardID, String mCardName)
	{
		this.mCardID = mCardID;
		this.mCardName = mCardName;
	}

	public int getmCardID() {
		return mCardID;
	}

	public void setmCardID(int mCardID) {
		this.mCardID = mCardID;
	}

	public String getmCardName() {
		return mCardName;
	}

	public void setmCardName(String mCardName) {
		this.mCardName = mCardName;
	}

	@Override
	public String toString() {
		return "MCard [mCardID=" + mCardID + ", mCardName=" + mCardName + "]";
	}
		
		
}