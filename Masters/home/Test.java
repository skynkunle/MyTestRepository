

public class Test {
	 static EnumStageType type;
	 DataInterface StageInstance;
	/**
	 * @param args
	 */
	 
	 
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		public  DataInterface getStage(EnumStageType stage){
			
			switch(stage){
			
			case TaxiOut:
				
				System.out.println("TaxiOut");
			StageInstance = new TaxiOut(7.0,1.0,6.0,1.0,0.05,0.01,6.0,1.0,1.00,0.01,1000.0,20);
			
				break;
			
			case Takeoff:
				
				System.out.println("Takeoff");
			StageInstance = new Takeoff(7.0,1.0,6.0,1.0,0.05,0.01,6.0,1.0,1.00,0.01,30000.0,20);
				break;
				
			case Cruise:
				
				System.out.println("Cruise");
			StageInstance = new Cruise(7.0,1.0,6.0,1.0,0.05,0.01,6.0,1.0,1.00,0.01,30000.0,20);
				break;
				
			case Descent:
				
				System.out.println("Descent");
			StageInstance = new Descent(7.0,1.0,6.0,1.0,0.05,0.01,6.0,1.0,1.00,0.01,15000.0,20);
				break;
				
			case Landing:
				
				System.out.println("Landing");
			StageInstance = new Landing(7.0,1.0,6.0,1.0,0.05,0.01,6.0,1.0,1.00,0.01,1000.0,20);
				break;
			default:
			
			}
			return StageInstance;
			
		}
		public static void main(String args[])
			{
			Test test = new Test();
			
	 				 
			  test.getStage(type.TaxiOut).fileAccess();
			  
			  test.getStage(type.Takeoff).fileAccess();
			  
			  test.getStage(type.Cruise).fileAccess();
			  			  
			  test.getStage(type.Descent).fileAccess();
			  			  
			  test.getStage(type.Landing).fileAccess();
			  
		}
		 

}
