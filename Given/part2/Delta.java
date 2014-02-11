public class Delta extends Seq{
	//protected int num;
	//protected int initial;
	//protected int delta;
	private int minVal = -99979;
	public Delta( int num, int initial, int delta ){
		this.num = num;
		if (num == 0){
			this.initial = 0;
			this.delta = 0;
		}
		else{
		this.initial = initial;
		this.delta = delta;
		}

//System.err.println("minval:" + minVal + "init: " + initial);

		if (num == 0){
			this.minVal = 0;
		}
		else if (delta < 0) {
			this.minVal = (initial + ((num-1)*delta));
		}
		else {
			this.minVal = initial;
		}
	}

	public int min(){
		System.err.println("minval:" + minVal + "init: " + initial);
		return minVal;
	}

	public String toString(){
		return("< "+num+" : "+ initial+ " &"+ delta+" >");
	}

}