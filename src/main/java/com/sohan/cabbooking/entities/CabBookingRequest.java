package com.sohan.cabbooking.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.sohan.cabbooking.enums.CabBookingStatus;

public class CabBookingRequest {
    UUID id;
    Location from;
    Location to;
    Rider riderInfo;
    LocalDateTime date;
    CabBookingStatus status;
    String assignedTo;

    public CabBookingRequest(Location from, Location to, Rider rider) {
        this.id = UUID.randomUUID();
        this.from = from;
        this.to = to;
        this.riderInfo = rider;
        this.status = CabBookingStatus.PENDING;
        this.date = LocalDateTime.now();
    }

    public CabBookingStatus getStatus() {
        return status;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public Rider getRiderInfo() {
        return riderInfo;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setStatus(CabBookingStatus status) {
        this.status = status;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public UUID getId() {
        return id;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "CabBookingRequest [assignedTo=" + assignedTo + ", status=" + status + "]";
    }

}