public class Plus {

	public static Seq plus (Seq a, Seq b){
		Seq small, big, last;//may not need
		SeqIt aitt = a.createSeqIt();
		SeqIt bitt = b.createSeqIt();
		int amin = 0, bmin = 0, lmin = 0;
		int arank, brank, lrank, prev, aval = 0, bval = 0, adelta, bdelta, aflag = 0, bflag = 0;
		while(true){
			if(!aitt.hasNext()){
				break;
			}
			amin++;
		}
		while(true){
			if(!bitt.hasNext()){
				break;
			}
			bmin++;
		}



		//Constant small
		aitt = a.createSeqIt();
		bitt = b.createSeqIt();

		while(true){
			if(!aitt.hasNext()){
				//it's a constant
				arank = 1;
				break;
			}
			aval = aitt.next();
			while(aitt.hasNext()){
				if(aval != aitt.next()){
					aflag = 1;
					break;
				}
			}
			if (aflag == 0){
				arank = 1;
				break;
			}
			//delta check
			aflag = 0;
			aitt = a.createSeqIt();
			aval = aitt.next();
			adelta = (prev = aitt.next()) - aval;
			while(aitt.hasNext()){
				if(adelta != aitt.next() - prev){
					aflag = 1;
					break;
				}
			}
			if (aflag == 0){
				arank = 2;
				break;
			}

			arank = 3;
			break;
		}

		while(true){
			if(!bitt.hasNext()){
				//it's a constant
				brank = 1;
				break;
			}
			bval = bitt.next();
			while(bitt.hasNext()){
				if(bval != bitt.next()){
					bflag = 1;
					break;
				}
			}
			if (bflag == 0){
				brank = 1;
				break;
			}
			//delta check
			bflag = 0;
			bitt = b.createSeqIt();
			bval = bitt.next();
			bdelta = (prev = bitt.next()) - bval;
			while(bitt.hasNext()){
				if(bdelta != bitt.next() - prev){
					bflag = 1;
					break;
				}
			}
			if (bflag == 0){
				brank = 2;
				break;
			}

			brank = 3;
			break;
		}


		lrank = (arank > brank) ? (brank):(arank);

		if(lrank == 1){
			if(amin > bmin){
				small = new Constant(bmin, bval);
				big = new Constant(amin, aval);
			}
			else{
				small = new Constant(amin, aval);
				big = new Constant(bmin, bval);
			}


			lmin = (amin > bmin) ? (bmin):(amin);

			 small.value = small.value + big.value;
			//System.err.println("VConstant is: "+small.value);
			last = new Constant(small.num, small.value);
			return last;

		}
		else if (lrank == 2) {
			if(amin > bmin){
				small = new Delta(bmin, bval, bdelta);
				big = new Delta(amin, aval, adelta);
			}
			else{
				small = new Delta(amin, aval, adelta);
				big = new Delta(bmin, bval, bdelta);
			}

			lmin = (amin > bmin) ? (bmin):(amin);

			small.initial = small.initial + big.initial;
			small.delta = small.delta + big.delta;
			//System.err.println("Small Delta is: "+small.value);
			last = new Delta(small.num, small.initial, small.delta);
			return last;

		}
		else{
			if(amin > bmin){
				if(brank == 1){
					int [] constArray = new int[b.num];
					for (int j=0; j < b.num; j++){ constArray[j]= b.value;}
					small = new Jumble(constArray);
				}
				else if (brank == 2) {
					int [] constArray = new int[b.num];
					for (int j=0; j < b.num; j++){ constArray[j]= (b.initial+(j*b.delta));}
					small = new Jumble(constArray);
				}
				else{
					small = new Jumble(b.values);
				}

				if(arank == 1){
					int [] constArray = new int[a.num];
					for (int j=0; j < a.num; j++){ constArray[j]= a.value;}
					big = new Jumble(constArray);
				}
				else if (arank == 2) {
					int [] constArray = new int[a.num];
					for (int j=0; j < a.num; j++){ constArray[j]= (a.initial+(j*a.delta));}
					big = new Jumble(constArray);
				}
				else{
					big = new Jumble(a.values);
				}
			}
			else{
				if(brank == 1){
					int [] constArray = new int[b.num];
					for (int j=0; j < b.num; j++){ constArray[j]= b.value;}
					big = new Jumble(constArray);
				}
				else if (brank == 2) {
					int [] constArray = new int[b.num];
					for (int j=0; j < b.num; j++){ constArray[j]= (b.initial+(j*b.delta));}
					big = new Jumble(constArray);
				}
				else{
					big = new Jumble(b.values);
				}

				if(arank == 1){
					int [] constArray = new int[a.num];
					for (int j=0; j < a.num; j++){ constArray[j]= a.value;}
					small = new Jumble(constArray);
				}
				else if (arank == 2) {
					int [] constArray = new int[a.num];
					for (int j=0; j < a.num; j++){ constArray[j]= (a.initial+(j*a.delta));}
					small = new Jumble(constArray);
				}
				else{
					small = new Jumble(a.values);
				}
			}

			lmin = (amin > bmin) ? (bmin):(amin);
			int x = 0;
			aitt = small.createSeqIt();
			bitt = big.createSeqIt();
			while (aitt.hasNext()){
				try{
					//aVal = ait.next() + bit.next();
					small.values[x++]= aitt.next() + bitt.next();

				}catch(UsingIteratorPastEndException e){}
			}
			last = new Jumble(small.values);
			return last;

		}
	}
}

