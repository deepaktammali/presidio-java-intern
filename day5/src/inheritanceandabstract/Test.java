package inheritanceandabstract;

public class Test {
	public static void main(String[] args) {
		PaintBrush colorBrush = new PaintBrush();
		colorBrush.setPaint(new RedPaint());
		colorBrush.paintColor();
		colorBrush.setPaint(new BluePaint());
		colorBrush.paintColor();
	}
}