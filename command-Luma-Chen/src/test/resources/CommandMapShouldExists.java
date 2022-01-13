

//Alert: Create in the invoker an static attribute that maps strings to command for store the commands. Use a Map<String, Command> commands = new HashMap<>() to declare and initialize it.
public class SomeInvoker{
    
    //#BEGIN

    //not_exists
    static Map<String, Command> any = new HashMap<>();

    //#AND

    //not_exists
    static Map<String, Command> any = new HashMap<String, Command>();

    //#END

}
