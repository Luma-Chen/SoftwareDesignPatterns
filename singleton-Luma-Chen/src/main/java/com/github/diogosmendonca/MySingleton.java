package com.github.diogosmendonca;

/**
 * Develop your singleton in this class.
 * 
 * You must NOT change the name of the class. 
 */
public class MySingleton {
    private static MySingleton instance;

    public static MySingleton getInstance() {
      if(instance == null) {
        instance = new MySingleton();
      }
      return instance;
    }
  
    private MySingleton() {
    }
}
