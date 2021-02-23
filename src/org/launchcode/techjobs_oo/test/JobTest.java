package org.launchcode.techjobs_oo.test;
import org.junit.*;
import static org.junit.Assert.*;  //assertEquals;
import org.launchcode.techjobs_oo.*;
import java.util.ArrayList;


import javax.swing.text.Position;

public class JobTest {

    public Job henchman;
    public Job teacher;
    public Job acmeTester;
    public Job graveDigger;
    public Job graveDigger2;
    public Job graveDigger3;

    @Before
  public void Job() {
        henchman = new Job();
        teacher = new Job();
        graveDigger = new Job("Junior Web Developer", new Employer("Cozy"),
                new Location ("Portland"), new PositionType("Web - Back End"),
                new CoreCompetency("Ruby"));
        graveDigger2 = new Job("Junior Web Developer", new Employer("Cozy"),
                new Location ("Portland"), new PositionType("Web - Back End"),
                new CoreCompetency("Ruby"));
        graveDigger3 = new Job("", new Employer(""),
                new Location (""), new PositionType(""),
                new CoreCompetency(""));
   }

   @Test
    public void testSettingJobId() {
        assertEquals(henchman.getId() + 1, teacher.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
       acmeTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(true, acmeTester instanceof Job);
        assertEquals(true, acmeTester.getLocation() instanceof Location);
        assertEquals(true, acmeTester.getPositionType() instanceof PositionType);
        assertEquals(true, acmeTester.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", acmeTester.getName());
        assertEquals("Desert", acmeTester.getLocation().toString());
        assertEquals("Quality control", acmeTester.getPositionType().toString());
        assertEquals("Persistence", acmeTester.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        assertEquals(false, graveDigger.equals(graveDigger2));
    }

    @Test
    public void checksForNewLineChar() {
        assertEquals (true, graveDigger.toString().startsWith("\n"));
        assertEquals (true, graveDigger.toString().endsWith("\n"));
    }

    @Test
    public void checksDataFormat() {
        assertEquals(graveDigger.toString(), "\nID: " + graveDigger.getId() +
                                                    "\nName: " + graveDigger.getName() +
                                                    "\nEmployer: " + graveDigger.getEmployer() +
                                                    "\nLocation: " + graveDigger.getLocation() +
                                                    "\nPosition Type: " + graveDigger.getPositionType() +
                                                    "\nCore Competency: " + graveDigger.getCoreCompetency() +
                                                    "\n");
    }

    @Test
    public void checksForDataNotAvailable() {

        assertEquals (true, graveDigger3.toString().contains("Data not available"));

    }

}


