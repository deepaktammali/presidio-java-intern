package labtestsolutions;

public class StaticVar {
	static int j=20;
	public static void main(String[] args) {
			
			        int i=10;
			        StaticVar p = new StaticVar();
			        p.amethod(i);
			        System.out.println(i);
			        System.out.println(j);
	}
	public void amethod(int x){
        x=x*2;
        j=j*2;
        }
}
