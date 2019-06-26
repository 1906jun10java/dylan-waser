package comrevature;

import com.revature.beans.Car;
import com.revature.exception.MaintenanceException;
import com.revature.service.TransportationService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * create an instance of TransportationService
		 */
		TransportationService ts = new TransportationService();
		try {
			ts.drive(null);
		
		
		//no exceptions thrown from this!
		Car c = new Car(1998, "Mustang", "Mustang", 90.0);
			ts.drive(c);
		
		//now, throw an exception
		Car c2 = new Car(1997, "Mustang", "Mustang", 0.0);
		}
		catch(MaintenanceException m)
		{
			m.printStackTrace();
		}
	

	}

}