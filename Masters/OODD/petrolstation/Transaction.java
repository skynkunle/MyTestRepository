//package petrolstation;
// the Transaction class
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
/*
 * Transaction.java
 * Created on 10 November 2002, 20:48
 * @author  QD
*/
public class Transaction
{
    private String tTime;
    private double tVolume, tValue;
    
    /** Creates a new instance of Transaction, getting time from system current time */
    public Transaction(double aVolume, double aValue)
    {
        tVolume=aVolume;
        tValue=aValue;
        
        //set Transaction time to be system current time
        
        GregorianCalendar now = new GregorianCalendar();
        
        //to create a string representing a time as hh:mm
        DateFormat timeOnly=DateFormat.getTimeInstance(DateFormat.SHORT);
        tTime=timeOnly.format(new Date());
    }//~public Transaction(doubl...
    
    public String getTransTime()
    {
        return tTime;
    }
    
    public double getTransValue()
    {
        return tValue;
    }
    
    public String toString()
    {
        String callString=new String();
        return callString="Transaction time (hh:mm): " + tTime+", " + tVolume +" litres, GBP" + tValue;
    }
}//~public class Transaction...

