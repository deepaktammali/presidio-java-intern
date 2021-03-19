package concepts;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectionProxy {
	public static void main(String[] args) {
		
		Human haikyu = new Human("haikyu");
		SASTRA sastraLawyer = new SASTRA();
		
		Object human = Proxy.newProxyInstance(Human.class.getClassLoader(),
															new Class[]{Lawyer.class},
															new myInvocationHandler(new Object[]{haikyu,sastraLawyer})); 
		
		Lawyer humanLawyer = (Lawyer)human;
		humanLawyer.debate("Criminal Defense");
		
		
	}
}

class myInvocationHandler implements InvocationHandler{

	private final Object[] objects;
	
	
	public myInvocationHandler(Object[] objects) {
		this.objects = objects;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		System.out.println("Called "+method.getName());
//		System.out.println(args);
		
		Object returnObject = null;

		for(Object obj:objects) {
			Method[] methods = obj.getClass().getDeclaredMethods();
			for(Method objMethod:methods) {
				if(objMethod.getName().equals(method.getName())) {
					returnObject = objMethod.invoke(obj, args);
				}
			}
		}
		
		return returnObject;
	}
	
}


class Human {
	String name;

	public String getName() {
		return name;
	}

	Human(String name) {
		this.name = name;
	}
}

interface Lawyer {
	public void debate(String context);
}

class SASTRA implements Lawyer {
	public void debate(String context) {
		System.out.println("Debating [SASTRA Lawyer] ["+context+" context]");
	}
}

