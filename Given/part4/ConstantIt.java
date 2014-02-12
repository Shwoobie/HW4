public class ConstantIt implements SeqIt{
	public ConstantIt(Constant s){
		itt = 0;
		max = s.num;
		nxt = s.value;
	}

	public boolean hasNext(){
		return itt != max;
	}

	public int next() throws UsingIteratorPastEndException{

		if(hasNext()){
			itt++;
			return nxt;
		}
		else{
			throw new UsingIteratorPastEndException();
		}
		return 0;
	}

	private int itt;
	private int max;
	private int nxt;
}