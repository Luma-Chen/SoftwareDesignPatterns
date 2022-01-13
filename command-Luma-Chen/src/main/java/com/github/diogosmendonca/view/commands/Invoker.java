package com.github.diogosmendonca.view.commands;
import java.util.*;

public class Invoker {
  public static Map <String, Command> comandos = new HashMap<String, Command>();

  static {
      comandos.put("firstSpecificCommand", new FirstSpecificCommand());
      comandos.put("secondSpecificCommand", new SecondSpecificCommand());
  };

  public static String invoke(String command){
      String c = comandos.get(command).execute();
      return c;    
  }
}