package  com.github.diogosmendonca.control;

/**
 * Develop your facade in this class.
 * 
 * You must NOT change the name of the class. 
 */
public class ControlFacade{
    public static String diciplineSpecificService() {
        return DiciplineBusinessObject.diciplineSpecificService();
      }
    
      public static String studentSpecificService(){
        return StudentBusinessObject.studentSpecificService();
      }
}