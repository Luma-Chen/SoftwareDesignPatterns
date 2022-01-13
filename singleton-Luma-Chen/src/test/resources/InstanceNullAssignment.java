
public class SomeSingleton {
    
    @anyModifier
    SomeSingleton getInstance(){
        // Alert: instance should not be assigned to null value in getInstance method
        instance = null;
    }

}
