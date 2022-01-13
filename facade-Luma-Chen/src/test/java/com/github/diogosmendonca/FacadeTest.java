package com.github.diogosmendonca;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.scpl.model.Node;
import br.scpl.view.Search;

import com.github.diogosmendonca.view.Main;


/**
 * Structural and execution checking of elements of a singleton.
 */
public class FacadeTest
{
    
    private static String facadeClassName = "./src/main/java/com/github/diogosmendonca/control/ControlFacade.java";
    private static String callerClassName = "./src/main/java/com/github/diogosmendonca/view/Main.java";
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
    @ValueSource(strings = {"CannotCallBusinessObject"}) 
    public void instanceTest(String pattern){
        patternChecking(pattern, callerClassName);
    }

    
    @Tag("FacadeChecking")
    @ParameterizedTest
    @ValueSource(strings = {"FacadeMethodsShouldExists1", "FacadeMethodsShouldExists2"}) 
    public void constructorTest(String pattern){
        patternChecking(pattern, facadeClassName);
    }

    @Tag("executionTest")
    @Test
    public void executionTest(){
        try {
            Main.main(null);
            assertLinesMatch(Main.getOutput(), Arrays.asList("call of studentSpecificService in StudentsService", "call of diciplineSpecificService in DiciplineService"));
        } catch (Exception e) {
            fail("Execution of Main threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }
    

}
