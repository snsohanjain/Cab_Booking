package com.sohan.cabbooking.services;

import com.sohan.cabbooking.entities.Cab;
import com.sohan.cabbooking.entities.CabBookingRequest;
import com.sohan.cabbooking.enums.CabBookingStatus;
import com.sohan.cabbooking.enums.CabStatus;
import com.sohan.cabbooking.enums.RiderStatus;

public class CabBookingService {
    ICabAssignStrategy cabAssignStrategy;

    public CabBookingService() {
        cabAssignStrategy = null;
    }

    public CabBookingService useStrategy(ICabAssignStrategy cabAssignStrategy) {
        this.cabAssignStrategy = cabAssignStrategy;
        return this;
    }

    public void assignCab(CabBookingRequest cabBookingRequest) {
        Cab foundCab = this.cabAssignStrategy.assignCab(cabBookingRequest);
        if (foundCab != null) {
            foundCab.setStatus(CabStatus.BUSY);
            cabBookingRequest.setStatus(CabBookingStatus.AVAILABLE);
            cabBookingRequest.setAssignedTo(foundCab.getLicense_plate());
            cabBookingRequest.getRiderInfo().setStatus(RiderStatus.IN_RIDE);
            cabBookingRequest.getRiderInfo().addBookingRequest(cabBookingRequest);
            foundCab.getDriver().addBookingRequest(cabBookingRequest);
        } else {
            System.out.println("No ride found [Since all the driver are more than 5 units away from user]");
        }
    }
}
