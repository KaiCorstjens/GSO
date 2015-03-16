/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fontys.time.Appointment;
import fontys.time.Contact;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Niek
 */
public class ContactTest {

    private Contact contact;

    public ContactTest() {
    }

    @Before
    public void setUp() {
        contact = new Contact("Henk");

    }

    @Test
    public void TestConstructorIngevuldeWaardes() {
        assertEquals("Henk", contact.getName());

    }

    @Test
    public void TestaddAppointment() {
        Appointment ap = new Appointment();
        assertEquals(true, contact.addAppointment(ap));
        assertEquals(1, contact.appointments().size());

    }

    @Test
    public void TestremoveAppointment() {
        Appointment ap = new Appointment();
        contact.addAppointment(ap);
        assertEquals(true, contact.removeAppointment(ap));
        assertEquals(0, contact.appointments().size());
        assertEquals(false, contact.removeAppointment(ap));
        contact.addAppointment(ap);
        contact.appointments().clear();
        assertEquals(false, contact.removeAppointment(ap));
    }

    @Test
    public void Testappointments() {
        assertEquals(0, contact.appointments().size());
        Appointment ap = new Appointment();
        contact.addAppointment(ap);
        assertEquals(1, contact.appointments().size());
        contact.removeAppointment(ap);
        assertEquals(0, contact.appointments().size());
    }

}
