package com.sohan.cabbooking.command;

import java.util.ArrayList;
import java.util.HashMap;
import com.sohan.cabbooking.entities.Cab;
import com.sohan.cabbooking.enums.CabStatus;

public class CabManager {
    private HashMap<String, Cab> cabHashMap;
    private static CabManager instance = null;

    private CabManager() {
        cabHashMap = new HashMap<>();
    }

    public static CabManager getInstance() {
        if (instance == null) {
            instance = new CabManager();
        }
        return instance;
    }

    public Cab findCab(String license_plate) {
        if (cabHashMap.containsKey(license_plate)) {
            return cabHashMap.get(license_plate);
        }
        return null;
    }

    public void addCab(Cab cab) {
        if (!cabHashMap.containsKey(cab.getLicense_plate())) {
            cabHashMap.put(cab.getLicense_plate(), cab);
        }
    }

    public void removeCab(Cab cab) {
        if (cabHashMap.containsKey(cab.getLicense_plate())) {
            cabHashMap.remove(cab.getLicense_plate());
        }
    }

    public ArrayList<Cab> findBOOKEDCabs() {
        ArrayList<Cab> cabs = new ArrayList<>();
        for (String lp : cabHashMap.keySet()) {
            Cab cab1 = cabHashMap.get(lp);
            if (cab1.getStatus() == CabStatus.AVAILABLE) {
                cabs.add(cab1);
            }
        }
        return cabs;
    }
}