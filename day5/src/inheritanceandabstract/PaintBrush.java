package inheritanceandabstract;

public class PaintBrush {
	private Paint currentPaint;
	
	public void setPaint(Paint paint) {
		this.currentPaint = paint; 
	}
	
	public void paintColor(){
		System.out.println("Painting "+currentPaint.color+" color.");
	}
	
}
