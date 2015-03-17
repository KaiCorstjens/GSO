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
    
/**
 * Constructor of the Contact-class
 * @param Name  Name of the new contact
 */
    public Contact(String Name) {
        this.name = Name;
        appointments = new ArrayList();
    }
    
/**
 * get-method to return the name of the contact
 * @return String with the name of the contact
 */
    public String getName() {
        return name;
    }
    
/**
 * Method to add an appointment.
 * @param a Appointment to be added
 * @return True if appointment was added correctly, false if otherwise
 */
    public boolean addAppointment(Appointment a) {
        if (appointments.add(a)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Method to remove an appointment
     * @param a Appointment to be removed
     * @return True if appointment was removed correctly, false if otherwise
     */
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

    /**
     * Get-method to get all appointments from this contact
     * @return Return an ArrayList with all the appointments
     */
    public ArrayList<Appointment> appointments() {
        return appointments;
    }

}
