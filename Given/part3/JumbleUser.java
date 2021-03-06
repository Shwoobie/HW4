public class JumbleUser{

	public static int lengthLongestNDCSS1(Jumble j){
		JumbleIt user = new JumbleIt(j);
		int longest = 0;
		int counter = 0;
		int curr;
		int prev = -999799;
		while(user.hasNext()){
			if((curr = user.next()) >= prev){
				counter++;
			}
			else{
				counter = 1;	
			}
			prev = curr;
			if (counter > longest){
				longest = counter;
			}
		}
		return longest;
	}
	
}