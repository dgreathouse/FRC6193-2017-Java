package org.usfirst.frc.team6193.robot;

public class InterpolateGetTime {
	
	/**
	 * 
	 * @param distance Inches
	 * 
	 * @param DriveY Drive
	 * @return Seconds to travel the requested distance.
	 */
	public  double getTimeDrive(double distance,double speed){
		
		double inchPerSec = LnrIntrpn(Cals.k_SpeedTable, Cals.k_InchPerSecDriveTable, speed);
		
		return distance/inchPerSec;
	}
	public  double getTimeSlide(double distance, double speed){
		
		double inchPerSec = LnrIntrpn(Cals.k_SpeedTable, Cals.k_InchPerSecSlideTable,  speed);
		
		return distance/inchPerSec;
	}
	private double LnrIntrpn(double[] XTbl, double[] YTbl, double Inp)
	{
		/* Local variables that only exist inside this method */
		int index;
		double Xdif;
		double Ydif;
		double XInpDif;
		
		/* Output variable */
		double Outp;
		
		/**/
		if(Inp <= XTbl[0]){
			Outp = XTbl[0];
		}else if(Inp >= XTbl[XTbl.length -1]){
			Outp = XTbl[XTbl.length -1];
		}else {
			index = 0;
			while(XTbl[index + 1] < Inp){
				index++;
			}
			Xdif = XTbl[index + 1] - XTbl[index];
			Ydif = YTbl[index + 1] - YTbl[index];
			XInpDif = Inp - XTbl[index];
			
			Outp = Ydif * XInpDif / Xdif + YTbl[index];
		}
		
		return Outp;
	}
	
}
