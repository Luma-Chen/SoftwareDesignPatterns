package com.github.diogosmendonca;

public class AnyClass{
    
    public static void main(String[] args) {

        if(args != null && args.length > 0 && args[0] != null){
            
            if(args[0].equals("A")){
                
                //Alert: Move the call of specificOperation to after the if statemente that instantiate App.
                output = app.specificOperation();
                
            }else if(args[0].equals("B")){
                
                //Alert: Move the call of specificOperation to after the if statemente that instantiate App.
                output = app.specificOperation();
                
            }

        }
    }

}