/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;

/**
 *
 * @author Niek
 */
public class Contact {

    private String name;

    public Contact(String Name) {
        this.name = Name;
    }

    public String getName() {
        return name;
    }

    public boolean addAppointment(Appointment a) {
        return false;
    }

    public boolean removeAppointment(Appointment a) {
        return false;
    }

    public Iterator<Appointment> appointments() {
        return null;
    }

}
