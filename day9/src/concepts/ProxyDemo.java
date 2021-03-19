package concepts;

import java.lang.reflect.*;

public class ProxyDemo {
	public static void main(String[] args) {
		ShoeManufacturer shoeManufacturer = new BataFactory();
		Seller shoeSeller = new MyShoeShop(shoeManufacturer);
		Importer shoeImporter = new ShoeImporter();
		
		Object object = Proxy.newProxyInstance(shoeSeller.getClass().getClassLoader(), new Class[] {Seller.class,Importer.class}, new SellerInvocationHandler(new Object[] {shoeImporter,shoeSeller}));
		
		shoeImporter = (Importer)object;
		shoeImporter.doImport();
				
	}
}


class SellerInvocationHandler implements InvocationHandler{
	Object[] myObjects;
	public SellerInvocationHandler(Object[] myObjects) {
		this.myObjects = myObjects;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject = null;
		
		for(Object obj:myObjects) {
			Method[] methods = obj.getClass().getMethods();
			for (Method objMethod:methods) {
				if(objMethod.getName().equals(method.getName())) {
					returnObject = objMethod.invoke(obj, args);
				}
			}
		}
		
		
		return returnObject;
	}
	
}


// importer

interface Importer {
	public void doImport();
}

class ShoeImporter implements Importer {

	@Override
	public void doImport() {
		System.out.println("Importing shoes.");
	}

}

// shoes

abstract class Shoe {

}

class LeatherShoe extends Shoe {
	
}

class SportsShoe extends Shoe {

}

// maufacturer

interface Manufacturer {

}

interface ShoeManufacturer extends Manufacturer {
	public Shoe makeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer {

}

class NikeFactory extends ShoeFactory {

	@Override
	public Shoe makeShoe() {
		System.out.println("Sports shoe");
		return new SportsShoe();
	}

}

class BataFactory extends ShoeFactory {

	@Override
	public Shoe makeShoe() {
		System.out.println("Leather shoe");
		return new LeatherShoe();
	}

}

// shoe shop

interface Seller {
}

abstract class ShoeSeller implements Seller {
	protected ShoeManufacturer manufacturer;

	public ShoeManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ShoeManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	abstract public Shoe sellShoe();
}

abstract class ShoeShop extends ShoeSeller {

}

class MyShoeShop extends ShoeShop {

	public MyShoeShop(ShoeManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public Shoe sellShoe() {
		return new SportsShoe();
	}

}
