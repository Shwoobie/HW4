public class DeltaIt implements SeqIt{
	public DeltaIt(Delta s){
		itt = 0;
		max = s.num;
		nxt = s.intial;
		delta = s.delta;
	}

	public boolean hasNext(){
		return itt != max;
	}

	public int next(){
		if(itt == 0)
		{
			itt++;
			return initial;
		}
		else if(hasNext()){
			nxt += delta;
			return nxt;
		}
		else{
			System.err.println("DeltaIt called past end");
			System.exit(1);
		}

	}

	private int delta;
	private int itt;
	private int max;
	private int nxt;
}