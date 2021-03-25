package misc;

import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) {
		HashSet<CustomElement> set = new HashSet<CustomElement>();
		set.add(new CustomElement(1));
		set.add(new CustomElement(2));
		System.out.println(set);
	}
	
	
}

class CustomElement{
	int num;

	public CustomElement(int num) {
		super();
		this.num = num;
	}

	@Override
	public int hashCode() {
		return 1;
	}
}