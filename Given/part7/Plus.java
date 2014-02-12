public class Plus {

	public static Seq plus (Constant a, Constant b){
		Constant small, big,last;
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
		//System.err.println("VConstant is: "+small.value);
		last = new Constant(small.num, small.value);
		return last;
	}
	public static Seq plus (Delta a , Delta b ){
		Delta small, last, big;
		//int aVal, bVal;
		if(a.num < b.num){
			small = new Delta(a.num, a.initial, a.delta);
			big = new Delta(b.num, b.initial, b.delta);
		}
		else{
			small = new Delta(b.num, b.initial, b.delta);
			big = new Delta(a.num, a.initial, a.delta);
		}
		//ContstantIt ait = small.createSeqIt();
		//ContstantIt bit = big.createSeqIt();
		small.initial = small.initial + big.initial;
		small.delta = small.delta + big.delta;
		//System.err.println("Small Delta is: "+small.value);
		last = new Delta(small.num, small.initial, small.delta);
		return last;


	}
	public static Seq plus (Jumble a, Jumble b){
		Jumble small, last, big;
		//int aVal, bVal;
		int i = 0;
		if(a.values.length < b.values.length){
			small = new Jumble(a.values);
			big = new Jumble(b.values);
		}
		else{
			small = new Jumble(b.values);
			big = new Jumble(a.values);
		}
		JumbleIt ait = small.createSeqIt();
		JumbleIt bit = big.createSeqIt();
		while (ait.hasNext()){
			try{
				//aVal = ait.next() + bit.next();
				small.values[i++]= ait.next() + bit.next();

			}catch(UsingIteratorPastEndException e){}
		}
		last = new Jumble(small.values);
		return last;

	}

	public static Seq plus (Constant a, Delta b){
		Delta small, big;
		Delta last;
		//int aVal, bVal;
		if(a.num < b.num){
			small = new Delta(a.num, a.value, 0);
			big = new Delta(b.num, b.initial, b.delta);
		}
		else{
			small = new Delta(b.num, b.initial, b.delta);
			big = new Delta(a.num, a.value, 0);
		}
		//ContstantIt ait = small.createSeqIt();
		//ContstantIt bit = big.createSeqIt();
		small.initial = small.initial + big.initial;
		small.delta = small.delta + big.delta;
		//System.err.println("Small Delta is: "+small.value);
		last = new Delta(small.num, small.initial, small.delta);
		return last;
	}
	public static Seq plus (Delta a, Constant b){
		Delta small, big;
		Delta last;
		//int aVal, bVal;
		if(a.num < b.num){
			small = new Delta(a.num, a.initial, a.delta);
			big = new Delta(b.num, b.value, 0);
		}
		else{
			small = new Delta(b.num, b.value, 0);
			big = new Delta(a.num, a.initial, a.delta);
		}
		//ContstantIt ait = small.createSeqIt();
		//ContstantIt bit = big.createSeqIt();
		small.initial = small.initial + big.initial;
		small.delta = small.delta + big.delta;
		//System.err.println("Small Delta is: "+small.value);
		last = new Delta(small.num, small.initial, small.delta);
		return last;
	}
	public static Seq plus (Constant a, Jumble b){
		Jumble small, last, big;
		//int aVal, bVal;
		int i = 0;
		int [] constArray = new int[a.num];
		for (int j=0; j < a.num; j++){ constArray[j]= a.value;}
		if(a.num < b.values.length){

			small = new Jumble(constArray);
			big = new Jumble(b.values);
		}
		else{
			small = new Jumble(b.values);
			big = new Jumble(constArray);
		}
		JumbleIt ait = small.createSeqIt();
		JumbleIt bit = big.createSeqIt();
		while (ait.hasNext()){
			try{
				//aVal = ait.next() + bit.next();
				small.values[i++]= ait.next() + bit.next();

			}catch(UsingIteratorPastEndException e){}
		}
		last = new Jumble(small.values);
		return last;
	}
	public static Seq plus (Jumble a, Constant b){
		Jumble small, last, big;
		//int aVal, bVal;
		int i = 0;
		int [] constArray = new int[b.num];
		for (int j=0; j < b.num; j++){ constArray[j]= b.value;}
		if(a.values.length < b.num){
			small = new Jumble(a.values);
			big = new Jumble(constArray);
			
		}
		else{
			small = new Jumble(constArray);
			big = new Jumble(a.values);
		}
		JumbleIt ait = small.createSeqIt();
		JumbleIt bit = big.createSeqIt();
		while (ait.hasNext()){
			try{
				//aVal = ait.next() + bit.next();
				small.values[i++]= ait.next() + bit.next();

			}catch(UsingIteratorPastEndException e){}
		}
		last = new Jumble(small.values);
		return last;
	}
	public static Seq plus (Delta a, Jumble b){
		Jumble small, last, big;
		//int aVal, bVal;
		int i = 0;
		int [] constArray = new int[a.num];
		for (int j=0; j < a.num; j++){ constArray[j]= (a.initial+(j*a.delta));}
		if(b.values.length < a.num){
			small = new Jumble(b.values);
			big = new Jumble(constArray);
			
		}
		else{
			small = new Jumble(constArray);
			big = new Jumble(a.values);
		}
		JumbleIt ait = small.createSeqIt();
		JumbleIt bit = big.createSeqIt();
		while (ait.hasNext()){
			try{
				//aVal = ait.next() + bit.next();
				small.values[i++]= ait.next() + bit.next();

			}catch(UsingIteratorPastEndException e){}
		}
		last = new Jumble(small.values);
		return last;
	}
	public static Seq plus (Jumble a, Delta b) {
				Jumble small, last, big;
		//int aVal, bVal;
		int i = 0;
		int [] constArray = new int[b.num];
		for (int j=0; j < b.num; j++){ constArray[j]= (b.initial+(j*b.delta));}
		if(a.values.length < b.num){
			small = new Jumble(a.values);
			big = new Jumble(constArray);
			
		}
		else{
			small = new Jumble(constArray);
			big = new Jumble(a.values);
		}
		JumbleIt ait = small.createSeqIt();
		JumbleIt bit = big.createSeqIt();
		while (ait.hasNext()){
			try{
				//aVal = ait.next() + bit.next();
				small.values[i++]= ait.next() + bit.next();

			}catch(UsingIteratorPastEndException e){}
		}
		last = new Jumble(small.values);
		return last;
	}
}