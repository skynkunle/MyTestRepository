


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Cruise implements DataInterface {
	
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
	private double DA = 0;
	private boolean flag = false;
	int TimeInterval;
	
	
	
	public Cruise(double gmax,double gmin,double wsmax,double wsmin,double wdmax,double wdmin, 
			double tasmax,double tasmin, double msmax, double msmin, double da, int t){
		
		this.GMAX = gmax;
		this.GMIN = gmin;
		this.WSMAX = wsmax;
		this.WSMIN = wsmin;
		this.WDMAX = wdmax;
		this.WDMIN = wdmin;
		this.TASMAX = tasmax;
		this.TASMIN = tasmin;
		this.MSMAX = msmax;
		this.MSMIN = msmin;
		this.DA = da;
		this.TimeInterval = t;
				
	}	
	
	public boolean fileAccess(){

		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream("C:\\home\\cruise.txt");
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
			if((30000 <= DA && DA <= 50000))
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


