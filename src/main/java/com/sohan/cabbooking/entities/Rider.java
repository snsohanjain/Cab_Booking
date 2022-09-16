package com.sohan.cabbooking.entities;

import java.util.HashMap;
import java.util.UUID;
import com.sohan.cabbooking.enums.RiderStatus;
import com.sohan.cabbooking.repositories.RiderAccount;

public class Rider {
    RiderAccount riderAccount;
    RiderStatus status;
    Location location;

    HashMap<UUID, CabBookingRequest> bookingRequests;

    public Rider(RiderAccount riderAccount, Location location) {
        this.bookingRequests = new HashMap<>();
        this.status = RiderStatus.FREE;
        this.location = location;
        this.riderAccount = riderAccount;

    }

    public HashMap<UUID, CabBookingRequest> getBookingRequests() {
        return bookingRequests;
    }

    public Location getLocation() {
        return location;
    }

    public RiderAccount getRiderAccount() {
        return riderAccount;
    }

    public RiderStatus getStatus() {
        return status;
    }

    public void setStatus(RiderStatus status) {
        this.status = status;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addBookingRequest(CabBookingRequest cabBookingRequest) {
        if (!bookingRequests.containsKey(cabBookingRequest.getId())) {
            bookingRequests.put(cabBookingRequest.getId(), cabBookingRequest);
        }
    }

    public void updateBookingRequest(CabBookingRequest cabBookingRequest) {
        if (bookingRequests.containsKey(cabBookingRequest.getId())) {
            bookingRequests.put(cabBookingRequest.getId(), cabBookingRequest);
        }
    }

    public CabBookingRequest findBookingRequest(UUID id) {
        if (bookingRequests.containsKey(id)) {
            return bookingRequests.get(id);
        }
        System.out.println("Cab booking request not found with id" + id.toString());
        return null;
    }

}