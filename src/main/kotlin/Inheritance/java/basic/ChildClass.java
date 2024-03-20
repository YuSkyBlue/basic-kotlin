package Inheritance.java.basic;

public class ChildClass extends ParentClass{

    public ChildClass(){
        super();
        System.out.println("ChildClass Constructor called");
    }
    public ChildClass(String message){
        super(message);
        System.out.println("ChildClass construcotr called with message: " + message);
    }
    public static void main(String[] args){
        ChildClass childClass = new ChildClass();
        ChildClass childClass1 = new ChildClass("Chungkyu");
    }
}
