package com.github.diogosmendonca.view;
import com.github.diogosmendonca.view.commands.*;

public class Main{

    private static String output = null;

    public static void main(String[] args){
        String result = null;
        if(args != null && args.length > 0){
            switch(args[0]){
                case "firstSpecificCommand":
                    result = Invoker.invoke("firstSpecificCommand");
                    break;
                case "secondSpecificCommand":
                    result = Invoker.invoke("secondSpecificCommand");
                    break;
                default:
                    result = "Command not found";
                    break;
            }
        }else{
            result = "Command not found";
        }
        System.out.println(result);
        output = result;
    }

    public static String getOutput(){
        return output;
    }
}