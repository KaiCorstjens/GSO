/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fontys.time.ITime;
import fontys.time.Time;
import java.util.GregorianCalendar;
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
public class TimeTest {

    private Time time;
    private Time timeCompare;

    public TimeTest() {

    }

    @Before
    public void setUp() {
        time = new Time(2015, 5, 5, 13, 0);

    }

    /**
     * creation of a time-object with year y, month m, day d, hours h and
     * minutes m; if the combination of y-m-d refers to a non-existing date the
     * value of this Time-object will be not guaranteed
     *
     * @param y
     * @param m 1≤m≤12
     * @param d 1≤d≤31
     * @param h 0≤h≤23
     * @param min 0≤m≤59
     */
    @Test
    public void TestConstructorIngevuldeWaardes() {
        assertEquals(2015, time.getYear());
        assertEquals(5, time.getMonth());
        assertEquals(5, time.getDay());
        assertEquals(13, time.getHours());
        assertEquals(0, time.getMinutes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorVerkeerdeMaand() {
        // @param m 1≤m≤12
        time = new Time(2015, 13, 05, 13, 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNegatieveMaand() {
        // @param m 1≤m≤12
        time = new Time(2015, 13, -1, 13, 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorVekeerdeDag() {
        time = new Time(2015, 04, 32, 13, 0);
        //@param d 1≤d≤31
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNegatieveDag() {
        time = new Time(2015, 04, 32, -1, 0);
        //@param d 1≤d≤31
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorVekeerdeUur() {
        time = new Time(2015, 04, 05, 24, 0);
        //@param h 0≤h≤23
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNegatieveUren() {
        time = new Time(2015, 04, 05, -1, 0);
        //@param h 0≤h≤23
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorVekeerdeMinuut() {
        time = new Time(2015, 04, 05, 23, 60);
        //@param min 0≤m≤59
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNegatieveMinuut() {
        time = new Time(2015, 04, 05, -1, 60);
        //@param min 0≤m≤59
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void Testplus() {
        time.plus(6);
        assertEquals(6, time.getMinutes());
        time.plus(0);
        assertEquals(6, time.getMinutes());
        time.plus(65);
        assertEquals(11, time.getMinutes());
        time.plus(-12);
        assertEquals(59, time.getMinutes());
    }

    @Test
    public void TestcompareTo() {
        timeCompare = new Time(2014, 04, 05, 20, 10);
        assertEquals(-1, time.compareTo(timeCompare));
        timeCompare = new Time(2016, 04, 05, 20, 10);
        assertEquals(1, time.compareTo(timeCompare));
        timeCompare = new Time(2015, 05, 05, 13, 00);
        assertEquals(0, time.compareTo(timeCompare));
    }

    @Test
    public void Testdifference() {
        timeCompare = new Time(2015, 05, 05, 12, 11);
        assertEquals(49, time.difference(timeCompare));
        timeCompare = new Time(2015, 05, 05, 13, 00);
        assertEquals(0, time.difference(timeCompare));
        timeCompare = new Time(2015, 05, 05, 14, 00);
        assertEquals(-60, time.difference(timeCompare));
        timeCompare = new Time(2015, 05, 04, 0, 00);
        assertEquals(2220, time.difference(timeCompare));
        
    }

}
