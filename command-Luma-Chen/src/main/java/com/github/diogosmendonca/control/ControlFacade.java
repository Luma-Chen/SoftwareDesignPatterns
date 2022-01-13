package  com.github.diogosmendonca.control;

public class ControlFacade{

    public static String firstSpecificService(){
        return FirstBusinessObject.firstSpecificService();
    }

    public static String secondSpecificService(){
        return SecondBusinessObject.secondSpecificService();
    }

}