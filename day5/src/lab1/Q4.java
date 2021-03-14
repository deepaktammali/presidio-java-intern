public class Q4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String inputString = sc.next();
		count(inputString);
		sc.close();

	}

	public static void count(String x){
		char[] charArray = x.toCharArray();
		int letterCount = 0;
		int digitCount = 0;
		int spaceCount = 0;
		int otherCount = 0;

		for (char ch:charArray){
			if(Character.isDigit(ch)){
				digitCount+=1;
			}
			else if(Character.isLetter(ch)){
				letterCount+=1;
			}
			else if(Character.isSpaceChar(ch)){
				spaceCount+=1;
			}
			else{
				otherCount += 1;
			}
		}
		System.out.println(digitCount,letterCount,spaceCount,otherCount);
	}

	}