package interfaces;

public class ChildClass extends ParentClass{
    int ID = 0;

    public ChildClass(int n){

        ID = n;
    }

    public void print(){
        printName();
        System.out.println("ID  : "    + ID);
    }

}
