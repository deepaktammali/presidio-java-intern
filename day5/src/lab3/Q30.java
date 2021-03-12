package lab3;

public class Q30 {
	
	private static String getSeason(String month) {
		switch(month) {
		case "Jan":
			return "Winter";
		case "Feb":
			return "Winter";
		case "Mar":
			return "Spring";
		case "Apr":
			return "Spring";
		case "May":
			return "Spring";
		case "Jun":
			return "Summer";
		case "Jul":
			return "Summer";
		case "Aug":
			return "Summer";
		case "Sep":
			return "Autumn";
		case "Oct":
			return "Autumn";
		case "Nov":
			return "Autumn";
		case "Dec":
			return "Winter";
		default:
			return "Month not valid";
		}
	}
	
	public static void main(String[] args) {
		String month = "Jan";
		System.out.printf("The month %s is %s season",month,getSeason(month));
	}
}
