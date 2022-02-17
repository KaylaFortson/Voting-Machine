/**
* Candidate --- responsible for constructing a candidate consisting of a name, a party affiliation, and the number of votes for this candidate.
* @author Kayla Fortson
*/

public class Candidate implements Comparable <Candidate>{

	/** name of candidate */
	protected String name;
	/** party affiliaction of candidate */
	protected String partyAffiliation; 
	/**number of votes for candidate*/
	protected int votes;

	/**
	* This is the constructor for the Candidate class. The number of votes is automatically set to zero.
	* @param name The name of the Candidate
	*@param affiliation The party affiliation of the candidate
	*/
	public Candidate(String name, String affiliation){
		this.name = name;
		this.partyAffiliation = affiliation;
		this.votes = 0;
	}

	/**
	* @return String This returns the name of the candidate.
	*/
	public String getName(){
    return name;
	}

	/**
	* @return String This returns the name of the party this candidate is affiliated with.
	*/
	public String getAffiliation(){
    return partyAffiliation;

	}

	/**
	* @return This returns the currect vote count for this candidate.
	*/
	public int getVoteCount(){
    return votes;
	}

	/**
	* This method adds one additional vote to the candidate.
	*/
	public void tallyVote(){
		votes = votes + 1;
	}

	/**
	*@return This returns a string representation of the candidate's name and party affiliation.
	*/
	@Override
	public String toString(){
    return name + " - " + partyAffiliation;
	}

	/**
	* This method compares two Candidates using the amount of votes they have.
	*@param otherCandidate This is the  other candidate that the current candidate is being compared to.
	*@return This returns 0 if the amount of votes are equal, 1 if the first candidate's votes are greater than the other candidate's, or -1 if the first candidate's votes are less than the other candidate's.
	*/
	@Override
	public int compareTo(Candidate otherCandidate){

		if (votes == otherCandidate.getVoteCount()){
			return 0;
		} else if (votes > otherCandidate.getVoteCount()){
			return 1;
		} else {
			return -1;
		}
	}
}
