public class Jumble extends Seq{
	//protected int [] values;
	public Jumble( int [] values){
		//this.values = new int [](values.length);
		if(values.length == 0){
			this.values = null;
		}

		else{	
			System.arraycopy(values, 0, this.values, 0, values.length);
		}
	}
	public String toString(){
		String temp = ("{ "+values.length+" :");
		for (int i = 0; i < values.length; i++){
			temp = temp.concat(" "+values[i]);
		}
		temp = temp.concat(" }");
		return temp;
	}//toString()


}