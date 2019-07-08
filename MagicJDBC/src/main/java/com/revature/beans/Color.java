package com.revature.beans;

public class Color {
	
	private int colorID;
	private String colorName;
	
	public int getColorID() {
		return colorID;
	}
	public void setColorID(int colorID) {
		this.colorID = colorID;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	@Override
	public String toString() {
		return "Color [colorID=" + colorID + ", colorName=" + colorName + "]";
	}
	

}
