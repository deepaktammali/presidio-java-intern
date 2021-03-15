package lab6;

public class Q48{
	public static void main(String[] args){
		Add add = new Add(1);
		System.out.println(add.result);
		add = new Add(2,3);
		System.out.println(add.result);
		add = new Add(4,5,6);
		System.out.println(add.result);
	}
}


class Add{
	int result;
	
	Add(int a){
		this(a,0);
	}

	Add(int a,int b){
		this(a,b,0);
	}

	Add(int a,int b,int c){
		this.result = a + b + c;
	}
}