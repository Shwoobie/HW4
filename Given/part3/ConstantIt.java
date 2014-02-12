public class ConstantIt implements SeqIt{
	public ConstantIt(Constant s){
		itt = 0;
		max = s.num;
		nxt = s.value;
	}

	public boolean hasNext(){
		return itt != max;
	}

	public int next(){
		if(hasnext()){
			return itt++;
		}
		else{
			System.err.println("ConstantIt called past end");
			System.exit(1);
		}

	}

	private int itt;
	private int max;
	private int nxt;
}