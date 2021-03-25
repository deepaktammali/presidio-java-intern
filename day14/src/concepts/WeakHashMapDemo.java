package concepts;

import java.util.*;
import java.util.Map.Entry;

public class WeakHashMapDemo {
	public static void main(String[] args) {
		Bag myBag = new Bag();
		Shoes myShoes = new Shoes();
		
		Map<Object,Integer> myItems = new WeakHashMap<Object,Integer>();
		
		myItems.put(myBag,5000);
		myItems.put(myShoes, 2000);
		
		printMapItems(myItems);
		
		myBag = null;
		System.out.println("After making myBag null");
		System.gc();
		printMapItems(myItems);
		
	}
	
	public static <K,V> void printMapItems(Map<K,V> map) {
		
		Set<Entry<K, V>> itemsEntry = map.entrySet();
		
		for(Entry<K, V> item:itemsEntry) {
			System.out.println(item.getKey()+" : "+item.getValue());
		}
		
	}
}


class Bag{
	public Bag() {
	}
}

class Shoes{
	public Shoes() {
		
	}
}