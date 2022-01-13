
public class SomeClass{

    public static void main(String[] args){

        //#BEGIN

        //Alert: Business Object cannot be called from view package, call the Facade instead.
        DiciplineBusinessObject.someMethod();
        
        //#OR

        //Alert: Business Object cannot be called from view package, call the Facade instead.
        StudentBusinessObject.someMethod();
        
        //#END

    }

}