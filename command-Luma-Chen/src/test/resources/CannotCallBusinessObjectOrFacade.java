
public class SomeClass{

    public static void main(String[] args){
        //#BEGIN

        //Alert: Business Object cannot be called from Main, call a command instead.
        FirstBusinessObject.someMethod();
        
        //#OR

        //Alert: Business Object cannot be called from Main, call a command instead.
        SecondBusinessObject.someMethod();

        //#OR

        //Alert: ControlFacade cannot be called from Main, call a command instead.
        ControlFacade.someMethod();

        //#END
    }

}