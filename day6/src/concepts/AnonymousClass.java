package concepts;

public class AnonymousClass {

	interface HelloGreeting{
		public void sayHello();
	}
	
	public void sayHello() {
		
//		local class
		class EnglishGreeting implements HelloGreeting{
			@Override
			public void sayHello() {
				System.out.println("Hello");
			}
		}
		
		EnglishGreeting englishGreeting = new EnglishGreeting();
		englishGreeting.sayHello();
		
//		anonymous classes HelloGreeting can be a class or an interface
		HelloGreeting spanishGreeting = new HelloGreeting() {
			@Override
			public void sayHello() {
				System.out.println("mundo");
			}
		};
		
		spanishGreeting.sayHello();
	}
	
	public static void main(String[] args) {
		AnonymousClass anonymousClass = new AnonymousClass();
		anonymousClass.sayHello();
	}
}

