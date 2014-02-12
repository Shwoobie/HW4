public class JumbleIt implements SeqIt{
	public JumbleIt(Jumble s){
		i = 0;
		itt = s.values;
	}

	public boolean hasNext(){
		return i != itt.length;
	}

	public int next(){
		if(hasNext()){
			return itt[i++];
		}
		else{
			System.err.println("JumbleIt called past end");
			System.exit(1);
		}

		return 0;
	}

	private int i;
	private int [] itt;
}