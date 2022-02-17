/**
*CandidateTests - JUnit Testbench class for candidate
*@author Kayla Fortson
*/


//convert to JUnit Test File

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class CandidateTests {
    private Candidate testCandidate;
    private Candidate testCandidate2;

    @BeforeEach
    public void setUp(){
      testCandidate = new Candidate("Nina Compton","Compere Lapin");
      testCandidate2 = new Candidate ("Alon Shaya", "Saba");
    }

  //  System.out.println("Beginning tests.");


    //check getName()
    @Test
    public void testGetName(){
      assertEquals( "Nina Compton", testCandidate.getName());
    }

    //check getAffiliation
    @Test
    public void testGetAffiliation(){
      assertEquals("Compere Lapin", testCandidate.getAffiliation());
    }

    //check getVoteCount
    @Test
    public void testGetVoteCount(){
      assertEquals(0, testCandidate.getVoteCount());
    }

    //check tallyVote
    @Test
    public void testTallyVote(){
      testCandidate.tallyVote();
      assertEquals(1, testCandidate.getVoteCount());
    }

    //check toString
    @Test
    public void testToString(){
      assertEquals("Nina Compton - Compere Lapin", testCandidate.toString());
    }

    //check compareTo (Three cases)
    @Test
    public void testCompareTo(){
      testCandidate.tallyVote();
      assertEquals(1, testCandidate.compareTo(testCandidate2));
      assertEquals(-1, testCandidate2.compareTo(testCandidate));
      testCandidate2.tallyVote();
      assertEquals(0, testCandidate.compareTo(testCandidate2));
    }

}
