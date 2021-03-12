package labtest2solutions;

public class Q11Inheritance {
	public static void main(String[] args) {
		CNew cClass = new CNew(1,2);
	}
}

class ANew {
	private int aMember;

	ANew(int aMember) {
		this.aMember = aMember;
	}
}

class BNew {
	private int bMember;

	BNew(int bMember) {
		this.bMember = bMember;
	}
}

class CNew extends ANew {
	private BNew b;
	
	CNew(int aMember,int bMember){
		super(aMember);
		b = new BNew(bMember);
	}
	
}
