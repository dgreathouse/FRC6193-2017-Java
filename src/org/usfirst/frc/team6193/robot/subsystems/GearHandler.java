package org.usfirst.frc.team6193.robot.subsystems;

import org.usfirst.frc.team6193.robot.Cals;
import org.usfirst.frc.team6193.robot.OI;
import org.usfirst.frc.team6193.robot.Robot;
import org.usfirst.frc.team6193.robot.RobotMap;
import org.usfirst.frc.team6193.robot.commands.GearHandlerDefaultCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/** Gear Handler class
 *
 * The gear handler is a side mounted gear grabber that picks up a gear off the floor.<br>
 * The GearHandler has one motor that spins one gear that is driving another identical gear.<br>
 * On the bottom of each gear there is a 3 inch post that pinches the field gear when the gears are spinning.<br>
 * The motor controllers are set with a current limit that holds the gear pinched between the two posts.<br>
 * Another motor is used to rotate the field gear by rotating the gear pinchers.  <br><br>
 * 
 * Both motors are window motors from the KOP.  We understand these are not the most reliable motors.<br>
 * We have many spares and need a little experience with using these motors. Space constraints were one <br>
 * of the deciding factors for using the window motors.<br>
 * Both motors are attached to 1/2 inch hex shafts using custom made adapters that connect to the <br>
 * window motor 7 tooth gear.<br><br>
 * 
 * Control of the motors are done through the current reading supplied by the CAN based TalonSRX.  <br><br>
 * 
 * Functionality provided by this class<br><br>
 * 1. Handle the gear using the joystick to start the spinners and rotate the mechanism. A button has been<br>
 * supplied that must be pressed to allow the spinners to spin and the copilot joystick x axis allow the mechanism<br>
 * to rotate. <br>
 * 
 * 2. Autonomous handling of gear giving arguments for spin speed, rotate speed, spin current limit, and rotate current limit
 */
public class GearHandler extends Subsystem {

	private CANTalon m_gearHandlerSpinnerMotorController;
	private CANTalon m_gearHandlerRotateMotorController;
	// Constructor for class
	public GearHandler(){
		GearHandlerInit();
	}
    private void GearHandlerInit() {
		m_gearHandlerSpinnerMotorController = new CANTalon(RobotMap.GEARHANDLERSPINNERCANTONID);
		m_gearHandlerRotateMotorController = new CANTalon(RobotMap.GEARHANDLERROTATECANTONID);
	}
    public void HandleGear(){
    	double spinnerMotorCurrent = m_gearHandlerSpinnerMotorController.getOutputCurrent();
    	double rotatMotorCurrent = m_gearHandlerRotateMotorController.getOutputCurrent();

    	if(Robot.oi.Logitech.getRawButton(OI.GEARHANDLERSPINNERBUTTONNUM)){
    		if(spinnerMotorCurrent < Cals.k_gearGrabberSpinnerHoldCurrent){
    			m_gearHandlerSpinnerMotorController.set(Cals.k_gearHandlerSpinnerSpeed);
    		}
    		if(rotatMotorCurrent < Cals.k_gearGrabberRotateHoldCurrent){
    			m_gearHandlerRotateMotorController.set(Robot.oi.Logitech.getX());
    		}
    	}
    }
    /**
     * 
     * @param spinSpeed The gears spinner speed to spin -1.0 (CCW) to 1.0 (CW)
     * @param rotateSpeed The rotate speed from -1.0 (CCW) to 1.0 (CW)
     * @param currentLimitSpin The current limit to set on the CANTalon in amps and integer, 1,2,3,4,5...
     * @param currentLimitRotate The current limit to set on the CANTalon in amps and integer, 1,2,3,4,5...
     */
    public void HandleGear(double spinSpeed, double rotateSpeed, int currentLimitSpin, int currentLimitRotate){
    	Spin(spinSpeed, currentLimitSpin);
    	Rotate(rotateSpeed, currentLimitRotate);
    }
    public void Spin(double speed, int currentLimit){
    	m_gearHandlerSpinnerMotorController.EnableCurrentLimit(true);
    	m_gearHandlerSpinnerMotorController.setCurrentLimit(currentLimit);
    	m_gearHandlerSpinnerMotorController.set(speed);
    }
    public void Rotate(double speed, int currentLimit){
    	m_gearHandlerRotateMotorController.EnableCurrentLimit(true);
    	m_gearHandlerRotateMotorController.setCurrentLimit(currentLimit);
    	m_gearHandlerRotateMotorController.set(speed);
    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GearHandlerDefaultCommand());
    }
}

