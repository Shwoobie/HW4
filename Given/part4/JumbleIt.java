public class JumbleIt implements SeqIt{
	public JumbleIt(Jumble s){
		i = 0;
		itt = s.values;
	}

	public boolean hasNext(){
		return i != itt.length;
	}

	public int next() throws UsingIteratorPastEndException{
		if(hasNext()){
			return itt[i++];
		}
		else{
			throw new UsingIteratorPastEndException();
		}

		//return 0;
	}

	private int i;
	private int [] itt;
}