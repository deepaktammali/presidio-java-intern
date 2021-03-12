package labtest2solutions;

public class PassByValAndRefQ1 {

	private static void modifyPages(Book book) {
		book.numPages+=100;
	}
	
	public static void main(String args[]) {
		
//		Objects are pass by reference
		Book myBook = new Book(100);
		System.out.println(myBook.numPages);
		modifyPages(myBook);
		System.out.println(myBook.numPages);
		
		
	}
}

class Book{
	public int numPages;
	Book(int numPages){
		this.numPages = numPages;
	}
}