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
 * Structural and execution checking of elements of a command.
 */
public class CommandTest
{
    
    private static String commandClassName = "./src/main/java/com/github/diogosmendonca/view/commands/Command.java";
    private static String spCommandClassName1 = "./src/main/java/com/github/diogosmendonca/view/commands/FirstSpecificCommand.java";
    private static String spCommandClassName2 = "./src/main/java/com/github/diogosmendonca/view/commands/SecondSpecificCommand.java";
    private static String invokerClassName = "./src/main/java/com/github/diogosmendonca/view/commands/Invoker.java";
    private static String mainClassName = "./src/main/java/com/github/diogosmendonca/view/Main.java";
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
    @ValueSource(strings = {"CannotCallBusinessObjectOrFacade", "InvokeCall"}) 
    public void mainTest(String pattern){
        patternChecking(pattern, mainClassName);
    }

    @Tag("InvokerChecking")
    @ParameterizedTest
    @ValueSource(strings = {"CannotCallBusinessObjectOrFacade", "CommandMapShouldExists", 
                            "CommandsInitializationShouldExists1", "CommandsInitializationShouldExists2", "invokeMethodShouldExist", "StaticInitializer"}) 
    public void invokerTest(String pattern){
        patternChecking(pattern, invokerClassName);
    }

    
    @Tag("CommandInterfaceChecking")
    @ParameterizedTest
    @ValueSource(strings = {"ExecuteMethodShouldExists1"}) 
    public void commandInterfaceTest(String pattern){
        patternChecking(pattern, commandClassName);
    }
    

    @Tag("SpecificCommandsChecking")
    @ParameterizedTest
    @ValueSource(strings = {"ExecuteMethodShouldExists2"}) 
    public void specificCommandsTest(String pattern){
        patternChecking(pattern, spCommandClassName1, spCommandClassName2);
    }


    @Tag("executionTest")
    @Test
    public void firstSpecificCommandTest(){
        try {
            Main.main(new String[]{"firstSpecificCommand"});
            assertNotNull(Main.getOutput());
            assertEquals("call of firstSpecificService in FirstService", Main.getOutput());
        } catch (Exception e) {
            fail("Execution of firstSpecificCommandTest threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }

    @Tag("executionTest")
    @Test
    public void secondSpecificCommandTest(){
        try {
            Main.main(new String[]{"secondSpecificCommand"});
            assertNotNull(Main.getOutput());
            assertEquals("call of secondSpecificService in SecondService", Main.getOutput());
        } catch (Exception e) {
            fail("Execution of secondSpecificService threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }

    @Tag("executionTest")
    @Test
    public void nullCommandTest(){
        try {
            Main.main(null);
            assertNotNull(Main.getOutput());
            assertEquals("Command not found", Main.getOutput());
        } catch (Exception e) {
            fail("Execution of diciplineSpecificService threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }

    @Tag("executionTest")
    @Test
    public void notExistentCommandTest(){
        try {
            Main.main(new String[]{"notExistentCommand"});
            assertNotNull(Main.getOutput());
            assertEquals("Command not found", Main.getOutput());
        } catch (Exception e) {
            fail("Execution of diciplineSpecificService threw an exception: " + e.getClass() + " " + e.getMessage());
        }
    }

}
