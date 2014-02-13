public class Plus {

	public static Seq plus (Seq a, Seq b){
		Seq small, big, last;//may not need
		SeqIt aitt = a.createSeqIt();
		SeqIt bitt = b.createSeqIt();
		int amin = 0, bmin = 0, lmin = 0;
		int arank, brank, lrank, nxt =0, prev = 0, aval = 0, bval = 0, adelta = 0, bdelta = 0, aflag = 0, bflag = 0;
		while(true){
			
			if(!aitt.hasNext()){
				//System.out.print( "1");
				break;
			}
			try{
				aitt.next();	
			}catch(UsingIteratorPastEndException e){}
			amin++;
		}
		while(true){

			if(!bitt.hasNext()){
				//System.out.print( "2");
				break;
			}
			try{
				bitt.next();	
			}catch(UsingIteratorPastEndException e){}
			bmin++;
		}



		//Constant small
		aitt = a.createSeqIt();
		bitt = b.createSeqIt();

		while(true){
			//System.out.print( "a");
			if(!aitt.hasNext()){
				//System.out.print( "3");
				//it's a constant
				arank = 1;
				break;
			}
			try{
			aval = aitt.next();
			}catch(UsingIteratorPastEndException e){}
			while(aitt.hasNext()){
				try{
					if(aval != aitt.next()){
					aflag = 1;
					//System.out.print( "4");
					break;
					}
				}catch(UsingIteratorPastEndException e){}
			}
			if (aflag == 0){
				arank = 1;
				//System.out.print( "5");
				break;
			}
			//delta check
			aflag = 0;
			aitt = a.createSeqIt();
			try{
				aval = aitt.next();
				adelta = (prev = aitt.next()) - aval;
			}catch(UsingIteratorPastEndException e){}
			while(aitt.hasNext()){
				try{
					if(adelta != (nxt = aitt.next()) - prev){
						aflag = 1;
						//System.out.print( "6");
						break;
					}
					prev = nxt;
				}catch(UsingIteratorPastEndException e){}
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
			try{
				bval = bitt.next();
			}catch(UsingIteratorPastEndException e){}
			while(bitt.hasNext()){
				try{
					if(bval != bitt.next()){
						bflag = 1;
						break;
					}
				}catch(UsingIteratorPastEndException e){}
			}
			if (bflag == 0){
				brank = 1;
				break;
			}
			//delta check
			bflag = 0;
			bitt = b.createSeqIt();
			try{
				bval = bitt.next();
				bdelta = (prev = bitt.next()) - bval;
			}catch(UsingIteratorPastEndException e){}
			while(bitt.hasNext()){
				try{
					if(bdelta != (nxt = bitt.next()) - prev){
						bflag = 1;
						break;
					}
					prev = nxt;
				}catch(UsingIteratorPastEndException e){}
			}
			if (bflag == 0){
				brank = 2;
				break;
			}

			brank = 3;
			break;
		}


		lrank = (arank > brank) ? (arank):(brank);

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

