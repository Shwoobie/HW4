public class Jumble extends Seq{
	//protected int [] values;
	private int minVal = 0;
	public Jumble( int [] values){
		//this.values = new int [](values.length);
		if(values.length == 0){
			this.values = new int[]{};
		}

		else{	
			this.values = new int[values.length];
			System.arraycopy(values, 0, this.values, 0, values.length);
		}

		if(values.length == 0){
			this.minVal = 0;
		}
		else if (minVal == 0) {
			minVal = values[0];
			for (int i = 0; i < values.length; i++){
				minVal = java.lang.Math.min(minVal, values[i]);
			}
		}
		else{
			for (int i = 0; i < values.length; i++){
				minVal = java.lang.Math.min(minVal, values[i]);
			}
		}

	}

	public int min(){
		return minVal;
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