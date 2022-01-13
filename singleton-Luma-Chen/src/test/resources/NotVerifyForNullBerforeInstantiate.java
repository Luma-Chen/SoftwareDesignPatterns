
public class SomeSingleton {
    
    @anyModifier
    SomeSingleton getInstance(){
        //not_exists
        if(instance == null)
            //Alert: Verify if instance is null before instatiate the Singleton
            instance = new SomeSingleton();
    }

}
