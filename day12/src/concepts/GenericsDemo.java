package concepts;

public class GenericsDemo {
	public static void main(String[] args) {
		Brush<Paint> redPaintBrush = PaintBrush.getPaintBrush(new RedPaint());
		Brush<Water> waterBrush = WaterBrush.getWaterBrush(new Water());
	}
}

class PaintBrush{
	public static Brush<Paint> getPaintBrush(Paint paint){
		Brush brush = new Brush();
		brush.setItem(paint);
		return brush;
	}
}

class WaterBrush{
	public static Brush<Water> getWaterBrush(Water water){
		Brush brush = new Brush();
		brush.setItem(water);
		return brush;
	}
}


class Brush<T>{
	T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}


class Water{
	
}

abstract class Paint{
	
}

class RedPaint extends Paint{
	
}

class BluePaint extends Paint{
	
}