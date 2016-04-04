

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TaxiOut implements DataInterface {
	
	private double GMAX;                           
	private double GMIN;
	private double WSMAX;
	private double WSMIN;
	private double WDMAX;
	private double WDMIN;
	private double TASMAX;
	private double TASMIN;
	private double MSMAX;
	private double MSMIN;
	private double DA;
	private boolean flag = false;
	int TimeInterval;
	
	
	
	public TaxiOut(double gmax,double gmin,double wsmax,double wsmin,double wdmax,double wdmin, 
			double tasmax,double tasmin, double msmax, double msmin, double da, int t){
		
		this.GMAX = gmax;        //maximum indicated airspeed
		this.GMIN = gmin;        //minimum indicated airspeed
		this.WSMAX = wsmax;      //maximum windspeed
		this.WSMIN = wsmin;      //minimum windspeed
		this.WDMAX = wdmax;      //maximum wind direction
		this.WDMIN = wdmin;      //minimum wind direction
		this.TASMAX = tasmax;    //maximum true airspeed
		this.TASMIN = tasmin;    //minimum true airspeed
		this.MSMAX = msmax;      //maximum  mach speed
		this.MSMIN = msmin;      //minimum  mach speed
		this.DA = da;            // density altitude  
		this.TimeInterval = t;   // time interval 
				
	}	
	
	public boolean fileAccess(){

		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream("C:\\home\\TaxiOut.txt");
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    //Read File Line By Line
		    while ((strLine = br.readLine()) != null )   {
		      // Print the content on the console
		    	String data[] = strLine.split("\t");
		    	
		    	double gs = Double.parseDouble(data[0]);
		    	double ws = Double.parseDouble(data[1]);
		    	double wd = Double.parseDouble(data[2]);
		    	double tas = Double.parseDouble(data[3]);
		    	double ms = Double.parseDouble(data[4]);
		    	double da = Double.parseDouble(data[5]);
		if(TimeInterval != 0)
		{
		    	if((GMIN <= gs && gs <= GMAX) & (WSMIN <= ws && ws <= WSMAX)  & (WDMIN <= wd && wd <= WDMAX) & (TASMIN <= tas && tas <= TASMAX) & (MSMIN <= ms && ms <= MSMAX)) 
		    	{
		    			
		    			flag = true;
		    	
		    			System.out.println(flag);
		    			System.out.println (gs +   " " + ws + " " + wd + " " + tas + " " + ms + " " + da +" "+TimeInterval);
		    			Thread.sleep(1000);
		    			TimeInterval--;
		    			
		      
		    	}else
		    	{
		    			flag = false;
		    			System.out.println(flag);
		    			return flag;
		    			
		    	}
		}else
		{
		    			flag = true;
		    			System.out.println(flag);
		    			return flag;
	    }
		    }
		    //Close the input stream
		    in.close();
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
	    }
	  
	
	return flag;
	
}
}

