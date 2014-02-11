public class Delta extends Seq{
	//protected int num;
	//protected int initial;
	//protected int delta;
	private int minVal = 0;
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

		//if (num == 0){
		//	this.minVal = 0;
		//}
		if (minVal == 0) {
			this.minVal = delta;
		}
		else if (minVal > delta) {
			this.minVal = delta;
		}
	}

	public int min(){
		return minVal;
	}

	public String toString(){
		return("< "+num+" : "+ initial+ " &"+ delta+" >");
	}

}