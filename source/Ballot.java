
import java.util.ArrayList;
/**
* Ballot - Creates objects representing a single ballot in the form of an ArrayList of Candidates and allows modification of candidates on the ballot.
* @author Kayla Fortson
*/
public class Ballot{

	/**name of the office that is up for a vote*/
	protected String officeName;
	/** An ArrayList of type Candidates to later be added to the ballot*/
	protected ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	/**the length of the ArrayList of candidates (the number of candidates)*/
	protected int length;

	/**
	* Contructs a single Ballot composed of an ArrayList of type Candidate.
	*@param officeName assigns the name of the office that is up for a vote
	*/
	public Ballot(String officeName){
		candidates = new ArrayList<Candidate>();
		this.officeName = officeName;
		this.length = 0;
	}

	/**
	*@return the office name that is up for vote
	*/
	public String getOfficeName(){
    return officeName;
	}

	/**
	*@return the current length of the ballot in reference to the number of Candidates
	*/
	public int getLength(){
		return length;
	}

	/**
	* Adds the given candidate to the arraylist of candidates for this particular ballot. Prints out the candidate is already on the ballot if the candidate already exists in list.
	*@param c the candidate to be added to the arraylist of Candidates
	*/
	public void addCandidate(Candidate c){
		if (candidates.contains(c)){
			System.out.println("This candidate has already been added to this ballot.");
		}else {
			candidates.add(c);
			length = length + 1;
		}
	}

	/**
	* @return the arraylist of candidates on this particular Ballot
	*/
	public ArrayList<Candidate> getCandidates(){
    return candidates;
	}

	/**
	*@param index the index of the candidate that is trying to be reached
	*@return a specific candidate within the arrayList on this particular Ballot
	*/
	public Candidate getCandidate(int index){
		return candidates.get(index);
	}

	/**
	*@return a well-formatted snapshot of the ballot including the officeName and candidates
	*/
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < candidates.size(); i++) {
			sb.append(candidates.get(i));
			sb.append(", ");
		}
		String finalString = sb.toString();
		return "Ballot Candidates of " + this.getOfficeName() + ": " + finalString;
	}
}
