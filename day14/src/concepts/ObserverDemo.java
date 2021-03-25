package concepts;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ForkJoinPool;
public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm shakthi=new FireAlarm();
		shakthi.addObserver(new Student());
		shakthi.addObserver(new Teacher());
		shakthi.setFire();		
	}
}
class ThreadedObservable extends Observable{
	@Override
		public synchronized void addObserver(Observer o) {
			// TODO Auto-generated method stub
			super.addObserver(o);
		}
	@Override
		public void notifyObservers(Object arg) {
			// TODO Auto-generated method stub

				super.notifyObservers(arg);

		}
}
class FireAlarm extends ThreadedObservable{
	public void setFire() {
		setChanged();
		notifyObservers("fire in the mountain run run run..............");//signal is sent
	}
}
class Student implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		new Thread(()->{
			runAway((String)arg);
		}).start();
	}
	public void runAway(String msg) {
		System.out.println("students running..........away........"+msg);
	}
}
class Teacher implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		new Thread(()->{
			runAway((String)arg);
		}).start();
	}
	public void runAway(String msg) {
		System.out.println("Teacher..thinking.................");
		try {Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("teacher running...........away........."+msg);
	}
}
