package lab3;

public class Q29 {
	private static char[] vowels = {'a','e','i','o','u'};
	public static boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		for(int i=0;i<5;i++) {
			if(vowels[i]==ch) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isVowel('i'));
		System.out.println(isVowel('v'));
	}
}
