package lab;

import java.util.*;

// C. As the code stands the output will be 3
// E. If the hashCode() method is uncommented the output will be 3 

public class Q5 {
	public static void main(String[] args) {
		Map<TODODay,String> todoList = new HashMap<>();
		TODODay monday = new TODODay("Monday");
		TODODay tuesday = new TODODay("Tuesday");
		todoList.put(monday, "do Work1");
		todoList.put(tuesday, "do Work2");
		System.out.println(monday.hashCode());
		System.out.println(todoList.size());
		
		
		
	}
}


class TODODay{
	String day;

	public TODODay(String day) {
		super();
		this.day = day;
	}
	
	public boolean equals(TODODay todoDay) {
		return (todoDay.day==this.day);
	}
	
	public int hashCode() {
		return 9;
	}
}