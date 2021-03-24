package concepts;

import java.lang.reflect.*;

public class DecoratorDemo {
	public static void main(String[] args) {
		MyRestaurent myRestaurent = new MyRestaurent();
		
		Object obj = Proxy.newProxyInstance(myRestaurent.getClass().getClassLoader(),
											new Class[] {MyRestaurent.class,Chapathi.class},
											new MyInvocationHandler(new Object[] {new ChapathiDish(),myRestaurent}));
		
		myRestaurent = (MyRestaurent)obj;
		myRestaurent.makeRice();
		
	}
}

class MyInvocationHandler implements InvocationHandler {
	private Object[] objects;

	public MyInvocationHandler(Object[] objects) {
		this.objects = objects;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject = null;
		for (Object obj : objects) {
			Method[] methods = obj.getClass().getMethods();
			for (Method objMethod : methods) {
				if (objMethod.getName().equals(method.getName())) {
					returnObject = objMethod.invoke(obj, args);
				}
			}
		}

		return returnObject;
	}

}

interface Rice {
	void makeRice();
}

interface Chapathi {
	void makeChapathi();
}

class RiceDish implements Rice {

	@Override
	public void makeRice() {
		System.out.println("Making Rice");
	}

}

class ChapathiDish implements Chapathi {

	@Override
	public void makeChapathi() {
		System.out.println("Making Chapathi");
	}

}

interface Restaurent {

}

class MyRestaurent extends RiceDish implements Restaurent {

}