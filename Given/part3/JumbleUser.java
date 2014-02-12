public class JumbleUser{

	public static int lengthLongestNDCSS1(Jumble j){
		JumbleIt user = new JumbleIt(j);
		int longest = 0;
		int counter = 0;
		int prev = -999799;
		while(user.hasNext()){
			if(user.next() > prev){
				counter++;
			}
			else{
				counter = 1;	
			}
			if (counter > longest){
				longest = counter;
			}
		}
		return longest;
	}
	
}