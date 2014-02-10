public class Constant extends Seq{
	//protected int num;
	//protected int value;
	public void Constant( int num, int value ){
		this.number = num;
		if (num == 0) {
			this.value = 0;
		}
		else{ this.value = value;}
	}

	public toString(){
		System.err.print("[ "+num+" : "+ value+" ]");
	}


}