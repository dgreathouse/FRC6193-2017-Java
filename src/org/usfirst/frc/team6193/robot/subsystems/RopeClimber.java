package org.usfirst.frc.team6193.robot.subsystems;

import org.usfirst.frc.team6193.robot.Cals;
import org.usfirst.frc.team6193.robot.OI;
import org.usfirst.frc.team6193.robot.Robot;
import org.usfirst.frc.team6193.robot.RobotMap;
import org.usfirst.frc.team6193.robot.commands.RopeClimberDefaultCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/** Rope Climber class
 * The rope climber is designed to connect to a rope and rasie the robot to touch a panel about 4 feet above the ground.<br>
 * A CIM motor with a 16:1 gearbox is used to rotate a 1/2 inch hex shaft. The hex<br>
 * shaft has a gravity engaged latch that holds the rope between the latch and hex shaft. As <br>
 * the shaft rotates the rope catches on itself and start winding on the shaft which raises the robot.<br><br>
 * 
 * Functionality provided by this class<br>
 * 1. Spin the shaft at a slow speed while a button on the copilot joystick is pressed.<br>
 * 2. Allow the shaft to spin at a high speed when a button is pressed on the copilot and the Y Axis goes in a positive direction.<br>
 * 
 * 
 */
public class RopeClimber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon m_ropeClimberMotorController;
	// Constructor for class
	public RopeClimber(){
		RopeClimberInit();
	}
    private void RopeClimberInit() {
		m_ropeClimberMotorController = new CANTalon(RobotMap.ROPECLIMBERCANTALONID);
		
	}

    public void Climb(){
    	if(Robot.oi.Logitech.getRawButton(OI.ROPECLIMBERSLOWBUTTONBUTTONID)){
    		m_ropeClimberMotorController.set(Cals.k_ropeClimberSlowSpeed);
    	}
    	if(Robot.oi.Logitech.getRawButton(OI.ROPECLIMBERFASTALLOWBUTTONID)){
    		double YAxis = Robot.oi.Logitech.getY();
    		YAxis = Math.abs(YAxis);
    		m_ropeClimberMotorController.set(YAxis);
    	}
    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RopeClimberDefaultCommand());
    }
}

