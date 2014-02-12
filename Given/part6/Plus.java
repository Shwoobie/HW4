public class Plus {

	public static Seq plus (Constant a, Constant b){
		Constant small, big;
		//int aVal, bVal;
		if(a.num < b.num){
			small = new Constant(a.num, a.value);
			big = new Constant(b.num, b.value);
		}
		else{
			small = new Constant(b.num, b.value);
			big = new Constant(a.num, a.value);
		}
		//ContstantIt ait = small.createSeqIt();
		//ContstantIt bit = big.createSeqIt();
		small.value = small.value + big.value;
		//System.err.println(small.value);
		return small;
	}
	public static Seq plus (Delta a , Delta b ){
		Delta small, big;
		//int aVal, bVal;
		if(a.num < b.num){
			small = new Delta(a.num, a.value);
			big = new Delta(b.num, b.value);
		}
		else{
			small = new Delta(b.num, b.value);
			big = new Delta(a.num, a.value);
		}
		//ContstantIt ait = small.createSeqIt();
		//ContstantIt bit = big.createSeqIt();
		small.initial = small.initial + big.initial;
		small.delta = small.delta + big.delta;
		return small;

	}
	public static Seq plus (Jumble a, Jumble b){
		Jumble small, big;
		//int aVal, bVal;
		int i = 0;
		if(a.num < b.num){
			small = new Jumble(a.num, a.value);
			big = new Jumble(b.num, b.value);
		}
		else{
			small = new Jumble(b.num, b.value);
			big = new Jumble(a.num, a.value);
		}
		JumbleIt ait = small.createSeqIt();
		JumbleIt bit = big.createSeqIt();
		while (ait.hasNext()){
			try{
				//aVal = ait.next() + bit.next();
				small.values[i++]= ait.next() + bit.next();

			}catch(UsingIteratorPastEndException e){}
		}
		return small;

	}
}