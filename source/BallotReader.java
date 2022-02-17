//FIXME One line short on input of candidates
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

/**
* BallotReader- is responsible for initilizing the ballot using a provided text file. The ballot candidates are added and stored into an arraylist.
*@author Kayla Fortson
*/
public class BallotReader{
	/**
	* This method reads in a text file and uses each line to construct a ballot using candidate objects.
	*@param filename the name of the text file used for the ballot information
	*@return a ballot with an officeName containing an arraylist of candidate objects. Each candidate contains a name, party affiliation, and number of votes
	*/
	public static Ballot readBallot(String filename)
	throws IOException {
		/*
		// ***Replace this with the correct implementation; for now, it's
		//    always returning a hard-coded ballot with three candidates.
		Ballot ballot = new Ballot("James Beard Award");
		ballot.addCandidate(new Candidate("Nina Compton", "Compere Lapin Party"));
		ballot.addCandidate(new Candidate("Alon Shaya", "Saba Party"));
		ballot.addCandidate(new Candidate("Emeril Lagasse", "Emeril's Party"));
		return ballot;
		*/

		File file = new File (filename); // initialize a text file to read in ballot info
		Scanner scnr = new Scanner (file);



		int lineNumber = 1;
		String line = scnr.nextLine();
		lineNumber++;
		Ballot ballot = new Ballot(line); // creates a new ballot with the office name as the first line of the text file
		int numberOfCandidates = Integer.parseInt(scnr.nextLine()); // an int representing the total number of candidates on the ballot
		lineNumber++;

		// reads in the remaining lines of text file according to total number of candidates. Splits each line into candidate name and party affiliation then creates candidate object. Lastly, adding each candidate to the ballot's arraylist
		while (lineNumber <= numberOfCandidates + 2){
			line = scnr.nextLine();
			String candidateName;
			String candidateParty;
			String[] splitValues = line.split(";");
			candidateName = splitValues[0];
			candidateParty = splitValues[1];

			Candidate candidate = new Candidate(candidateName, candidateParty);

			ballot.addCandidate(candidate);
			lineNumber++;
		}
		return ballot;

	}
}
