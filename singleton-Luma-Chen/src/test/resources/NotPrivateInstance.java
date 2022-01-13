public class SomeSingleton {
    
    @AlertIfNotPrivate("Instance attribute should be private") 
    private static SomeSingleton instance;
    
}
