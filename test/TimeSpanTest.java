/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fontys.time.ITime;
import fontys.time.ITimeSpan;
import fontys.time.Time;
import fontys.time.TimeSpan;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kai
 */
public class TimeSpanTest {
    
    public TimeSpanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // Unit test to check if a normal (/good) TimeSpan can be added.
    @Test
    public void testAddTimeSpanNormal()
    {
        ITime bt = new Time(2014,3,9,14,0);
        ITime et = new Time(2015,3,9,15,0);
        TimeSpan t = new TimeSpan(bt,et);
        assertEquals(bt,t.getBeginTime());
        assertEquals(et,t.getEndTime());
    }
    // Unit test to check if an IllegalArgumentException is thrown if the end 
    //time is before the begin time when creating a new TimeSpan.
    @Test
    (expected = IllegalArgumentException.class)
    public void testAddTimeSpanEndBeforeBegin()
    {
        ITime bt = new Time(2015,3,9,14,1);
        ITime et = new Time(2015,3,9,14,0);
        TimeSpan t = new TimeSpan(bt,et);
        fail("No exception occured");
    }
    // Unit test to check if an begin time is added correctly
    @Test
    public void testTimeSpanBeginTime()
    {
        ITime bt = new Time(2015,3,10,11,1);
        ITime et = new Time(2015,3,10,11,2);
        TimeSpan t = new TimeSpan(bt,et);
        assertEquals(t.getBeginTime(),bt);
    }
    // Unit test to check if an end time is added correctly
@Test
    public void testTimeSpanEndTime()
    {
        ITime bt = new Time(2015,3,10,11,1);
        ITime et = new Time(2015,3,10,11,2);
        TimeSpan t = new TimeSpan(bt,et);
        assertEquals(t.getEndTime(),et);
    }
    // Unit test to check if correct length is returned, the difference between end and beginning is 1 minute
    @Test
    public void testTimeSpanLengthMinute()
    {
        ITime bt = new Time(2015,3,10,11,1);
        ITime et = new Time(2015,3,10,11,2);
        TimeSpan t = new TimeSpan(bt,et);
        assertEquals(t.length(),1);
    }
    // Unit test to check if correct length is returned, the difference between end and beginning is 1 minute
    @Test
    public void testTimeSpanLengthDay()
    {
        ITime bt = new Time(2015,3,10,11,1);
        ITime et = new Time(2015,3,11,11,1);
        TimeSpan t = new TimeSpan(bt,et);
        assertEquals(t.length(),60*24);
    }
    // Unit test to add a BeginTime.
    @Test
    public void testTimeSpanSetBeginCorrect()
    {
        ITime bt  = new Time(2014,3,10,11,1);
        ITime et  = new Time(2015,3,11,11,1);
        ITime bt2 = new Time(2013,3,9,11,1);
        TimeSpan t = new TimeSpan(bt,et);
        t.setBeginTime(bt2);
        assertEquals(t.getBeginTime(),bt2);
    }
    // Unit test to add an incorrect BeginTime (BeginTime is after EndTime)
    @Test
    (expected = IllegalArgumentException.class)
    public void testTimeSpanSetBeginInCorrect()
    {
        ITime bt  = new Time(2015,3,10,11,1);
        ITime et  = new Time(2015,3,11,11,1);
        ITime bt2 = new Time(2015,3,12,11,1);
        TimeSpan t = new TimeSpan(bt,et);
        t.setBeginTime(bt2);
        fail("No exception occured");
    }
    // Unit test to add a (correct) EndTime
    @Test
    public void testTimeSpanSetEndCorrect()
    {
        ITime bt  = new Time(2014,3,10,11,1);
        ITime et  = new Time(2015,3,11,11,1);
        ITime et2 = new Time(2016,3,9,11,3);
        TimeSpan t = new TimeSpan(bt,et);
        t.setEndTime(et2);
        assertEquals(0,t.getEndTime().compareTo(et));
    }
    // Unit test to add an incorrect BeginTime (BeginTime is after EndTime)
    @Test
    (expected = IllegalArgumentException.class)
    public void testTimeSpanSetEndInCorrect()
    {
        ITime bt  = new Time(2015,3,10,11,1);
        ITime et  = new Time(2015,3,11,11,1);
        ITime et2 = new Time(2014,3,9,11,1);
        TimeSpan t = new TimeSpan(bt,et);
        t.setEndTime(et2);
        fail("No exception occured");
    }
    // Unit Test to check the move function
    @Test
    public void testTimeSpanMove()
    {
        ITime bt  = new Time(2015,3,11,11,1);
        ITime et  = new Time(2015,3,11,11,2);
        TimeSpan t = new TimeSpan(bt,et);
        
        t.move(10);
        
        ITime bt2 = new Time(2015,3,11,11,11);
        ITime et2 = new Time(2015,3,11,11,12);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        
        assertEquals(0,t2.getBeginTime().compareTo(t.getBeginTime()));
        assertEquals(0,t2.getEndTime().compareTo(t.getEndTime()));
        //assertEquals(t,t2);
    }
    
