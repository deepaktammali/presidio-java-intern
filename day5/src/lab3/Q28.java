package lab3;

//can also be done with month as integer

public class Q28 {
	public static String getSeason(String month) {
		if(month== "Jan"){
			return "Winter";
		 } else if( month== "Feb"){
			return "Winter";
		 } else if( month== "Mar"){
			return "Spring";
		 } else if( month== "Apr"){
			return "Spring";
		 } else if( month== "May"){
			return "Spring";
		 } else if( month== "Jun"){
			return "Summer";
		 } else if( month== "Jul"){
			return "Summer";
		 } else if( month== "Aug"){
			return "Summer";
		 } else if( month== "Sep"){
			return "Autumn";
		 } else if( month== "Oct"){
			return "Autumn";
		 } else if( month== "Nov"){
			return "Autumn";
		 } else if( month== "Dec"){
			return "Winter";
		}else{
			return "Month not valid";
		}
	}
	
	public static void main(String[] args) {
		String month = "Apr";
		System.out.printf("The month %s is %s season",month,getSeason(month));
	}
}
