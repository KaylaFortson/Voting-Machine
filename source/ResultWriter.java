

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;

/**
* This method is responsible for writing the results to an output file
*@param String filename the name of the output file
*@param Ballot ballot the ballot used to write the results
*/
public class ResultWriter{
	public static void writeResults(String filename, Ballot ballot)
	throws IOException {
		//Set up Header
		BufferedWriter outputFile = new BufferedWriter(new FileWriter(filename));
		outputFile.write("RESULTS - " + ballot.getOfficeName());
		outputFile.newLine();
		int lineLength = 10 + ballot.getOfficeName().length();
		for(int i = 0; i < lineLength; i++){
			outputFile.append("-");
		}

		//Begin Printing RESULTS
		//Calculates column spacing
		int longestNameLength = ballot.getCandidate(0).toString().length();
		for(int i = 0; i < ballot.getLength();i++){
			if(ballot.getCandidate(i).toString().length() > longestNameLength){
				longestNameLength = ballot.getCandidate(i).toString().length();
			}
		}
		int totalNumberOfSpaces = longestNameLength + 12; //row length
		Candidate winner = ballot.getCandidate(0);
		boolean tie = false;

		//Adds Names with Number of votes and determines winner
		outputFile.newLine();
		for (int i = 0; i < ballot.getLength();i++){
			int currentNameLength = ballot.getCandidate(i).toString().length(); //length of name and party affiliation

			int tempCurrentVoteCharLength = ballot.getCandidate(i).getVoteCount();
			String tempStringCurrentVoteCharLength = String.valueOf(tempCurrentVoteCharLength);
			int currentVoteCharLength = tempStringCurrentVoteCharLength.length(); //number of digits for the number of votes

			int currentNumberVotes = ballot.getCandidate(i).getVoteCount(); //number of votes
			String currentNumberVotesString = String.valueOf(currentNumberVotes); //number of votes as String

			int remainingSpaces = totalNumberOfSpaces;
			outputFile.append(ballot.getCandidate(i).toString()); //writes Name and party affiliation
			remainingSpaces = remainingSpaces - currentNameLength;
			int gapSpaces = remainingSpaces - currentVoteCharLength; //equals the number of spaces between name - party affiliation and votes
			int spaces = 0;
			while (spaces < gapSpaces){
				outputFile.append(" ");
				spaces = spaces + 1;
			}
			outputFile.append(currentNumberVotesString); //writes number of votes for this candidate FIXME

			outputFile.newLine();

			//checks if this candidate is the winner
			if (currentNumberVotes > winner.getVoteCount()){
				winner = ballot.getCandidate(i);
			}

		}

		//check if there is a tie between candidates with the highest number of votes
		int checkDuplicate = 0;
		for (int i = 0; i < ballot.getLength();i++){
			if (ballot.getCandidate(i).getVoteCount() == winner.getVoteCount()){
				checkDuplicate += 1;
			}
		}
		if (checkDuplicate > 1){
			tie = true;
		}

		//writes the final winner
		outputFile.newLine();
		if (tie){
		outputFile.append("NO WINNER");
	} else {
				outputFile.append("WINNER: " + winner.toString());
	}


		outputFile.close();
	}
}
