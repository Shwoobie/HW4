public class Jumble extends Seq{
	//protected int [] values;
	public Jumble( int [] values){
		//this.values = new int [](values.length);
		if(values.length == 0){
			//system.err.print("this is a print stestsf sdf ");
			this.values = new int[]{};
		}

		else{	
			this.values = new int[values.length];
			System.arraycopy(values, 0, this.values, 0, values.length);
		}
	}
	public String toString(){
		
		if( values.length == 0) {
			String temp =new String ("");
			return temp = temp.concat("{ 0 : }");
		}
		String temp = new String ("{ "+values.length+" :");
		
		for (int i = 0; i < values.length; i++){
			temp = temp.concat(" "+values[i]);
		}
		temp = temp.concat(" }");
		return temp;
	}//toString()


}