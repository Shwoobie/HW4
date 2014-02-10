public class Constant extends Seq{
	//protected int num;
	//protected int value;
	void Constant( int num, int value ){
		this.num = num;
		if (num == 0) {
			this.value = 0;
		}
		else{ this.value = value;}
	}

	String toString(){
		System.err.print("[ "+num+" : "+ value+" ]");
	}


}