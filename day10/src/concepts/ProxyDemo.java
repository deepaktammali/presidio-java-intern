//package concepts;
//
//import java.lang.reflect.*;
//
//public class ProxyDemo {
//	public static void main(String[] args) {
//		Importer importer = new SteelImporter();
//		importer.doImport();
//
//		Object obj = Proxy.newProxyInstance(importer.getClass().getClassLoader(),
//				new Class[] { Importer.class, Exporter.class, MegaExporter.class },
//				new MyInvocationHandler(new Object[] {importer,new VaccineExporter(),new RiceExporter()})
//				);
//
//		Importer importerObj = (Importer)obj;
//		importerObj.doImport();
//		
//		Exporter exporterObj = (Exporter)obj;
//		exporterObj.doExport();
//		
//		MegaExporter megaExporter = (MegaExporter)obj;
//		megaExporter.doMegaExport();
//		
//	}
//}
//
////class MyInvocationHandler implements InvocationHandler {
////	private Object[] objects;
////	
////	public MyInvocationHandler(Object[] objects) {
////		this.objects = objects;
////	}
////
////	@Override
////	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////		Object returnObject=null;
////		for(Object obj:objects) {
////			Method[] methods = obj.getClass().getMethods();
////			for(Method objMethod:methods) {
////				if(objMethod.getName().equals(method.getName())) {
////					returnObject = objMethod.invoke(obj, args);
////				}
////			}
////		}
////		
////		return returnObject;
////	}
////
////}
//
//interface Importer {
//	public void doImport();
//}
//
//interface Exporter {
//	public void doExport();
//}
//
//interface MegaExporter {
//	public void doMegaExport();
//}
//
//class SteelImporter implements Importer {
//
//	@Override
//	public void doImport() {
//		System.out.println("Importing steel");
//	}
//
//}
//
//class RiceExporter implements Exporter {
//
//	@Override
//	public void doExport() {
//		System.out.println("Exporting rice");
//	}
//
//}
//
//class VaccineExporter implements MegaExporter {
//
//	@Override
//	public void doMegaExport() {
//		System.out.println("Exporting Vaccines in large containers.");
//	}
//
//}