    //Unit test to test the changeLength function #1
    @Test
    (expected = IllegalArgumentException.class)
    public void testTimeSpanChangeLengthIncorrect()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45);
        TimeSpan t = new TimeSpan(bt,et);
        t.changeLengthWith(-10);
        fail("No exception occured");
    }
    //Unit test to test the changeLength function. #2
    @Test
    public void testTimeSpanChangeLengthCorrect()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45);
        TimeSpan t = new TimeSpan(bt,et);
        t.changeLengthWith(10);
        assertEquals(t.length(),70);
    }
    
    //Unit test to test the isPartOf function.
    @Test
    public void testTimeSpanIsPartOf()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45);
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,18,15);
        ITime et2 = new Time(2015,3,15,18,30);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        assertEquals(true,t2.isPartOf(t));
    }
    
    // Unit test to test the unionWith function, where one timespan is complete before the other.
    @Test
    public void testTimeSpanUnionWithCorrectBefore()
    {
         ITime bt = new Time(2015,3,15,17,45);//
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,18,50); 
        ITime et2 = new Time(2015,3,15,19,30);//
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        assertEquals(null,t3);
    }
    
    //Unit test to test the unionWith function, where the timespans overlap (and one starts before the other).
    @Test
    public void testTimeSpanUnionWithCorrectBeforeDuring()
    {
        ITime bt = new Time(2015,3,15,17,45);//
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,17,15); 
        ITime et2 = new Time(2015,3,15,18,30);//
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        TimeSpan t4 = new TimeSpan(bt2,et);
        assertEquals(0,t4.getBeginTime().compareTo(t3.getBeginTime()));
        assertEquals(0,t4.getEndTime().compareTo(t3.getEndTime()));
    }
    
    // Unit test to test the UnionWith function, where the timespans overlap (one is "in" the other)
    @Test
    public void testTimeSpanUnionWithCorrectDuring()
    {
        ITime bt = new Time(2015,3,15,17,45);//
        ITime et = new Time(2015,3,15,19,30); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,18,15); 
        ITime et2 = new Time(2015,3,15,19,15);//
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        assertEquals(0,t3.getBeginTime().compareTo(t.getBeginTime()));
        assertEquals(0,t3.getEndTime().compareTo(t.getEndTime()));
    }
    
    // Unit test to test the UnionWith function, where the timespans overlap (one ends after the other)
    @Test
    public void testTimeSpanUnionwithCorrectAfterDuring()
    {
        ITime bt = new Time(2015,3,15,17,45);//
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,18,15); 
        ITime et2 = new Time(2015,3,15,19,30);//
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        TimeSpan t4 = new TimeSpan(bt,et2);
        assertEquals(0,t4.getBeginTime().compareTo(t3.getBeginTime()));
        assertEquals(0,t4.getEndTime().compareTo(t3.getEndTime()));
    }
    
    /// Unit test to test the UnionWith function, where one timespan is completely after the other.
    @Test
    public void testTimeSpanUnionwithCorrectAfter()
    {
         ITime bt = new Time(2015,3,15,17,45);//
        ITime et = new Time(2015,3,15,19,30); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,19,45); 
        ITime et2 = new Time(2015,3,15,20,00);//
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        assertEquals(null,t3);
    }
    
    //Unit test to test the unionWith function, with incorrect timespans
    @Test
    public void testTimeSpanUnionWithInCorrect()
    {
         ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); //
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,13,15); //
        ITime et2 = new Time(2015,3,15,17,30);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        assertEquals(null,t3);
    }
    
    // Unit test to test the UnionWith function, where one timespan is before the other, but it shares its endTime with the other's beginTime
    @Test
    public void testTimeSpanUnionWithSameEndBefore()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,17,15); 
        TimeSpan t2 = new TimeSpan(bt2,bt);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        TimeSpan t4 = new TimeSpan(bt2,et);
        assertEquals(0,t4.getBeginTime().compareTo(t3.getBeginTime()));
        assertEquals(0,t4.getEndTime().compareTo(t3.getEndTime()));
    }
    
    // Unit test to test the UnionWith function, where one timespan is after the other, but it shares its begintime with the other's endtime
    @Test
    public void testTimeSpanUnionWithSameEndAfter()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime et2 = new Time(2015,3,15,19,15); 
        TimeSpan t2 = new TimeSpan(et,et2);
        TimeSpan t3 = (TimeSpan) t.unionWith(t2);
        TimeSpan t4 = new TimeSpan(bt,et2);
        assertEquals(0,t4.getBeginTime().compareTo(t3.getBeginTime()));
        assertEquals(0,t4.getEndTime().compareTo(t3.getEndTime()));
    }
    
    //Unit test to test the intersectionWith function
  /*  @Test
    public void testTimeSpanIntersectionWithCorrect()
    {
        ITime bt = new Time(2015,3,15,17,15);//
        ITime et = new Time(2015,3,15,19,30);
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,11,30);
        ITime et2 = new Time(2015,3,15,15,45);//
        TimeSpan t2 = new TimeSpan(bt2,et2);
        
        ITimeSpan t3 = t.intersectionWith(t2);
       // TimeSpan t3 =  new TimeSpan(bt2,et);
        TimeSpan t4 = new TimeSpan(bt2,et);
        
        assertEquals(t4.getBeginTime(),t3.getBeginTime());
        assertEquals(t4.getEndTime(),t3.getEndTime());
    }
    
    
        Can't test incorrent use of Intersectionwith
        For null to return, the endtime must be earlier than the beginTime
        Because the earliest beginTime is chosen, 
        and the latest endtime, creating timeSpans where null would be returned,
        would cause an error because the endtime in the original timespan is already
        before the beginTime of the timeSpan.
    */
    
     // Unit test to test the unionWith function, where one timespan is complete before the other.
    @Test
    public void testTimeSpanIntersectionWithCorrectBefore()
    {
         ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,18,50); 
        ITime et2 = new Time(2015,3,15,19,30);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        assertEquals(null,t3);
    }
    
    //Unit test to test the unionWith function, where the timespans overlap (and one starts before the other).
    @Test
    public void testTimeSpanIntersectionWithCorrectBeforeDuring()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,17,15); 
        ITime et2 = new Time(2015,3,15,18,30);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        TimeSpan t4 = new TimeSpan(bt,et2);
        assertEquals(0,t4.getBeginTime().compareTo(t3.getBeginTime()));
        assertEquals(0,t4.getEndTime().compareTo(t3.getEndTime()));
    }
    
    // Unit test to test the UnionWith function, where the timespans overlap (one is "in" the other)
    @Test
    public void testTimeSpanIntersectionWithCorrectDuring()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,19,30); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,18,15); 
        ITime et2 = new Time(2015,3,15,19,15);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        assertEquals(0,t3.getBeginTime().compareTo(t2.getBeginTime()));
        assertEquals(0,t3.getEndTime().compareTo(t2.getEndTime()));
    }
    
    // Unit test to test the UnionWith function, where the timespans overlap (one ends after the other)
    @Test
    public void testTimeSpanIntersectionWithCorrectAfterDuring()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,18,15); 
        ITime et2 = new Time(2015,3,15,19,30);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        TimeSpan t4 = new TimeSpan(bt2,et);
        assertEquals(0,t4.getBeginTime().compareTo(t3.getBeginTime()));
        assertEquals(0,t4.getEndTime().compareTo(t3.getEndTime()));
    }
    
    /// Unit test to test the UnionWith function, where one timespan is completely after the other.
    @Test
    public void testTimeSpanIntersectionWithCorrectAfter()
    {
         ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,19,30); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,19,45); 
        ITime et2 = new Time(2015,3,15,20,00);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        assertEquals(null,t3);
    }
    
    //Unit test to test the unionWith function, with incorrect timespans
    @Test
    public void testTimeSpanIntersectionWithInCorrect()
    {
         ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,13,15); 
        ITime et2 = new Time(2015,3,15,17,30);
        TimeSpan t2 = new TimeSpan(bt2,et2);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        assertEquals(null,t3);
    }
    
    // Unit test to test the UnionWith function, where one timespan is before the other, but it shares its endTime with the other's beginTime
    @Test
    public void testTimeSpanIntersectionWithSameEndBefore()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime bt2 = new Time(2015,3,15,17,15); 
        TimeSpan t2 = new TimeSpan(bt2,bt);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        TimeSpan t4 = new TimeSpan(bt,et);
        assertEquals(null,t3);
    }
    
    // Unit test to test the UnionWith function, where one timespan is after the other, but it shares its begintime with the other's endtime
    @Test
    public void testTimeSpanIntersectionWithSameEndAfter()
    {
        ITime bt = new Time(2015,3,15,17,45);
        ITime et = new Time(2015,3,15,18,45); 
        TimeSpan t = new TimeSpan(bt,et);
        
        ITime et2 = new Time(2015,3,15,19,15); 
        TimeSpan t2 = new TimeSpan(et,et2);
        TimeSpan t3 = (TimeSpan) t.intersectionWith(t2);
        TimeSpan t4 = new TimeSpan(et,et2);
        assertEquals(null,t3);
    }
}
