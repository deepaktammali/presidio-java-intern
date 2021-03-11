package corejavatest;


class BaseClass {

}

class Sub extends BaseClass {
	
}

class Sub2 extends BaseClass{
	
}


public class CheckException {
        public static void main(String argv[]){
                BaseClass b=new BaseClass();
                Sub s =(Sub) b;
                }
}
