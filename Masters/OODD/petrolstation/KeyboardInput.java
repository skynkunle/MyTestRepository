//package petrolstation;

import java.io.*;
public class KeyboardInput {
// a class that provides methods for getting keyboard input of a string, a character, an integer and a double number
//inutting a String
public static String getString() throws IOException
  {
  InputStreamReader isr=new InputStreamReader(System.in);
  BufferedReader br = new BufferedReader(isr);
  String s=br.readLine();
  return s;
  }

  //inputting a Charcater
public static char getChar() throws IOException
  {
  String s=getString();
  return s.charAt(0);
  }

//Inputting Integers
public static int getInt() throws IOException
  {
  String s=getString();
  return Integer.parseInt(s); //convert String to type int
  }

//Inputting Floating-Point Numbers
public static double getDouble() throws IOException
  {
  String s=getString();
  Double aDub=Double.valueOf(s);
  return aDub.doubleValue();
  }
}
