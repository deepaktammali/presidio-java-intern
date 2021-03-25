package concepts;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm shakthi = new FireAlarm();
		shakthi.addObserver(new Student());
		shakthi.addObserver(new Teacher());
		shakthi.setFire();
	}
}

interface ThreadedObserver{
	public void update(ThreadedObservable o,Object arg);
}

abstract class ThreadedObservable{

	private Vector<ThreadedObserver> observers;

	public ThreadedObservable() {
		observers = new Vector<ThreadedObserver>();
	}
	
	public synchronized void deleteObserver(ThreadedObserver o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}
	
	public synchronized void addObserver(ThreadedObserver o) {
		observers.add(o);
	}

	public void notifyObservers(Object arg) {
		
		synchronized(this) {
			
		}
		
		ExecutorService cachedPool = Executors.newCachedThreadPool();
		observers.forEach((o) -> {
			cachedPool.submit((Runnable) () -> {
				o.update(this,(Object)arg);
			});
		});
	}
}



class FireAlarm extends ThreadedObservable {
	public void setFire() {
		notifyObservers("fire in the mountain run run run..............");// signal is sent
	}
}

class Student implements ThreadedObserver {
	@Override
	public void update(ThreadedObservable o, Object arg) {
		runAway((String) arg);
	}

	public void runAway(String msg) {
		System.out.println("students running..........away........" + msg);
	}
}

class Teacher implements ThreadedObserver {
	@Override
	public void update(ThreadedObservable o, Object arg) {
		runAway((String) arg);
	}

	public void runAway(String msg) {
		System.out.println("Teacher..thinking.................");
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		System.out.println("teacher running...........away........." + msg);
	}
}
