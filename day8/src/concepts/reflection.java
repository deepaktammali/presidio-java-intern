package concepts;

import java.lang.reflect.*;

public class reflection {
	public static void main(String[] args) throws Exception {
		Politician politician = new Politician();
		Police police = new Police();
		police.doArrest(politician);
	}
}

class Police{
	public void doArrest(Object obj) throws Exception{
		Class objClass = obj.getClass();
		System.out.println("The class name is "+objClass.getName());
		
		Method[] methods = objClass.getMethods();
		
		for(Method method:methods) {
			System.out.println("The method name is "+method.getName());
		}
		
		Field[] fields = objClass.getFields();
		
		for(Field field:fields) {
			System.out.println("The field name is :"+field.getName()+" and Value :"+field.get(obj));
		}
		
		methods = objClass.getDeclaredMethods();
		fields = objClass.getDeclaredFields();
		
		for(Method method:methods) {
			System.out.println("The method name is "+method.getName());
		}
		
		
		for(Field field:fields) {
			field.setAccessible(true);
			System.out.println("The field name is :"+field.getName()+" and Value :"+field.get(obj));
		}
		
		Field originalCharField = objClass.getDeclaredField("originalCharacter");
		originalCharField.setAccessible(true);
		originalCharField.set(obj,"Good Man");
		
		System.out.println("The original character now is "+originalCharField.get(obj));
		
		Politician goodPolitician = (Politician)objClass.getDeclaredConstructor(String.class).newInstance("good man");
		
		
	}
}



class Politician{
	public String publicFame="Good guy";
	private String originalCharacter = "Bad Guy";
	
	public Politician() {
		
	}
	
	private Politician(String originalCharacter) {
		this.originalCharacter = originalCharacter;
	}
	
	private void getBlackMoneyDetails() {
		System.out.println("Black Money Details");
	}
	
	public void doWork() {
		System.out.println("DO THE JOB.");
	}
	
}
