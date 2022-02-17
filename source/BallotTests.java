/**
*BallotTests - JUnit Testbench class for ballot
*@author Kayla Fortson
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.Arrays;

public class BallotTests {
  private Ballot testBallot;
  private Candidate testCandidate1;
  private Candidate testCandidate2;

  @BeforeEach
  public void setUp() {
    testBallot = new Ballot("James Beard Award");
    testCandidate1 = new Candidate ("Nina Compton", "Compere Lapin");
    testCandidate2 = new Candidate("Alon Shaya", "Saba");
  }


//check getOfficeName()
@Test
public void testGetOfficeName(){
  assertEquals("James Beard Award", testBallot.getOfficeName());
}

//check getLength()
@Test
public void testGetLength(){
  testBallot.addCandidate(testCandidate1);
  assertEquals(1, testBallot.getLength());
}

//test getCandidates()
@Test
public void testGetCandidates(){
  assertEquals(testBallot.getCandidates().isEmpty(), testBallot.getCandidates().isEmpty());
}

//test getCandidate()
@Test
public void testGetCandidate(){
  testBallot.addCandidate(testCandidate1);
  testBallot.addCandidate(testCandidate2);
  assertEquals(testCandidate2, testBallot.getCandidate(1));
}

//test toString()
@Test
public void testToString(){
  assertEquals( "Ballot Candidates of James Beard Award: ", testBallot.toString());
}


//test addCandidate
@Test
public void testAddCandidate(){
  testBallot.addCandidate(testCandidate1);
  ArrayList<Candidate> testArrayList = new ArrayList<>(Arrays.asList(testCandidate1));
  assertEquals(testArrayList, testBallot.getCandidates());
}

}
