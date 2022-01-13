package com.github.diogosmendonca;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.scpl.model.Node;
import br.scpl.view.Search;

import com.github.diogosmendonca.Main;


/**
 * Structural and execution checking of elements of a FactoryMethod.
 */
public class FactoryMethodTest
{
    
    private static String appClassName = "./src/main/java/com/github/diogosmendonca/App.java";
    private static String appAClassName = "./src/main/java/com/github/diogosmendonca/AppA.java";
    private static String appBClassName = "./src/main/java/com/github/diogosmendonca/AppB.java";
    private static String productClassName = "./src/main/java/com/github/diogosmendonca/Product.java";
    //private static String productAClassName = "./src/main/java/com/github/diogosmendonca/ProductA.java";
    //private static String productBClassName = "./src/main/java/com/github/diogosmendonca/ProductB.java";
    private static String mainClassName = "./src/main/java/com/github/diogosmendonca/Main.java";
    private static String patternsPath = "./src/test/resources/";
    
    
    public void patternChecking(String pattern, String... files)
    {        
        List<Node> retorno = new ArrayList<Node>();
        
        for(String file: files){
            List<Node> found = Search.searchOccurrences(file, patternsPath + pattern + ".java");
            if(found != null)
                retorno.addAll(found);
            else
                fail("Error during test execution.");
        }
        for(Node n: retorno){
            assertFalse(n.isToReturn(), "Structural checking failed. Check de console log for the alert message.");
        }

    }
    
    
    @Tag("MainChecking")
    @ParameterizedTest
    @ValueSource(strings = {"NotDeclareSpecificVariables", "MoveElementsOutsideIf"}) 
    public void mainTest(String pattern){
        patternChecking(pattern, mainClassName);
    }

    @Tag("AppChecking")
    @ParameterizedTest
    @ValueSource(strings = {"NotDeclareAbstractSpecificOperation", "AppShouldBeAbstract", 
    "DeclareFactoryMethod", "ImplementsSpecificOperation", "CallFactoryMethod"}) 
    public void appCheckingTest(String pattern){
        patternChecking(pattern, appClassName);
    }

    @Tag("AppSpecificChecking")
    @ParameterizedTest
    @ValueSource(strings = {"ImplementsFactoryMethod", "NotDeclareSpecificOperation"}) 
    public void appSpecificCheckingTest(String pattern){
        patternChecking(pattern, appAClassName, appBClassName);
    }
    
    @Tag("ProductChecking")
    @ParameterizedTest
    @ValueSource(strings = {"DeclareOtherOperation"}) 
    public void productCheckingTest(String pattern){
        patternChecking(pattern, productClassName);
    }
    
    @Tag("executionTest")
    @Test
    public void specificAppATest(){
        try {
            Main.main(new String[]{"A"});
            assertNotNull(Main.getOutput());
            assertEquals("call of otherOperation of ProductA", Main.getOutput());
        } catch (Exception e) {
            fail("Execution of specificAppATest threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }

    @Tag("executionTest")
    @Test
    public void specificAppBCommandTest(){
        try {
            Main.main(new String[]{"B"});
            assertNotNull(Main.getOutput());
            assertEquals("call of otherOperation of ProductB", Main.getOutput());
        } catch (Exception e) {
            fail("Execution of specificAppBTest threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }
    

}
