package home;

public class Test {
	 static EnumStageType type;
	 DataInterface StageInstance;
	/**
	 * @param args
	 */
	//int number_of_parameters = 11;
	//int[] values_stage = new int[11];
	//boolean return_flag;
	boolean normalswitchoff = false;
	boolean aircraftcraching = false;
	double Vmaxtax;
	double Vmintax;
	double Vmaxtak;
	double Vmintak;
	double Vmaxcr;
	double Vmincr;
	double Vmaxl;
	double Vminl;
	double DAmintak;
	double DAmaxtak;
	double DAmincr;
	double DAmaxcr;
	double RATE;
	double Vias;
	 
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		public  DataInterface getStage(EnumStageType stage){
			
			
			switch(stage){
			case TaxiOut:

				StageInstance = new TaxiOut();
				break;
			case Takeoff:
				
				StageInstance = new Takeoff();
				break;
			case Cruise:
				StageInstance = new Cruise();
				break;
			case Descent:

				StageInstance = new Descent();
				break;
			case Landing:

				StageInstance = new Landing();
				break;
			default:
			
			}
			return StageInstance;
			
		}
		public static void main(String args[]){
			Test test = new Test();
			while (switchoff != true & aircraftcraching != true)
			{
				for (int T = 125; T < 18000000; T++)
				{
					if ((Vmaxtax < Vias && Vias < Vmintax) & DA == 0)
						test.getStage(type.TaxiOut).fileAccess();

					if ((Vmaxtax < Vias && Vias <= Vmintak) & (Dmintak < DA && DA < DAmincr))
						test.getStage(type.Takeoff).fileAccess();

					if ((Vmincr < Vias && Vias < Vmaxcr) & (Dmincr < DA && DA < DAmaxcr))
						test.getStage(type.Cruise).fileAccess();

					if ((Vmincr < Vias && Vias < Vmaxcr) & (Dmincr < DA && DA < DAmaxcr))
						test.getStage(type.Descent).fileAccess();

					if ((Vmaxtax < Vias && Vias < Vmintax) & DA == 0)
						test.getStage(type.Landing).fileAccess();
				}
			}

		}
		
	

}
