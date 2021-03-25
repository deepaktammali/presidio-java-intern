//package concepts;
//
//import java.util.Observable;
//import java.util.Observer;
//import java.util.Vector;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ForkJoinPool;
//
//public class ObserverPatternDemo {
//	public static void main(String[] args) {
//		FireAlarm fireAlarm = new FireAlarm();
//		
//		fireAlarm.addObserver(new Student());
//		fireAlarm.addObserver(new Teacher());
//		
//		fireAlarm.soundAlarm();
//	}
//}
//
//
//class ThreadedObservable extends Observable{
//	@Override
//		public synchronized void addObserver(Observer o) {
//			// TODO Auto-generated method stub
//			super.addObserver(o);
//		}
//	@Override
//		public void notifyObservers(Object arg) {
//			setChanged();
//			super.notifyObservers(arg);
//		}
//}
//
//class FireAlarm extends ThreadedObservable{
//	public void soundAlarm() {
//		notifyObservers("fire");
//	}
//}
//
//
//class Student implements Observer{
//
//	public void runAway() {
//		System.out.println("Student Running Away");
//	}
//	
//
//	public void update(Observable o, Object msg) {
//		switch((String) msg) {
//		case "fire":
//			runAway();
//			break;
//		}
//	}
//	
//}
//
//class Teacher implements Observer{
//
//	
//	public void runAway(){
//		try {
//			System.out.println("Teacher Thinking..");
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Teacher Running Away");
//	}
//
//	public void update(Observable o, Object arg) {
//		switch((String) arg) {
//		case "fire":
//			new Thread(()->{
//				runAway();
//			}).start();
//				
//			break;
//		}
//	}
//	
//}
