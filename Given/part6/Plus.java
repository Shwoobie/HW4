public class Plus {

	public static Seq plus (Constant a, Constant b){
		Constant small, big;
		//int aVal, bVal;
		if(a.num < b.num){
			small = a;
			big = b
		}
		else{
			small = b;
			big = a;
		}
		//ContstantIt ait = small.createSeqIt();
		//ContstantIt bit = big.createSeqIt();
		small.value = small.value + big.value;
		return small;
	}
	public static Seq plus (Delta a , Delta b ){
		Constant small, big;
		//int aVal, bVal;
		if(a.num < b.num){
			small = a;
			big = b
		}
		else{
			small = b;
			big = a;
		}
		//ContstantIt ait = small.createSeqIt();
		//ContstantIt bit = big.createSeqIt();
		small.initial = small.initial + big.initial;
		small.delta = small.delta + big.delta;
		return small;

	}
	public static Seq plus (Jumble a, Jumble b){
		Constant small, big;
		//int aVal, bVal;
		int i = 0;
		if(a.num < b.num){
			small = a;
			big = b
		}
		else{
			small = b;
			big = a;
		}
		ContstantIt ait = small.createSeqIt();
		ContstantIt bit = big.createSeqIt();
		while (ait.hasNext){
			try{
				//aVal = ait.next() + bit.next();
				small.value[i++]= ait.next() + bit.next();

			}catch(UsingIteratorPastEndException e)
		}
		return small;

	}
}