/* Java Array
* this implementation uses a Java Array to store Pump objects 
* definition of the PetrolStation class, implementing the
* PetrolStationADT interface
*/

import java.util.Arrays;

public class PetrolStation implements PetrolStationADT
{
    private String stationName;
    private Pump[] PumpArray; //an array of Pump object, each of which is a linked list
    private int NumberOfPumps = 10; //number of pumps of the petrol station
    
    /*constructor*/
    public PetrolStation(String station_name)
    {
        stationName = station_name;
        //construct an array of 10 elements to store 10 pumps
        PumpArray = new Pump[NumberOfPumps];
    }
    
    public String getStationName()
    {
        return stationName;
    }
    
    /* add a new pump*/
    public void addPump(Pump aPump)
    {
        // Note: aPump must have its pump number in valid range
        int pNum=aPump.getPumpNumber();
        
        PumpArray[pNum-1]=aPump; //pNum-1 because the array index starts at zero
        
    }//~public int addPump(int P...
    
    /* remove a pump*/
    public void removePump(Pump aPump)
    {
        PumpArray[aPump.getPumpNumber()-1] = null;
    }//~public int removePump(in...
    
    /* get a Pump given its number*/
    public Pump getPump(int PumpNo)
    {
        if (PumpNo < 0 || PumpNo > NumberOfPumps-1)
        {
            System.out.println("Pump number is out of range!");
            System.exit(0);
            return null; //for syntax correctness only
        }
        
        else
        return PumpArray[PumpNo-1];
    }//~public Pump getPump(int ...
    
    /* show the existing pumps*/
    public Pump[] listPumps()
    {
        return PumpArray;
    }
}//~public class PetrolStati...

