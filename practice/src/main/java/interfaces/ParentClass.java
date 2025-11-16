package interfaces;

public class ParentClass {
    String name = "Parent";

    public ParentClass(){
        name = "Parent";
    }
    public ParentClass(String str){
        name = str;
    }
    public void printName(){
        System.out.println(name);
    }
}
