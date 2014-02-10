public class Delta extends Seq{
	//protected int num;
	//protected int initial;
	//protected int delta;
	public void Delta( int num, int initial, int delta ){
		this.num = num;
		if (num == 0){
			this.initial = 0;
			this.delta = 0;
		}
		else
		this.initial = initial;
		this.delta = delta;
	}
	public toString(){
		System.err.print("< "+num+" : "+ initial+ " &"+ delta+" >");
	}

}