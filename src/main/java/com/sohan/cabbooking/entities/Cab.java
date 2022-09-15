package com.sohan.cabbooking.entities;

import com.sohan.cabbooking.command.CabBookingConstants;

public class Cab extends BaseCab {
    Double baseFare;
    Double perKMFare;

    public Cab(Driver driver, char gender, int age, String car, String license_plate, Location location) {
        super(driver, gender, age, car, license_plate, location);
        this.baseFare = CabBookingConstants.CAB_BASE_FARE;
        this.perKMFare = CabBookingConstants.CAB_PER_KM_CHARGE;
    }

    public Double getBaseFare() {
        return baseFare;
    }

    public Double getPerKMFare() {
        return perKMFare;
    }

    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    public void setPerKMFare(Double perKMFare) {
        this.perKMFare = perKMFare;
    }
}
