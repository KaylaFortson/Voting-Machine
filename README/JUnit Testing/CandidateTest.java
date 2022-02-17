/**
*CandidateTest - testbench class for candidate
*@author Kayla Fortson
*/


//convert to JUnit Test File

public class CandidateTest {
  public static void main(String[]args){
    Candidate testCandidate = new Candidate("Nina Compton", "Compere Lapin");

    System.out.println("Beginning tests.");

    //check getName()
    if(testCandidate.getName() != "Nina Compton"){
      System.out.println("   FAILED getName()");
    }

    //check getAffiliation
    if(testCandidate.getAffiliation()!= "Compere Lapin"){
      System.out.println("   FAILED getAffiliation()");
    }

    //check getVoteCount
    if(testCandidate.getVoteCount() != 0){
      System.out.println("   FAILED getVoteCount()");
    }

    //check tallyVote
    testCandidate.tallyVote();
    if(testCandidate.getVoteCount() != 1){
      System.out.println("   FAILED tallyVote()");
    }

    //check toString
    if(testCandidate.toString() != "Nina Compton - Compere Lapin"){
      System.out.println("   FAILED toString()");
    }

    //check compareTo (Three cases)
    Candidate testCandidate2 = new Candidate ("Alon Shaya", "Saba");
    if (testCandidate.compareTo(testCandidate2) != 1){
      System.out.println ("   FAILED compareTo Trial 1");
    }

    if (testCandidate2.compareTo(testCandidate)!= -1){
      System.out.println("   FAILED compareTo Trial 2");
    }

    testCandidate2.tallyVote();
    if (testCandidate.compareTo(testCandidate2)!= 0){
      System.out.println("   FAILED compareTo Trial 3");
    }




    System.out.println("Tests complete.");
  }




}
