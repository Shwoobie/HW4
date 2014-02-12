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

	public int next(){
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
			System.err.println("DeltaIt called past end");
			System.exit(1);
		}
		return 0;

	}

	private int delta;
	private int itt;
	private int max;
	private int nxt;
}