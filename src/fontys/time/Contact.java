/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Niek
 */
public class Contact {

    private String name;
    private ArrayList<Appointment> appointments;

    public Contact(String Name) {
        this.name = Name;
        appointments = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public boolean addAppointment(Appointment a) {
        if (appointments.add(a)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean removeAppointment(Appointment a) {
        if (appointments != null) {
            for (Appointment ap : appointments) {
                if (ap.equals(a)) {
                    appointments.remove(a);
                    return true;
                } else {
                    System.out.println("Appartement bestaat niet");
                    return false;
                }
            }
        } else {
            System.out.println("Lijst is leeg");
            return false;
        }
        return false;
    }

    public ArrayList<Appointment> appointments() {
        return appointments;
    }

}
