public class DeltaIt implements SeqIt{
	public DeltaIt(Delta s){
		itt = 0;
		max = s.num;
		nxt = s.initial;
		delta = s.delta;
	}

	public boolean hasNext(){
		return itt != max;
	}

	public int next() throws UsingIteratorPastEndException{
		if(itt == 0)
		{
			itt++;
			return nxt;
		}
		else if(hasNext()){
			nxt += delta;
			itt++;
			return nxt;
		}
		else{
			throw new UsingIteratorPastEndException();
			//return 0;
		}
//		return 0;

	}

	private int delta;
	private int itt;
	private int max;
	private int nxt;
}