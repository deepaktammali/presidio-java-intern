package concepts;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
	private boolean changed;

	public ThreadedObservable() {
		observers = new Vector<ThreadedObserver>();
		changed=false;
	}
	
	public synchronized void deleteObserver(ThreadedObserver o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}
	
	public synchronized void addObserver(ThreadedObserver o) {
		observers.add(o);
	}
	
	public void setChanged() {
		this.changed = true;
	}
	
	public void clearChanged() {
		this.changed=false;
	}

	public void notifyObservers(Object arg) {
		
		synchronized(this) {
			if(changed==false) {
				return ;
			}
		}
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

		observers.forEach((o) -> {
			fixedThreadPool.submit((Runnable) () -> {
				o.update(this,(Object)arg);
			});
		});
		
		clearChanged();
	}
}



class FireAlarm extends ThreadedObservable {
	public void setFire() {
		setChanged();
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
