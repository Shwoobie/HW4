public class Plus {

	public static Seq plus (Seq a, Seq b){
		Seq small, big, last;//may not need
		SeqIt aitt = a.createSeqIt();
		SeqIt bitt = b.createSeqIt();
		int amin = 0, bmin = 0, lmin = 0;
		int arank, brank, lrank, nxt =0, prev = 0, aval = 0, bval = 0, adelta = 0, bdelta = 0, aflag = 0, bflag = 0, aismall = 0, bismall = 0;
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
				aismall = 1;
			}

			lmin = (amin > bmin) ? (bmin):(amin);

			small.initial = small.initial + big.initial;
			small.delta = small.delta + big.delta;
			//System.err.println("Small Delta is: "+small.value);
			if(arank == brank){
				if (aismall == 1){
					aitt = a.createSeqIt();
					bitt = b.createSeqIt();
				}
				else{
					aitt = b.createSeqIt();
					bitt = a.createSeqIt();
				}
				aflag = 0;
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
					if (aismall == 1){
						aitt = a.createSeqIt();
						bitt = b.createSeqIt();
					}
					else{
						aitt = b.createSeqIt();
						bitt = a.createSeqIt();
					}
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

					arank = 3; //it should never reach here
					System.err.println("this should never print");
					break;
				}//while
				if(arank == 1){
					last = new Constant (lmin, aval);
					return last;
				}
			}
			if (small.num ==1 || small.delta == 0){
				last = new Constant(small.num, small.initial);
				return last;
			}
			last = new Delta(small.num, small.initial, small.delta);
			return last;

		}
		else{// it is jumble adds

			if(amin > bmin){
				if(brank == 1){
					int [] constArray = new int[bmin];
					for (int j=0; j < bmin; j++){ constArray[j]= bval;}
					small = new Jumble(constArray);
				}
				else if (brank == 2) {
					int [] constArray = new int[bmin];
					for (int j=0; j < bmin; j++){ constArray[j]= (bval+(j*bdelta));}
					small = new Jumble(constArray);
				}
				else{
					small = b;
					aitt = b.createSeqIt();
				}

				if(arank == 1){
					int [] constArray = new int[amin];
					for (int j=0; j < amin; j++){ constArray[j]= aval;}
					big = new Jumble(constArray);
				}
				else if (arank == 2) {
					//System.out.print( "e");
					int [] constArray = new int[amin];
					for (int j=0; j < amin; j++){ constArray[j]= (aval+(j*adelta));}
					big = new Jumble(constArray);
				}
				else{
					big = a;
					bitt = a.createSeqIt();
				}
			}
			else{
				if(brank == 1){
					int [] constArray = new int[bmin];
					for (int j=0; j < bmin; j++){ constArray[j]= bval;}
					big = new Jumble(constArray);
				}
				else if (brank == 2) {
					int [] constArray = new int[bmin];
					for (int j=0; j < bmin; j++){ constArray[j]= (bval+(j*bdelta));}
					big = new Jumble(constArray);
				}
				else{
					big = b;
					bitt = b.createSeqIt();
				}
				aismall = 1;
				if(arank == 1){
					int [] constArray = new int[amin];
					for (int j=0; j < amin; j++){ constArray[j]= aval;}
					small = new Jumble(constArray);
				}
				else if (arank == 2) {
					int [] constArray = new int[amin];
					for (int j=0; j < amin; j++){ constArray[j]= (aval+(j*adelta));}
					small = new Jumble(constArray);
				}
				else{
					small = a;
					aitt = a.createSeqIt();
				}
			}

			lmin = (amin > bmin) ? (bmin):(amin);
			int x = 0;
			//aitt = small.createSeqIt();
			//bitt = big.createSeqIt();
			while (aitt.hasNext()){
				try{
					//System.out.print( "a");
					//aVal = ait.next() + bit.next();
					small.values[x++]= aitt.next() + bitt.next();

				}catch(UsingIteratorPastEndException e){}
			}
			if (arank == brank){//if they are both jumble types we didnt call any int arrays
				if (aismall == 1){
					aitt = a.createSeqIt();
					bitt = b.createSeqIt();
				}
				else{
					aitt = b.createSeqIt();
					bitt = a.createSeqIt();
				}
				aflag = 0;
				while(true){
					System.out.print( "a");
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
						try{System.out.print( "4");
							if(aval != aitt.next()){

							aflag = 1;
							
							break;
							}
						}catch(UsingIteratorPastEndException e){}
					}
					if (aflag == 0){
						arank = 1;
						System.out.print( "5");
						break;
					}
					//delta check
					aflag = 0;
					if (aismall == 1){
						aitt = a.createSeqIt();
						bitt = b.createSeqIt();
					}
					else{
						aitt = b.createSeqIt();
						bitt = a.createSeqIt();
					}
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
				}//while
				if(arank == 1){
					System.err.print("this should never print");
					last = new Constant (lmin, aval);
					//while (aitt.hasNext()){
					//	try{
					//System.out.print( "a");
					//aVal = ait.next() + bit.next();
					//small.values[x++]= aitt.next() - bitt.next();

				//}catch(UsingIteratorPastEndException e){}
			//}

					return last;
				}
				else if(arank == 2){
					last = new Delta (lmin, aval, adelta);
					//while (aitt.hasNext()){
					//try{
					////System.out.print( "a");
					//aVal = ait.next() + bit.next();
					//small.values[x++]= aitt.next() - bitt.next();

				//}catch(UsingIteratorPastEndException e){}
			//}

					return last;
				}
				
			}
			last = new Jumble(small.values);
			//while (aitt.hasNext()){
			//	try{
					//System.out.print( "a");
					//aVal = ait.next() + bit.next();
					//small.values[x++]= aitt.next() - bitt.next();

			//	}catch(UsingIteratorPastEndException e){}
			//}


			return last;

		}
	}
}

