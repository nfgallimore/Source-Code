public class Array
{
	public static void main(String[] args)
	{
		Candidate election[] = new Candidate[8];
		

		for (int i = 0; i < election.length; i++)
		{
			//election[i].votes = i;
			election[i].setVotes(i);
			
			//election[i].name = "Nick" + i;
		} 
	}
}

class Candidate
{
	private int votes;
	private String name;

	public int getVotes(){
		return votes;
	}

	public void setVotes(int votes){
		this.votes = votes;
	}
}