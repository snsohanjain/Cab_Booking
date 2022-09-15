package com.sohan.cabbooking.services;

import java.util.ArrayList;

import com.sohan.cabbooking.command.CabBookingConstants;
import com.sohan.cabbooking.command.CabManager;
import com.sohan.cabbooking.entities.Cab;
import com.sohan.cabbooking.entities.CabBookingRequest;
import com.sohan.cabbooking.entities.Location;

public class SimpleCabAssignStrategy implements ICabAssignStrategy {
    @Override
    public Cab assignCab(CabBookingRequest cabBookingRequest) {
        ArrayList<Cab> cabs = CabManager.getInstance().findBOOKEDCabs();
        Double minDistance = CabBookingConstants.MAX_PICKUP_DISTANCE;
        Cab foundCab = null;
        for (int i = 0; i < cabs.size(); i++) {
            // max pickup distance logic and return one cab;
            Double distance = calculateDistance(cabs.get(i).getLocation(),
                    cabBookingRequest.getRiderInfo().getLocation());
            if (distance <= minDistance) {
                minDistance = distance;
                foundCab = cabs.get(i);
            }
        }
        return foundCab;
    }

    private Integer getDiffSquare(Integer n1, Integer n2) {
        return (n1 - n2) * (n1 - n2);
    }

    private Double calculateDistance(Location p1, Location p2) {
        return Math.sqrt(getDiffSquare(p1.getX(), p2.getX()) + getDiffSquare(p1.getY(), p2.getY()));
    }

}
