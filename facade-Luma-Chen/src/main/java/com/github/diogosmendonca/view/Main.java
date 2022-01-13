package com.github.diogosmendonca.view;

import com.github.diogosmendonca.control.*;
import java.util.*;

public class Main{

    private static List<String> output = new ArrayList<String>();

    public static void main(String[] args){
        String result = ControlFacade.studentSpecificService();
        System.out.println(result);
        output.add(result);
        result = ControlFacade.diciplineSpecificService();
        output.add(result);
        System.out.println(result);
    }

    public static List<String> getOutput(){
        return output;
    }

}