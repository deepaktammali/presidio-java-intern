package lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// A. Fragment I compiles
// B. Fragment II compiles
// C. Fragment III compiles
// D. Fragment I executes without exception 
// E. Fragment II executes without exception 
// F. Fragment III executes without exception 


public class Q9 {

}

class Mixup {
	public static void main(String[] args) {
		Object o = new Object();
		LinkedHashSet s = new LinkedHashSet();
		s.add("o");
		s.add(o);
	}
}