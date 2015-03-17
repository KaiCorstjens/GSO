package fontys.time;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niek
 */
public class Appointment {
    
    String subject;
    TimeSpan appointmentTimeSpan;
    ArrayList<Contact> guests;
    
    /**
     * Constructor for Appointment
     * @param subject the subject of the appointment
     * @param appointmentTimeSpan the timeSpan of the appointment
     * @param guests List of guests that will attend the appointment.
     */
    public Appointment(String subject, TimeSpan appointmentTimeSpan,ArrayList<Contact> guests)
    {
        this.subject = subject;
        this.appointmentTimeSpan = appointmentTimeSpan;
        // There could be zero guests. This could possibly mean that the list is null. To avoid bugs, create a new arraylist.
        this.guests = new ArrayList();
        for (Contact c : guests)
        {
            this.guests.add(c);
        }
    }
    
    /**
     * Getter to return the subject of the appointment
     * @return Subject of the appointment
     */
    public String getSubject()
    {
        return subject;
    }
    
    /**
     * Getter to return the list of guests
     * @return ArrayList<Contact> with all guests
     */
    public ArrayList<Contact> getGuests()
    {
        return guests;
    }
    /*
    Er moet een manier zijn om bij een Appointment-object een Contact-object toe te voegen en te verwijderen. 
    Het toevoegen van een genodigde mag alleen doorgang vinden indien deze afspraak niet tot een conflict in 
    de agenda van het toe te voegen contact leidt. Neem alleen de methoden en constructoren uit bovenstaand 
    klassendiagram in je klasse op! 
    */
    
    /**
     * Getter for the timeSpan of the appointment
     * @return TimeSpan of the appointment
     */
    public TimeSpan getTimeSpan()
    {
        return appointmentTimeSpan;
    }
    
    /**
     * Method to add a contact. The contact will only be added if there isn't an
     * conflicting appointment in the guest's agenda.
     * @param c
     * @return Boolean, true if the adding of the contact was successful. False if otherwise.
     */
    public boolean addContact(Contact c)
    {
        boolean conflict = false;
        for (Appointment a : c.appointments())
        {
            if (a.getTimeSpan() != null)
            {
                conflict = true;
            }
        }
        if (!conflict)
        {
            guests.add(c);
        }
        return !conflict;
    }
    
    /**
     * Method to remove a contact from the guest-list
     * @param c Contact that needs to be removed.
     */
    public void removeContact(Contact c)
    {
                guests.remove(c);
    }
}
