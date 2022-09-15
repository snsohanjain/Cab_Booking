package com.sohan.cabbooking.services;

import com.sohan.cabbooking.entities.Cab;
import com.sohan.cabbooking.entities.CabBookingRequest;

public interface ICabAssignStrategy {
    Cab assignCab(CabBookingRequest cabBookingRequest);
}
