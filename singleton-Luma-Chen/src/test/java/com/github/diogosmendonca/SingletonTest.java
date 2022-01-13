package com.github.diogosmendonca;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.scpl.model.Node;
import br.scpl.view.Search;

/**
 * Structural and execution checking of elements of a singleton.
 */
public class SingletonTest
{

    private static String className = "./src/main/java/com/github/diogosmendonca/MySingleton.java";
    private static String patternsPath = "./src/test/resources/";

    
    public void patternChecking(String pattern)
    {        
        List<Node> retorno = Search.searchOccurrences(className, patternsPath + pattern + ".java");
        if(retorno != null){
            for(Node n: retorno){
                assertFalse(n.isToReturn(), "Structural checking failed. Check de console log for the alert message.");
            }
        }else{
            fail("Error during test execution.");
        }
    }

    @Tag("instanceChecking")
    @ParameterizedTest
    @ValueSource(strings = {"MissingInstanceSingleton", "NotStaticInstance", "NotPrivateInstance"}) 
    public void instanceTest(String pattern){
        patternChecking(pattern);
    }

    @Tag("constructorChecking")
    @ParameterizedTest
    @ValueSource(strings = {"DefaultConstructorSingleton", "NotPrivateConstructor"}) 
    public void constructorTest(String pattern){
        patternChecking(pattern);
    }

    @Tag("getInstanceChecking")
    @ParameterizedTest
    @ValueSource(strings = {"MissingGetInstanceSingleton", "PrivateGetInstance", "NotStaticGetInstance", 
    "GetInstanceReturnsNull", "NotVerifyForNullBerforeInstantiate", "InstanceNullAssignment", "NotReturnInstance"}) 
    public void getInstanceTest(String pattern){
        patternChecking(pattern);
    }

    @Tag("executionTest")
    @Test
    public void sameInstanceTest(){

        java.lang.reflect.Method method;
        try {
            method = MySingleton.class.getMethod("getInstance");
            assertNotNull(method.invoke(null));
            assertSame(method.invoke(null), method.invoke(null));
        } catch (Exception e) {
            fail("Execution of getInstance threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }

}
