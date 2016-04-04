/* definition of the Pump class, being implenmented as LinkedList
* Note: this class extends the Java LinkedList class so it inherits all the 
* methods of the java.util.LinkedList class. See the Sun java tutorials for
* the list of available methods and their usage (e.g. add, remove, etc.)
*/
class Pump extends java.util.LinkedList
{
    private int pumpNumber;
    
    //Important Note: this class extends the java.util.LinkedList, hence it inherits
    //all the methods of the LinkedList class e.g add(), get(), remove, and many
    //more. Consult the JDK help for the full list of methods.
    
    public Pump(int pump_No)
    {
        pumpNumber=pump_No;
        System.out.println("Pump number " + pumpNumber + " created");
    }
    
    public int getPumpNumber()
    {
		return pumpNumber;
    }
}

