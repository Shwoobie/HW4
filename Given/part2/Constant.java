public class Constant extends Seq{
	//protected int num;
	//protected int value;
	private int minVal = -99979;
	public Constant( int num, int value ){
		this.num = num;
		if (num == 0) {
			this.value = 0;
		}
		else{ this.value = value;}

		if (num == 0){
			this.minVal = 0;
		}
		else if (minVal == -99979) {
			this.minVal = value;
		}
		else if (minVal > value) {
			this.minVal = value;
		}
	}

	public int min(){
		return minVal;
	}

	public String toString(){
		return("[ "+num+" : "+ value+" ]");
	}
}