package com.sohan.cabbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sohan.cabbooking.command.CabManager;
import com.sohan.cabbooking.config.RiderManager;
import com.sohan.cabbooking.entities.Cab;
import com.sohan.cabbooking.entities.CabBookingRequest;
import com.sohan.cabbooking.entities.Driver;
import com.sohan.cabbooking.entities.Location;
import com.sohan.cabbooking.entities.Rider;
import com.sohan.cabbooking.repositories.RiderAccount;

@SpringBootApplication
public class CabbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabbookingApplication.class, args);

		// Cab current Location assign
		Location cabLocation1 = new Location(10, 1);
		Location cabLocation2 = new Location(11, 10);
		Location cabLocation3 = new Location(5, 3);

		// Cab Driver Name Assigning
		Driver driver1 = new Driver("SohanJain");
		Driver driver2 = new Driver("NithinJain");
		Driver driver3 = new Driver("Jayanth Jain");

		// Cab Driver Details Assigin to there cabs
		Cab cab1 = new Cab(driver1, 'M', 22, "Swift", "KA-01-12345", cabLocation1);
		Cab cab2 = new Cab(driver2, 'M', 29, "Swift", "KA-01-12345", cabLocation2);
		Cab cab3 = new Cab(driver3, 'M', 24, "Swift", "KA-01-12345", cabLocation3);

		// Cab Driver Assigin to the cab Servive on
		CabManager.getInstance().addCab(cab1);
		CabManager.getInstance().addCab(cab2);
		CabManager.getInstance().addCab(cab3);

		// Test Cases 1:
		// find_ride(“Abhishek” ,(0,0),(20,1))
		Location riderLocation1 = new Location(0, 0);
		RiderAccount riderAccount1 = new RiderAccount("Abhishek");
		Rider rider1 = new Rider(riderAccount1, riderLocation1);
		RiderManager.getInstance().addRider(rider1);
		CabBookingRequest find_ride1 = RiderManager.getInstance().requestCab(rider1, new Location(20, 20));
		System.out.println(find_ride1);
		// To check the status of that person What he is doning will he free or In a
		// Ride
		System.out.println(RiderManager.getInstance().findRider("Abhishek").getStatus());

		// Test Cases 2:
		// find_ride(“Rahul” ,(10,0),(15,3))
		Location riderLocation2 = new Location(10, 0);
		RiderAccount riderAccount2 = new RiderAccount("Rahul");
		Rider rider2 = new Rider(riderAccount2, riderLocation2);
		RiderManager.getInstance().addRider(rider2);
		CabBookingRequest find_ride2 = RiderManager.getInstance().requestCab(rider2,
				new Location(15, 30));
		System.out.println(find_ride2);
		// To check the status of that person What he is doning will he free or In a
		// Ride
		System.out.println(RiderManager.getInstance().findRider("Rahul").getStatus());

		// Test Cases 3:
		// //choose_ride(“Rahul”,”Driver1”)
		// Location riderLocation3 = new Location(10, 0);
		// RiderAccount riderAccount3 = new RiderAccount("Rahul");
		// Rider rider3 = new Rider(riderAccount3, riderLocation3);
		// RiderManager.getInstance().addRider(rider3);
		// CabBookingRequest choose_ride = RiderManager.getInstance().requestCab(rider3,
		// new Location(15, 0));
		// System.out.println(choose_ride);

		// Test Cases 4:
		// find_ride(“Nandini”,(15,6),(20,4))
		// Location riderLocation4 = new Location(15, 6);
		// RiderAccount riderAccount4 = new RiderAccount("Nandini");
		// Rider rider4 = new Rider(riderAccount4, riderLocation4);
		// RiderManager.getInstance().addRider(rider4);
		// CabBookingRequest find_ride4 = RiderManager.getInstance().requestCab(rider2,
		// new Location(20, 4));
		// System.out.println(find_ride4);

		// System.out.println(RiderManager.getInstance().findRider("Abhishek").getStatus());
		// System.out.println(RiderManager.getInstance().findRider("Rahul").getStatus());
		// System.out.println(RiderManager.getInstance().findRider("Nandini").getStatus());

	}

}
