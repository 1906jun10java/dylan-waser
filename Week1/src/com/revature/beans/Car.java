package com.revature.beans;

public class Car extends Vehicle implements Comparable<Car> {

	

	// best practices: explicitly declare a noargs constructor
	// when any constructor is present, we are not provided the default constructor

	public Car() {
		super(); // call to superclass' constructor
	}

	public Car(int yearManufactured, String make, String model, Double fuelLevel, TransmissionType transmission) {
		super();
		this.yearManufactured = yearManufactured;
		this.make = make;
		this.model = model;
		this.fuelLevel = fuelLevel;
		this.transmission = transmission;
	}

	private int yearManufactured;
	private String make;
	private String model;
	private Double fuelLevel;
	private TransmissionType transmission = TransmissionType.MANUAL;
	
	public TransmissionType getTransmissionType()
	{
		return transmission;
	}
	
	public void setTransmissionType(TransmissionType transmission)
	{
		this.transmission = transmission;
	}

	public Integer getYearManufactured() { //im autoboxing the primitive int value of the instance variable into
		return yearManufactured;			//an instance of its wrapper class (Integer)
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	@Override
	public int compareTo(Car arg0) {
		return this.make.compareTo(arg0.getMake());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fuelLevel == null) ? 0 : fuelLevel.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
		result = prime * result + yearManufactured;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (fuelLevel == null) {
			if (other.fuelLevel != null)
				return false;
		} else if (!fuelLevel.equals(other.fuelLevel))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (transmission != other.transmission)
			return false;
		if (yearManufactured != other.yearManufactured)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", make=" + make + ", model=" + model + ", fuelLevel="
				+ fuelLevel + ", transmission=" + transmission + "]";
	}

}