/* this class is to test petrol station classes
 * it may be used to test any implementation of PetrolStation class: Array or
 * ArrayList, etc.
 * This application has a DOS character-based user interface
*/

import java.io.*;
import java.util.*;

class MainMenu
{
    //example of using KeyboardInput class methods
    
    //create a new station
    static PetrolStation myStation = new PetrolStation("Holloway Road");
    
    //displaying menu
    public static void main (String[] args)
    {
        //display menu options and accept user choice
        int mnuOption=99;
        do
        {
            System.out.println("\n\nWellcome to the " + myStation.getStationName() +
                " petrol station...\n");
            System.out.println("  1. Add a new pump");
            System.out.println("  2. Remove a pump");
            System.out.println("  3. List all pumps");
            System.out.println("  4. Add a new transaction");
            System.out.println("  5. List all transactions of a pump");
            System.out.println("  6. Remove a pump's transactions before a certain time");
            System.out.println("  0. Exit");
            System.out.print("Key in a number to select an option: ");
            System.out.flush();
            //accept user selection
            
            try
            {
                mnuOption=KeyboardInput.getInt();
                
                //clean the screen
                clsScreen();
                
                //processing menu option
                switch(mnuOption)
                {
                    case 1: //execute option 1
                    addNewPump();
                    break;
                    case 2: //execute option 2
                    removeAPump();
                    break;
                    case 3: //execute option 3
                    listAllPumps();
                    break;
                    case 4: //
                    AddNewTransaction();
                    break;
                    case 5: //
                    ListPumpTransactions();
                    break;
                    case 6: //
                    RemovePumpTransactions();
                    break;
                    case 0: //execute option 0
                    System.out.println("Well done, your choice is " + mnuOption +
                        "\nProgram terminated.");
                    break;
                    default: //wrong number
                    System.out.println("No such menu option, please try again");
                    goBackToMenu();
                    break;
                }//~switch(mnuOption)...
            }//~try...
            
            catch(Exception e)
            {
                clsScreen();
                System.out.println("No such menu option, please try again");
                goBackToMenu();
            };
        }//~do...
        
        while (mnuOption!=0);
        System.exit(0);
    }//~public static void main ...
    
    protected static void clsScreen()
    {
        for (int lines=0;lines<24;lines++)
        System.out.println("");
    }
    
    protected static void goBackToMenu()
    {
        //processing menu option
        //System.out.println("Well done, your choice is " + mnuOption);
        System.out.println("\nHit Enter key to go back to the menu...");
        System.out.flush();
        try
        {
            char anyKey=KeyboardInput.getChar();
        }
        
        catch (Exception e)
        {
            clsScreen();
        }
        
        //clear screen
        clsScreen();
    }//~ static void go...
    
    //option 1
    private static void addNewPump()
    {
        System.out.print("Add a new pump...\nPlease enter a valid pump number: ");
        
        //ask for pump number
        int pumpNumber=0;
        try
        {
            pumpNumber = KeyboardInput.getInt();
            //create a new Pump object, which a linked list
            Pump aPump = new Pump(pumpNumber);
            myStation.addPump(aPump); //add to myStation
        }
        
        catch (Exception e)
        {
            System.out.println("Invalid pump number! Please try again.");
        }
    }//~private static void addN...
    
    //execute option 2
    private static void removeAPump()
    {
        System.out.print("Remove a pump...\nPlease enter a valid pump number: ");
        
        //ask for pump number
        int pumpNumber=0;
        try
        {
            pumpNumber = KeyboardInput.getInt();
            //get the pump with the entered pump number
            Pump aPump = myStation.getPump(pumpNumber);
            //then remove it
            myStation.removePump(aPump);
        }
        
        catch (Exception e)
        {
            System.out.println("Invalid pump number! Please try again.");
        }
    }//~private static void remo...
    
    //execute option 3
    private static void listAllPumps()
    {
        System.out.println("List all pumps...");
        
        //display (i.e. list) pumps of myStation
        
        int numOfPumps = myStation.listPumps().length; //note: not length()
        
        System.out.println("List of pumps of " + myStation.getStationName() +
            " petrol station...");
        
        for (int i=0; i<numOfPumps; i++)
        {
            //check if pump number i empty i.e. it has no transaction
            if (myStation.listPumps()[i] != null)
            {
                System.out.println("  Pump number: " +
                    myStation.listPumps()[i].getPumpNumber());
            }
        }
    }//~private static void list...
    
    //execute option 4
    private static void AddNewTransaction()
    {
        System.out.println("Add a new transaction to a pump...");
        System.out.println("Please enter a valid data below");
        
        //ask for pump number
        int pumpNumber=0;
        double TransVolume=0;
        double TransValue=0;
        try
        {
            System.out.print("  Pump number: ");
            pumpNumber = KeyboardInput.getInt();
            //get the pump with the entered pump number
            Pump aPump = myStation.getPump(pumpNumber);
            
            System.out.print("     Transaction Volume: ");
            TransVolume = KeyboardInput.getDouble();
            
            System.out.print("     Transaction Value: ");
            TransValue = KeyboardInput.getDouble();
            
            //create a transaction object
            Transaction aTrans= new Transaction(TransVolume, TransValue);
            aPump.add(aTrans); //append to the pump's linked list
            System.out.println(aPump.getLast());
            
        }//~try...
        
        catch (Exception e)
        {
            System.out.println("Invalid input data! Please try again.");
        }
    }//~private static void AddN...
    
    //execute option 5
    private static void ListPumpTransactions()
    {
        System.out.println("List the transactions of a pump...");
        
        System.out.print("Enter a valid pump number: ");
        //ask for pump number
        int pumpNumber=0;
        try
        {
            pumpNumber = KeyboardInput.getInt();
            int s = myStation.getPump(pumpNumber).size();
            System.out.println("This pump has " + s + " transactions, which are");
            
            //traverse the linked list using for loop with size()
            for(int i=0;i<s;i++)
            {
                System.out.println("  " + (i+1) + ". " +
                    myStation.getPump(pumpNumber).get(i));
            }
        }//~try...
        
        catch (Exception e)
        {
            System.out.println("Invalid pump number! Please try again.");
        }
    }//~private static void List...
    
    //execute option 6
    private static void RemovePumpTransactions()
    {
        System.out.println("Remove transactions of a pump before a certain time...");
        
        System.out.print("  Enter a valid pump number: ");
        //ask for pump number
        int pumpNumber=0;
        String timeString="";
        Date myTime;
        
        try
        {
            pumpNumber = KeyboardInput.getInt();
            
            //get time in hh:mm
            System.out.print("  Enter a valid time (hh:mm): ");
            timeString = KeyboardInput.getString();
            
            Pump selPump = myStation.getPump(pumpNumber);
            
            System.out.println("This pump has " + selPump.size() + " transactions before removal");
            
            //traverse the linked list using a java ListIterator 
            //get iterator
            ListIterator myIterator = selPump.listIterator();
            
            while (myIterator.hasNext())
            {
                // get item as an Object (because ListIterator.next() retruns a java Object
                // then cast to a Transaction object
                Transaction transObject = (Transaction)myIterator.next();
                
                if (transObject.getTransTime().compareTo(timeString) < 0)
                {
                    System.out.println(transObject + " is removed");
                    myIterator.remove();
                }
                
                else
                {                   
                    System.out.println(transObject + " will stay");
                }//~else...
            }//~while (myIterator.hasNex...
        }//~try...
        
        catch (Exception e)
        {
            System.out.println("Invalid pump number! Please try again.");
        }
    }//~private static void Remo...
}//end of class

