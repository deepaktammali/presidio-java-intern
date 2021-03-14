public class Q3{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.next();
		String reversedString="";
		for(char c:inputString){
			reversedString=c+reversedString;
		}
		System.out.println(reversedString);
	}
}