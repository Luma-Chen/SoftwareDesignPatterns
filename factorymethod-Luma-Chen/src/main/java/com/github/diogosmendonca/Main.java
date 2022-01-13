package com.github.diogosmendonca;

public class Main{

    private static String output = null;

    public static void main(String[] args) {

        if(args != null && args.length > 0 && args[0] != null){
            App app;
            if(args[0].equals("A")){
                app = new AppA();
            }else if(args[0].equals("B")){
                app = new AppB();
            }
            else{
              app = null;
            }
            output = app.specificOperation();
            System.out.println(output);
        }
    }
    
    public static String getOutput(){
        return output;
    }
}