public class Jumble extends Seq{
	//protected int [] values;
	public void Jumble( int [] values){
		//this.values = new int [](values.length);
		System.arraycopy(values, 0, this.values, 0, values.length());
	}
	public toString(){
		System.err.print("{ "+values.length+" :");
			for (int i = 0; i < values.length; i++){
				System.err.print(" "+values[i]);
			}
		System.err.print(" }");
	}//toString()


}